package com.sarang.torang

import com.google.gson.GsonBuilder

fun prettyPrint(src : Any) {
    println(GsonBuilder().setPrettyPrinting().create().toJson(src))
}