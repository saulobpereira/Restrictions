package com.restrictions.usecases.checkProductRestriction

import com.restrictions.gateways.RestrictionGatewaySpy
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert.assertEquals


object CheckProductRestrictionTest : Spek({
    val presenterSpy = CheckProductRestrictionPresenter()
    describe("Check product restriction use case"){
        val checker = CheckProductRestriction(RestrictionGatewaySpy())
        on("Check a product with restriction"){
            val input = CheckProductRestrictionRequestModel("p1", "r1")
            checker.check(input, presenterSpy)
            val isRestricted = presenterSpy.model.restricted

            it("Should return true for this parameters "){
                assertEquals(true, isRestricted)
            }
        }
        on("Check a product without restriction"){
            val input = CheckProductRestrictionRequestModel("p1", "r5")
            checker.check(input, presenterSpy)
            val isRestricted = presenterSpy.model.restricted

            it("Should return false for this parameters "){
                assertEquals(false, isRestricted)
            }
        }
    }
})