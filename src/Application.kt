package com.training

import com.google.gson.Gson
import io.ktor.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {

    val response = generateScreenNames("iOS", "Splash Screen File")

    println("=========== Output Start ===========")
    println(Gson().toJson(response)).toString();
    println("=========== Output End ===========")

}

