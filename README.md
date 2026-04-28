# Restrictions

Projeto de estudos sobre a aplicacao de conceitos de Clean Architecture em uma
API HTTP escrita em Kotlin.

O aplicativo gerencia restricoes associadas a produtos. Ele permite:

- consultar se um produto possui determinada restricao;
- associar uma restricao a um produto;
- expor esses casos de uso por endpoints HTTP simples.

## Arquitetura

O projeto esta organizado em dois modulos Gradle:

- `RestrictionsCore`: contem as regras de negocio, entidades, gateways e casos de
  uso. Este modulo nao depende do servidor HTTP.
- modulo raiz `restrictions`: contem a aplicacao Ktor, controllers HTTP,
  presenters, views e a implementacao em memoria dos gateways.

A organizacao segue a ideia central da Clean Architecture: o dominio e os casos
de uso ficam isolados de detalhes externos, enquanto a camada de aplicacao adapta
HTTP, apresentacao e persistencia para esses casos de uso.

### Camadas principais

#### Entidades

Local: `RestrictionsCore/src/main/kotlin/com/restrictions/entities`

- `Product`: representa um produto identificado por `code`.
- `Restriction`: representa uma restricao identificada por `code`.

#### Gateways

Local: `RestrictionsCore/src/main/kotlin/com/restrictions/gateways`

- `RestrictionGateway`: porta usada pelos casos de uso para buscar e associar
  restricoes.
- `ProductGateway`: porta para consulta de produtos. A interface existe no core,
  mas ainda nao possui implementacao concreta no modulo de aplicacao.

No modulo raiz existe a implementacao `InMemoryRestrictionsGateway`, que guarda
as associacoes em um `HashMap` em memoria.

#### Casos de uso

Local: `RestrictionsCore/src/main/kotlin/com/restrictions/usecases`

- `CheckProductRestriction`: verifica se uma restricao esta associada a um
  produto.
- `AssociateRestriction`: associa uma restricao a um produto.

Cada caso de uso usa modelos de entrada, modelos de resposta e boundaries
proprios, mantendo a regra de negocio separada da camada HTTP.

#### Interface adapters

Local: `src/main/kotlin/com/restrictions/interfaceAdapters`

Os adapters recebem parametros HTTP, constroem os request models dos casos de uso,
acionam os presenters e devolvem strings geradas pelas views.

- `CheckProductRestrictionController`
- `CheckProductRestrictionPresenter`
- `CheckProductRestrictionViewImpl`
- `AssociateRestrictionController`
- `AssociateRestrictionPresenter`
- `AssociateRestrictionViewImpl`

#### Aplicacao HTTP

Local: `src/main/kotlin/com/restrictions/application/RestrictionsApp.kt`

A aplicacao Ktor cria as dependencias em memoria, registra os controllers e sobe
um servidor Netty na porta `8080`.

## Endpoints

### `GET /`

Retorna uma mensagem simples de identificacao do servico.

Resposta:

```text
Restrictions Service
```

### `GET /CheckProductRestriction`

Consulta se um produto possui uma restricao.

Parametros:

- `productCode`: codigo do produto.
- `restrictionCode`: codigo da restricao.

Exemplo:

```http
GET /CheckProductRestriction?productCode=3030&restrictionCode=5050
```

Possiveis respostas:

```text
Existe restricao para o consumo deste produto
```

```text
Nao existe restricao cadastrada para o produto consultado
```

```text
Nao foi possivel executar a operacao solicitada. Verifique os parametros
```

### `POST /AssociateRestriction`

Associa uma restricao a um produto.

Parametros:

- `productCode`: codigo do produto.
- `restrictionCode`: codigo da restricao.

Exemplo:

```http
POST /AssociateRestriction?productCode=3030&restrictionCode=9090
```

Possiveis respostas:

```text
Restricao associada com sucesso
```

```text
Houve problema na associacao da restricao
```

## Dados iniciais

A implementacao em memoria inicia com o produto `3030` associado as restricoes
`5050` e `4040`.

Esses dados ficam apenas em memoria. Ao reiniciar a aplicacao, associacoes feitas
durante a execucao sao perdidas.

## Frameworks e bibliotecas

- Kotlin `1.2.10`: linguagem principal do projeto.
- Gradle `4.0`: ferramenta de build, via Gradle Wrapper.
- Ktor `0.9.0`: framework HTTP usado para expor a API.
- Netty: engine usada pelo Ktor para executar o servidor.
- Logback `1.2.1`: logging da aplicacao.
- JUnit `4.12`: biblioteca de assercoes usada nos testes.
- Spek `1.1.5`: framework de especificacao/testes usado no modulo core.
- JUnit Platform Gradle Plugin `1.0.0`: plugin usado para executar os testes Spek.

## Estrutura de diretorios

```text
.
|-- build.gradle
|-- settings.gradle
|-- RestrictionsCore
|   |-- build.gradle
|   `-- src
|       |-- main/kotlin/com/restrictions
|       |   |-- entities
|       |   |-- gateways
|       |   `-- usecases
|       `-- test/kotlin/com/restrictions
`-- src
    `-- main
        |-- kotlin/com/restrictions
        |   |-- application
        |   |-- gateways
        |   |-- http
        |   `-- interfaceAdapters
        `-- resources
```

## Como executar

O ponto de entrada da aplicacao e a funcao `main` em:

```text
src/main/kotlin/com/restrictions/application/RestrictionsApp.kt
```

Ela inicia um servidor Netty na porta `8080`.

O projeto ainda nao configura o plugin `application` do Gradle, portanto nao ha
uma task `run` declarada. A forma mais direta de execucao e pela IDE, rodando a
funcao `main` de `RestrictionsApp.kt`.

## Como testar

Os testes do modulo core validam os principais casos de uso:

- consulta de produto com restricao;
- consulta de produto sem restricao;
- associacao de restricao a produto.

Para executar:

```bash
./gradlew test
```

No Windows:

```powershell
.\gradlew.bat test
```

## Observacoes

- A persistencia atual e apenas em memoria.
- As respostas HTTP sao strings em texto simples, nao JSON.
- Os parametros sao lidos a partir dos parametros da requisicao.
- O projeto tem foco didatico em Clean Architecture, nao em infraestrutura de
  producao.
