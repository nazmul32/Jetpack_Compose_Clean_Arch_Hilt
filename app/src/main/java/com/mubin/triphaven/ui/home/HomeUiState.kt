package com.mubin.triphaven.ui.home

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.mubin.triphaven.base.utils.logger.GzLogger
import com.mubin.triphaven.data.model.DestinationResponse

/**
 * A state holder class for the Home UI.
 * This class uses Compose's `mutableStateOf` to observe and react to changes in the UI state.
 *
 * Variables:
 * - `query`: Stores the search query entered by the user.
 * - `isLoading`: Indicates if the UI is in a loading state.
 * - `hideBottomNav`: Controls the visibility of the bottom navigation bar.
 * - `response`: Holds the API response or data for destinations.
 */
@SuppressLint("MutableCollectionMutableState")
class HomeUiState {

    // The current search query entered by the user
    var query by mutableStateOf("")
        private set // Prevent direct external modification

    // Indicates whether a loading indicator should be displayed
    var isLoading by mutableStateOf(false)
        private set

    // Controls the visibility of the bottom navigation bar
    var hideBottomNav by mutableStateOf(false)
        private set

    // Holds the API response or the list of destinations
    var response: DestinationResponse? by mutableStateOf(null)
        private set

    /**
     * Updates the search query and logs the change.
     *
     * @param value The new search query.
     */
    fun updateQuery(value: String) {
        query = value
        GzLogger.d("HomeUiState", "Query updated to: $value")
    }

    /**
     * Updates the loading state and logs the change.
     *
     * @param value The new loading state.
     */
    fun setIsLoading(value: Boolean) {
        isLoading = value
        GzLogger.d("HomeUiState", "Loading state updated to: $value")
    }

    /**
     * Updates the visibility of the bottom navigation bar and logs the change.
     *
     * @param value Whether the bottom navigation should be hidden.
     */
    fun hideBottomNav(value: Boolean) {
        hideBottomNav = value
        GzLogger.d("HomeUiState", "Bottom navigation visibility updated to: $value")
    }

    /**
     * Updates the response and logs the change.
     *
     * @param value The new response.
     */
    fun setRemoteResponse(value: DestinationResponse?) {
        response = value
        GzLogger.d("HomeUiState", "Response updated: ${value?.size ?: "null"} items")
    }
}