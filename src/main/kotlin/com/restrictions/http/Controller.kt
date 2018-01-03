package com.restrictions.http

interface Controller {
    fun handle(parameters: Parameters): String
}