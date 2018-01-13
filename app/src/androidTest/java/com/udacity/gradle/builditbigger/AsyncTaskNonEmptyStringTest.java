package com.udacity.gradle.builditbigger;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.core.IsNot;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Dharmaraj on 04-10-2017.
 */

@RunWith(AndroidJUnit4.class)
public class AsyncTaskNonEmptyStringTest {


    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);


    private IdlingResource mIdlingResource;


    @Before
    public void registerIdlingResource() {
        mIdlingResource = mainActivityActivityTestRule.getActivity().getIdlingResource();
        // To prove that the test fails, omit this call:
        IdlingRegistry.getInstance().register(mIdlingResource);
    }

    @Test
    public void idlingResourceTest_and_VerifyingString() {
       Espresso.onView(ViewMatchers.withId(R.id.tell_joke_btn)).perform(ViewActions.click());
//        Espresso.onView(ViewMatchers.withId(R.id.displayJoke_tv)).check(ViewAssertions.matches(CoreMatchers.notNullValue()));
//        (ViewAssertion) CoreMatchers.not(ViewMatchers.withText(""))
        Espresso.onView(ViewMatchers.withId(R.id.displayJoke_tv)).check(ViewAssertions.matches(IsNot.not(ViewMatchers.withText(""))));
//
//        Intents.intended(AllOf.allOf(hasExtras(BundleMatchers.hasEntry("joke", CoreMatchers.notNullValue()))));

       }



    // Remember to unregister resources when not needed to avoid malfunction.
    @After
    public void unregisterIdlingResource() {
        if (mIdlingResource != null) {
            IdlingRegistry.getInstance().unregister(mIdlingResource);
        }
    }

}