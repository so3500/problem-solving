package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LC_535_EncodeAndDecodeTinyURLTest {
    private val codec = LC_535_EncodeAndDecodeTinyURL()

    @ParameterizedTest
    @MethodSource
    fun test(url: String) {
        val decodedUrl = codec.decode(codec.encode(url));

        assertThat(decodedUrl).isEqualTo(url)
    }

    companion object {
        @JvmStatic
        private fun test() = listOf(
                "https://leetcode.com/problems/design-tinyurl",
                "https://leetcode.com/hi",
                "https://docs.spring.io/spring-framework/docs/current/reference/html",
                "https://leetcode.com/problems/design-tinyurl"
        )
    }
}