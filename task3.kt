import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
   runBlocking {
        var noOfCarsToBuild = 100_000;
        buildTeslaCars(noOfCarsToBuild)
    }
}


suspend fun buildTeslaCars(noOfCarsToBuild: Int) = coroutineScope {
    var i:Double = 0.0
    var start: Long = 0
    var end: Long = 0
    var k = launch {
        start = System.currentTimeMillis()
        repeat(noOfCarsToBuild) { // launch a lot of coroutines
            launch {
                delay(5000L) // Build body of car
                delay(5000L) // Painting a car
                delay(10000L) // Install drive train
                delay(15000L) // Install batteries
                delay(15000L) // Install interior of car
                i++
            }
        }
    }
    launch {
        delay(60000L) // Terminate car building process after 60 sec.
        end = System.currentTimeMillis()
        k.cancel()
        var diff: Long = end - start
        var avg: Double = diff/i
        println("Total car builds : $i")
        println("Start time : $start")
        println("End time : $end")
        println("Total time taken to builds($i) cars: $diff MS")
        println("Total time taken to build a single car: $avg MS")
    }
}
