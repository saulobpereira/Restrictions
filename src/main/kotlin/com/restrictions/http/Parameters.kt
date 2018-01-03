package com.restrictions.http

data class Parameters(var map: Map<String,String>){
    fun get(key: String): String{
        return map.get(key)?:""
    }
}