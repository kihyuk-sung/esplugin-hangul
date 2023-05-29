package org.example.es.plugins.chosung;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class ChosungInplaceTest {

    private final ChosungInplace inplace = new ChosungInplace();

    @Test
    @DisplayName("한글이 아닌 것은 변환하지 않는다.")
    void convertIfNotHangul() {
        final String target = "1234567890-=qwertyuiop[]asdfghjkl;'zxcvbnm,./";

        testString(target, target);
    }

    @Test
    @DisplayName("한글 문자가 아닌 경우는 변환하지 않는다.")
    void convertIfNotHangulSyllables() {
        final String target = "ㅂㅈㄷㄱㅅㅛㅕㅑㅐㅔ";

        testString(target, target);
    }

    @Test
    @DisplayName("한글은 초성으로 변환한다.")
    void convertIfHangul() {
        final String actual = "가나다라마바사아자차카타파하";
        final String expected = "ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎ";

        testString(actual, expected);
    }

    private void testString(String actual, String expected) {
        if (actual.length() != expected.length()) {
            fail("actual and expected length is not equal");
        }

        for (int i = 0; i < actual.length(); i++) {
            assertThat(inplace.inplace(actual.charAt(i))).isEqualTo(expected.charAt(i));
        }
    }
}
