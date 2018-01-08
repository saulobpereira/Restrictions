package com.restrictions.interfaceAdapters.associateRestriction

import com.restrictions.usecases.associateRestriction.AssociateRestrictionViewModel

interface AssociateRestrictionView {
    fun generateView(viewModel: AssociateRestrictionViewModel): String
}