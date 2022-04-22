package com.training

import com.google.gson.Gson

fun generateScreenNames(technology: String, screenName: String): String? {

    require(validateString(screenName)) { "Screen name must contain only a-z or A-Z alphabets." }

    val response: ITech = when(technology) {
        "Android" -> android(screenName)
        "Flutter" -> flutter(screenName)
        "iOS" -> iOS(screenName)
        else -> ErrResponse("BAD_REQUEST", "Invalid technology")
    }
    return Gson().toJson(response).toString()
}

fun android(screenName: String): AndroidNames {

    val layoutName: String = toUnderScore(screenName, "activity")
    val controllerName: String = toCamelCase(screenName, "Activity")
    val modelName: String = toCamelCase(screenName, "Model")
    return AndroidNames(layoutName, controllerName, modelName)
}

fun flutter(screenName: String): FlutterNames {
    val layoutName: String = toUnderScore(screenName, "screen")
    val controllerName: String = toUnderScore(screenName, "controller")
    val modelName: String = toUnderScore(screenName, "model")
    return FlutterNames(layoutName, controllerName, modelName)
}

fun iOS(screenName: String): IOSNames {
    val viewName: String = toCamelCase(screenName, "View")
    val viewModelName: String = toCamelCase(screenName, "ViewModel")
    return IOSNames(viewName, viewModelName)
}

fun toUnderScore(str: String, appendString: String?): String {
    return "${str.replace(" ", "_").toLowerCase()}_$appendString"
}
fun toCamelCase(str: String, appendString: String?): String {
    return str.split(" ").map { it.capitalize() }.joinToString("") + appendString
}

fun validateString(screenName: String): Boolean {
    for (c in screenName) {
        if (c !in 'A'..'Z' && c !in 'a'..'z' && c !in " ") {
            return false
        }
    }
    return true
}

interface ITech {}

data class AndroidNames(
    val layoutName: String,
    val controllerName: String,
    val modelName: String
): ITech

data class FlutterNames(
    val layoutName: String,
    val controllerName: String,
    val modelName: String
): ITech

data class IOSNames(
    val viewName: String,
    val viewModelName: String
): ITech

data class ErrResponse(
    val code: String,
    val message: String
): ITech