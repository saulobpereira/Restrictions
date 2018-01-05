package com.restrictions.usecases.checkProductRestriction

class CheckProductRestrictionViewModel{
    companion object {
        var MSG_RESTRICTED = "Existe restrição para o consumo deste produto"
        var MSG_NOT_RESTRICTED = "Não existe restrição cadastrada para o produto consultado"
        var MSG_ERROR = "Não foi possível executar a operação solicitada. Verifique os parâmetros"

    }
    var error: Boolean = false
    var restricted: Boolean = true

    fun getMessage(): String{
        if(error) {
            return MSG_ERROR
        }else{
            if (restricted){
                return MSG_RESTRICTED
            }else{
                return MSG_NOT_RESTRICTED
            }
        }
    }

}