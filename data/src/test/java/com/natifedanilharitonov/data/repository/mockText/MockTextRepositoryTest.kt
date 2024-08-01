package com.natifedanilharitonov.data.repository.mockText

import com.natifedanilharitonov.data.source.randomText.RandomTextSource
import com.natifeuaandroid.domainmodule.repository.MockTextRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class MockTextRepositoryTest {
    private lateinit var mockTextRepository: MockTextRepository

    @Mock
    private lateinit var source: RandomTextSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        mockTextRepository = MockTextRepositoryImpl(source)
    }

    @Test
    fun `get text access`() =
        runTest {
            val expected = "text"
            `when`(mockTextRepository.getText()).thenReturn(expected)
            val text = mockTextRepository.getText()
            assertEquals(expected, text)
        }

    @Test
    fun `get text error`() =
        runTest {
            val expected = null
            `when`(mockTextRepository.getText()).thenReturn(expected)
            val text = mockTextRepository.getText()
            assert(text == expected)
        }
}
