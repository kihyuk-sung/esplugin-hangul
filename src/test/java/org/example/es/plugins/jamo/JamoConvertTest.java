package org.example.es.plugins.jamo;

import org.example.es.plugins.common.TokenConvert;
import org.example.es.plugins.common.TokenConvertBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JamoConvertTest {

    private final TokenConvert jamoConvert = new TokenConvertBase(new JamoConvertIterator());

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
        assertEquals(jamoConvert.convert("가나다라마배"), "ㄱㅏㄴㅏㄷㅏㄹㅏㅁㅏㅂㅐ");
        assertEquals(jamoConvert.convert("닭장"), "ㄷㅏㄺㅈㅏㅇ");
        assertEquals(jamoConvert.convert("의류"), "ㅇㅢㄹㅠ");
        assertEquals(jamoConvert.convert("왜외웨의"), "ㅇㅙㅇㅚㅇㅞㅇㅢ");
        assertEquals(jamoConvert.convert("의류"), "ㅇㅢㄹㅠ");
        assertEquals(jamoConvert.convert("땅값"), "ㄸㅏㅇㄱㅏㅄ");
        assertEquals(jamoConvert.convert("랆"), "ㄹㅏㄻ");
    }

    private void assertEquals(CharSequence actual, CharSequence expected) {
        assertThat(CharSequence.compare(actual, expected) == 0).isTrue();
    }
}
