import com.training.generateScreenNames
import org.junit.Test
import kotlin.test.*

internal class TestCasesKtTest {

    @Test
    fun generateScreenNamesWrongTech() {
        val expected = "{\"code\":\"BAD_REQUEST\",\"message\":\"Invalid technology\"}"
        assertEquals(expected, generateScreenNames("React", "Splash Screen File"))
    }

    @Test
    fun generateScreenNamesNotNull() {
        assertNotNull(generateScreenNames("iOS", "Splash Screen File"))
    }

    @Test
    fun generateScreenNames() {
        val expected = "{\"code\":\"BAD_REQUEST\",\"message\":\"Invalid technology\"}"
        assertNotEquals(expected, generateScreenNames("iOS", "Splash Screen File"))
    }

    @Test
    fun generateScreenNamesExactMatch() {
        val expected = "{\"viewName\":\"SplashScreenFileView\",\"viewModelName\":\"SplashScreenFileViewModel\"}"
        assertEquals(expected, generateScreenNames("iOS", "Splash Screen File"))
    }
}