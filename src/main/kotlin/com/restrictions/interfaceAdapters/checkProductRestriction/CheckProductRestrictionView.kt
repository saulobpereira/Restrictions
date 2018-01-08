package com.restrictions.interfaceAdapters.checkProductRestriction

import com.restrictions.usecases.checkProductRestriction.CheckProductRestrictionViewModel

interface CheckProductRestrictionView {
    fun generateView(viewModel: CheckProductRestrictionViewModel): String
}