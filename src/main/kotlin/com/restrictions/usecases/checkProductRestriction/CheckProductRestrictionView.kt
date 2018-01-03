package com.restrictions.usecases.checkProductRestriction

interface CheckProductRestrictionView {
    fun generateView(viewModel: CheckProductRestrictionViewModel): String
}