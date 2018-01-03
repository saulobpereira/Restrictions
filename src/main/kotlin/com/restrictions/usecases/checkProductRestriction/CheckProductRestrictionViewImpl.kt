package com.restrictions.usecases.checkProductRestriction

class CheckProductRestrictionViewImpl: CheckProductRestrictionView {
    override fun generateView(viewModel: CheckProductRestrictionViewModel): String {
        when(viewModel.restricted){
            true -> return  "Existe restrição para o consumo deste produto"
            false -> return "Não existe restrição cadastrada para o produto consultado"
        }
    }
}