package com.restrictions.application

import com.restrictions.http.ParametersParser
import com.restrictions.implementations.InMemoryRestrictionsGateway
import com.restrictions.usecases.associateRestriction.AssociateRestriction
import com.restrictions.usecases.associateRestriction.AssociateRestrictionController
import com.restrictions.usecases.associateRestriction.AssociateRestrictionPresenter
import com.restrictions.usecases.associateRestriction.AssociateRestrictionViewImpl
import com.restrictions.usecases.checkProductRestriction.CheckProductRestriction
import com.restrictions.usecases.checkProductRestriction.CheckProductRestrictionController
import com.restrictions.usecases.checkProductRestriction.CheckProductRestrictionPresenter
import com.restrictions.usecases.checkProductRestriction.CheckProductRestrictionViewImpl
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

class RestrictionsApp {
}

fun Application.module() {
    val restrictionsGateway = InMemoryRestrictionsGateway()
    val checkProductRestrictionController = CheckProductRestrictionController(
            CheckProductRestriction(restrictionsGateway),
            CheckProductRestrictionPresenter(),
            CheckProductRestrictionViewImpl())

    val associateRestrictionController = AssociateRestrictionController(
            AssociateRestriction(restrictionsGateway),
            AssociateRestrictionPresenter(),
            AssociateRestrictionViewImpl()
    )
    install(DefaultHeaders)
    install(CallLogging)
    install(Routing) {
        get("/") {
            call.respondText("Restrictions Service", ContentType.Text.Html)
        }
        get("/CheckProductRestriction") {
            call.respondText(checkProductRestrictionController.handle(ParametersParser.parse(call.parameters)), ContentType.Text.Html)
        }
        post("/AssociateRestriction") {
            call.respondText(associateRestrictionController.handle(ParametersParser.parse(call.parameters)), ContentType.Text.Html)
        }
    }
}

fun main(args: Array<String>) {
    embeddedServer(Netty, 8080, watchPaths = listOf("RestrictionsAppKt"), module = Application::module).start()
}