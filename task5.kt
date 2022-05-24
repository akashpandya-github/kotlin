fun main() {
    
   val latte: String = "Latte"
   val cappuccino: String = "Cappuccino"
   val black: String = "Black"
   
    CoffeeMaker().brew(black)
}

class CoffeeMaker {
    
    fun brew(coffeeType: String) {
        
        // Coffee making process
        val coffeeProcess = ElectricHeater().isHeating("on")
        if(coffeeProcess == true) {
         	println("$coffeeType Coffee's Ready! Enjoy")   
        }
    }
}

class ElectricHeater {
    
    fun on() {
        println("Electric heater started...!!")
        Pumping().pump()
    }
    
    fun off() {
        println("Electric heater Off....!!")
    }
    
    fun isHeating(type: String): Boolean {
        if(type == "on") {
            on()
         	return true   
        } else {
            off()
            return false
        }
    }
}

class Pumping {
    fun pump() {
        println("Pumping started...!!")
    }
}
