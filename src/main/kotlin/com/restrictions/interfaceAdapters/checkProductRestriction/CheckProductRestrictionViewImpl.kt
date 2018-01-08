package com.restrictions.interfaceAdapters.checkProductRestriction

import com.restrictions.usecases.checkProductRestriction.CheckProductRestrictionViewModel

class CheckProductRestrictionViewImpl: CheckProductRestrictionView {
    override fun generateView(viewModel: CheckProductRestrictionViewModel): String {
        return viewModel.getMessage()
    }
}