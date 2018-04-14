package com.example.demo
import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner


/**
 * @author Giovanni Silva
 */
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class TestCtrlTestClass {
    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @LocalServerPort
    private val port: Int = 0

    var headers = HttpHeaders()


    @Test
    fun test1() {
        val test = TestClass("shouldnotpass")

        val entity = HttpEntity<TestClass>(test, headers)

        val response = restTemplate.exchange(
                createURLWithPort("/test"),
                HttpMethod.POST,
                entity,
                String.javaClass
        )

        assertThat(response.statusCode).`isEqualTo`(HttpStatus.BAD_REQUEST)

    }

    @Test
    fun test2() {
        val test = TestClass("email@example.com")

        val entity = HttpEntity<TestClass>(test, headers)

        val response = restTemplate.exchange(
                createURLWithPort("/test"),
                HttpMethod.POST,
                entity,
                String.javaClass
        )

        assertThat(response.statusCode).`isEqualTo`(HttpStatus.OK)
    }

    @Test
    fun testBasePath() {
        val test = TestClass("email@example.com")

        val entity = HttpEntity<TestClass>(test, headers)

        val response = restTemplate.exchange(
                createURLWithPort("/test-bug"),
                HttpMethod.POST,
                entity,
                String.javaClass
        )

        assertThat(response.statusCode).`isEqualTo`(HttpStatus.OK)
    }

    @Test
    fun testBasePath2() {
        val test = TestClass("shouldnotpass")

        val entity = HttpEntity<TestClass>(test, headers)

        val response = restTemplate.exchange(
                createURLWithPort("/test-bug"),
                HttpMethod.POST,
                entity,
                String.javaClass
        )

        assertThat(response.statusCode).`isEqualTo`(HttpStatus.BAD_REQUEST)
    }

    private fun createURLWithPort(uri: String): String {
        return "http://localhost:$port$uri"
    }
}