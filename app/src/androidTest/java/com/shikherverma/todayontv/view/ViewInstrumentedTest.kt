import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * UI tests for [com.shikherverma.todayontv.view]
 */
@RunWith(AndroidJUnit4::class)
class ViewInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.shikherverma.todayontv", appContext.packageName)
    }
}
