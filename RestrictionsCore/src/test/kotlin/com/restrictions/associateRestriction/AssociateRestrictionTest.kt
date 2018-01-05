package com.restrictions.associateRestriction

import com.restrictions.gateways.RestrictionGatewaySpy
import com.restrictions.usecases.associateRestriction.AssociateRestriction
import com.restrictions.usecases.associateRestriction.AssociateRestrictionRequestModel
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert

object AssociateRestrictionTest: Spek({
    describe("Associate restriction use case"){
        val presenter = AssociateRestrictionPresenterSpy()
        val restrictor = AssociateRestriction(RestrictionGatewaySpy())
        on("Associate a restriction to a product"){
            val input = AssociateRestrictionRequestModel("p7", "r7")
            restrictor.associate(input, presenter)
            val isSuccessful = presenter.getViewModel().success

            it("Should return true for this parameters "){
                Assert.assertEquals(true, isSuccessful)
            }
        }
    }
})