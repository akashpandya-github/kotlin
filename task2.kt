/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main(args: Array<String>) {
    when (args[0]) {
        "1" -> GetTea("Tea").getBeverage()
        "2" -> GetCoffee("Coffee").getBeverage()
    }
}
abstract class MakeBeverages(val name: String) : IGetBeverage {
    open fun hotWater() {
        println("Adding hot water...")
    }

    open fun hotMilk() {
        println("Adding hot milk...")
    }

    open fun sugar() {
        println("Adding hot sugar...")
    }

    override fun cleanPot() {
        println("Cleaning $name pot...")
        println("Your Beverage is getting ready...")
    }

    override fun getMixture() {
        hotWater()
        hotMilk()
        sugar()
        addIngredients()
    }
    override fun beverageReady() {
        println("$name is ready! Enjoy")
    }

    override fun addIngredients() {
        println("$name bag added...")
    }
}

interface IGetBeverage {
    fun cleanPot() {}
    fun addIngredients() {}
    fun getMixture() {}
    fun beverageReady() {}
    fun getBeverage() {
        cleanPot()
        getMixture()
        beverageReady()
    }
}

class GetTea(type: String) : MakeBeverages(type) {}

class GetCoffee(type: String) : MakeBeverages(type) {}
