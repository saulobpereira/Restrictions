package com.restrictions.http

import io.ktor.util.ValuesMap

class ParametersParser {
    companion object {
        fun parse(requestParameters: ValuesMap): Parameters {
            var map: HashMap<String, String> = hashMapOf()
            requestParameters.forEach { paramName, values ->
                map.put(paramName, values[0])
            }
            return  Parameters(map)
        }
    }
}