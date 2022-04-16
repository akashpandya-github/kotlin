/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main(args: Array<String>) {
        
    	val trains = mapOf(
            '0' to mutableListOf("Train1", "Surat", "Ahmedabad", "10:00AM"),
            '1' to mutableListOf("Train2", "Pune", "Delhi", "11:00AM"),
    		'2' to mutableListOf("Train3", "Baroda", "Goa", "12:00AM"),
        )
                
       	val getIndex: Int = when(args[0]) {
            "name" -> 0
            "source" -> 1
            "destination" -> 2
            "time" -> 3
            else -> -1
        }		
        
        var result: Boolean = false
    	for ((key, value) in trains) {
            result = getTrains(args[1], getIndex, value)
            if(result) {
             	println("Train Details : $value")
            }
        }    
   }

fun getTrains(value: String, index: Int, train: MutableList<String>): Boolean {
    for (arrIndex in train.indices) {
        if(arrIndex === index && train[arrIndex].uppercase() == value.uppercase()) {
        	return true
        }
    }
    return false
}
