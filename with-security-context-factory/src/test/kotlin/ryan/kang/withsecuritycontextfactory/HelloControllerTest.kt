package ryan.kang.withsecuritycontextfactory

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.test.web.servlet.assertj.MockMvcTester

@WebMvcTest
class HelloControllerTest {

    @Autowired
    lateinit var mockMvcTester: MockMvcTester

    @Test
    @WithMockCustomUser
    fun testHello() {
        val result = mockMvcTester.get().uri("/hello").exchange()

        assertThat(result).hasStatusOk()
            .hasBodyTextEqualTo("Hello")
    }
}