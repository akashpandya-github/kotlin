import org.junit.Test

class PlayGround {

    @Test
    fun toScreenName(){
        val test = "fsdhg dsgs d sdgd".split(" ").map {
            it.capitalize()
        }.joinToString("")
        println("-------------\n")
        println(test)
        println("\n-------------")
    }
}