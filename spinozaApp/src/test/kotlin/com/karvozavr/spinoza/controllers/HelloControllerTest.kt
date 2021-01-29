package com.karvozavr.spinoza.controllers

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `should show hello on main page call`() {
        mockMvc.get("/")
            .andExpect { status { is2xxSuccessful() } }
            .andReturn()
            .response.contentAsString
            .apply { assertTrue(contains("<h1>Hello, this is Spinoza server v1.2</h1>")) }
    }
}