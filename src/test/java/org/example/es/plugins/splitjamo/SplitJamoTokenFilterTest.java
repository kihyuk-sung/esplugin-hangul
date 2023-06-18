package org.example.es.plugins.splitjamo;

import org.example.es.plugins.common.TokenConvert;
import org.example.es.plugins.common.TokenConvertBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitJamoTokenFilterTest {

    private final TokenConvert jamoConvert = new TokenConvertBase(new SplitJamoIterator());

    @Test
    @DisplayName("한글이 아닌 경우 변환하지 않는다.")
    public void convertIfNotHangul() {
        final String target = "1234567890-=qwertyuiop[]asdfghjkl;'zxcvbnm,./";

        assertEquals(jamoConvert.convert(target), "1234567890-=qwertyuiop[]asdfghjkl;'zxcvbnm,./");
    }

    @Test
    @DisplayName("Hangul Compatibility Jamo인 경우 2벌식 키보드 기준으로 나눈다.")
    public void convertIfNotHangulSyllables() {
        final String target = "ㄱㄲㄳㄴㄵㄶㄷㄸㄹㄺㄻㄼㄽㄾㄿㅀㅁㅂㅃㅄㅅㅆㅉㅊㅋㅌㅍㅎㅏㅐㅑㅒㅓㅔㅕㅖㅗㅘㅙㅚㅛㅜㅝㅞㅟㅠㅡㅢㅣ";

        assertEquals(jamoConvert.convert(target), "ㄱㄲㄱㅅㄴㄴㅈㄴㅎㄷㄸㄹㄹㄱㄹㅁㄹㅂㄹㅅㄹㅌㄹㅍㄹㅎㅁㅂㅃㅂㅅㅅㅆㅉㅊㅋㅌㅍㅎㅏㅐㅑㅒㅓㅔㅕㅖㅗㅗㅏㅗㅐㅗㅣㅛㅜㅜㅓㅜㅔㅜㅣㅠㅡㅡㅣㅣ");
    }

    @Test
    @DisplayName("Hangul Compatibility Jamo 가 아닌 경우 변환하지 않는다.")
    public void convertIfHangulSyllables() {
        assertEquals(jamoConvert.convert("가나다라마배"), "가나다라마배");
        assertEquals(jamoConvert.convert("닭장"), "닭장");
        assertEquals(jamoConvert.convert("의류"), "의류");
        assertEquals(jamoConvert.convert("왜외웨의"), "왜외웨의");
        assertEquals(jamoConvert.convert("의류"), "의류");
        assertEquals(jamoConvert.convert("땅값"), "땅값");
        assertEquals(jamoConvert.convert("랆"), "랆");
    }

    private void assertEquals(CharSequence actual, CharSequence expected) {
        assertThat(CharSequence.compare(actual, expected) == 0).isTrue();
    }
}
