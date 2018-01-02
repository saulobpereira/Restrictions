package com.restrictions.usecases.checkProductRestriction

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert.assertEquals


object CheckProductRestrictionTest : Spek({
    describe("Check product restriction"){
        val checker = CheckProductRestriction()
        on("Check a product with restriction"){
            val input = CheckProductRestrictionRequestModel("p1", "r1")
            val isRestricted = checker.check(input).isRestricted()

            it("Should return true for this parameters "){
                assertEquals(true, isRestricted)
            }
        }
    }

})