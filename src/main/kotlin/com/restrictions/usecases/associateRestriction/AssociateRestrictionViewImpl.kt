package com.restrictions.usecases.associateRestriction

class AssociateRestrictionViewImpl:AssociateRestrictionView {
    override fun generateView(viewModel: AssociateRestrictionViewModel): String {
        if (viewModel.success){
            return "Restrição associada com sucesso"
        }else{
            return "Houve problema na associação da restrição"
        }
    }
}