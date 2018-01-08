package com.restrictions.interfaceAdapters.associateRestriction

import com.restrictions.usecases.associateRestriction.AssociateRestrictionViewModel

class AssociateRestrictionViewImpl: AssociateRestrictionView {
    override fun generateView(viewModel: AssociateRestrictionViewModel): String {
        if (viewModel.success){
            return "Restrição associada com sucesso"
        }else{
            return "Houve problema na associação da restrição"
        }
    }
}