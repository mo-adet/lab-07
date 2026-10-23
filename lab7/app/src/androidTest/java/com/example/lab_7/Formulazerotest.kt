package com.example.lab_7

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    // Walkthrough test
    @Test
    fun navigate_to_races_add_race_and_return_home() {
        composeTestRule.onNodeWithTag("raceButton").performClick()
        composeTestRule.onNodeWithText("Upcoming Races").assertExists()

        composeTestRule.onNodeWithTag("locationInput").performTextInput("Canada")
        composeTestRule.onNodeWithTag("addRaceButton").performClick()
        composeTestRule.onNodeWithText("Canada").assertExists()

        composeTestRule.onNodeWithTag("backButton").performClick()
        composeTestRule.onNodeWithText("FormulaZero Home").assertExists()
    }

    // Participation exercise test
    @Test
    fun navigate_to_drivers_add_clear_and_return_home() {
        // HomeScreen -> DriversScreen
        composeTestRule.onNodeWithTag("driversButton").performClick()
        composeTestRule.onNodeWithText("FormulaZero Drivers").assertIsDisplayed()

        // add drivers and verify they are displayed
        composeTestRule.onNodeWithTag("driverInput").performTextInput("Max Verstappen")
        composeTestRule.onNodeWithTag("addDriverButton").performClick()
        composeTestRule.onNodeWithText("Max Verstappen").assertIsDisplayed()

        composeTestRule.onNodeWithTag("driverInput").performTextInput("Lewis Hamilton")
        composeTestRule.onNodeWithTag("addDriverButton").performClick()
        composeTestRule.onNodeWithText("Lewis Hamilton").assertIsDisplayed()

        // clear drivers and verify the list is empty
        composeTestRule.onNodeWithTag("clearDriversButton").performClick()
        composeTestRule.onNodeWithText("Max Verstappen").assertDoesNotExist()
        composeTestRule.onNodeWithText("Lewis Hamilton").assertDoesNotExist()

        // back button returns to HomeScreen
        composeTestRule.onNodeWithTag("driversBackButton").performClick()
        composeTestRule.onNodeWithText("FormulaZero Home").assertIsDisplayed()
    }
}