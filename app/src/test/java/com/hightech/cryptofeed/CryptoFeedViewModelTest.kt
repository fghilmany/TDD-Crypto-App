package com.hightech.cryptofeed

import com.hightech.cryptofeed.domain.CryptoFeed
import io.mockk.MockKAnnotations
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

data class UiState(
    val isLoading: Boolean = false,
    val cryptoFeed: List<CryptoFeed> = emptyList(),
    val failed: String = "",
)

class CryptoFeedViewModel {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()
}

class CryptoFeedViewModelTest {
    private lateinit var sut: CryptoFeedViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)

        sut = CryptoFeedViewModel()
    }

    @Test
    fun testInitInitialState() {
        val uiState = sut.uiState.value

        assertFalse(uiState.isLoading)
        assertTrue(uiState.cryptoFeed.isEmpty())
        assert(uiState.failed.isEmpty())
    }
}