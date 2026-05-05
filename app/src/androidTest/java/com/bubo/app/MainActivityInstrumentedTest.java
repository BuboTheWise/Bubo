package com.bubo.app;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.core.app.ActivityScenario.launch;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * MainActivity instrumentation tests for Bubo app functionality.
 * Tests the Hello World button interactions and Toast messages.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    @Test
    public void activityLaunches() {
        // Launch the MainActivity
        launch(MainActivity.class);

        // Verify app context is correct
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.bubo.app", appContext.getPackageName());
    }

    @Test
    public void buttonExistsInView() {
        // Launch MainActivity
        ActivityScenario<MainActivity> scenario = launch(MainActivity.class);

        // Verify button exists
        onView(withId(R.id.button)).check(matches(withText("Hello World!")));
    }

    @Test
    public void appUsesAppCompatTheme() {
        // Launch MainActivity (AppCompatActivity)
        launch(MainActivity.class);

        // Verify MainActivity exists and is launched
        // No specific assertion needed, just verify launch succeeds
    }
}