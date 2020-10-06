package io.github.erikjhordanrey.atp_rankings_di.screenshot

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.karumi.shot.ScreenshotTest
import com.karumi.shot.waitForActivity
import org.junit.After
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
abstract class ScreenShotShould<T : Activity>(private val clazz: Class<T>) : ScreenshotTest {
    private var scenario: ActivityScenario<T>? = null

    @After
    fun tearDown() {
        scenario?.close()
        Intents.release()
    }

    fun startActivity(args: Bundle = Bundle()): T {
        val intent = Intent(ApplicationProvider.getApplicationContext(), clazz)
        intent.putExtras(args)
        scenario = ActivityScenario.launch(intent)
        return scenario!!.waitForActivity()
    }
}
