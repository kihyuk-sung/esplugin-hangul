package org.example.es.plugins.jamo;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

public class JamoConvertTest {

    private final JamoConvert jamoConvert = new JamoConvert();

    @Test
    @DisplayName("한글이 아닌 경우 변환하지 않는다.")
    public void convertIfNotHangul() {
        final String target = "1234567890-=qwertyuiop[]asdfghjkl;'zxcvbnm,./";

        assertEquals(jamoConvert.convert(target), "1234567890-=qwertyuiop[]asdfghjkl;'zxcvbnm,./");
    }

    @Test
    @DisplayName("Hangul Syllables가 아닌 경우 변환하지 않는다.")
    public void convertIfNotHangulSyllables() {
        final String target = "ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎㅏㅑㅓㅕㅗㅛㅜㅠㅡㅣㅐ";

        assertEquals(jamoConvert.convert(target), "ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎㅏㅑㅓㅕㅗㅛㅜㅠㅡㅣㅐ");
    }

    @Test
    @DisplayName("Hangul Syllables인 경우 자모를 분리한다.")
    public void convertIfHangulSyllables() {
        final String target = "가나다라마배";

        assertEquals(jamoConvert.convert(target), "ㄱㅏㄴㅏㄷㅏㅁㅏㅂㅐ");
    }

    private void assertEquals(CharSequence actual, CharSequence expected) {
        assertThat(CharSequence.compare(actual, expected) == 0).isTrue();
    }
}
