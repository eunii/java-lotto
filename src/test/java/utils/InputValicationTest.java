package utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValicationTest {

    static InputValication inputValication = new InputValication();

    @Test
    void 문자_1000을_입력받으면_숫자1000을_리턴한다() {
        //given
        String givenMoney = "1000";
        //when
        int result = inputValication.checkGivenMoeny(givenMoney);
        //then
        assertThat(result).isEqualTo(1000);
    }
    
    @Test
    void 문자_100을_입력받으면_런타임에러를_리턴한다() {
        //given
        String givenMoney = "100";
        //when
        //then
        assertThatThrownBy(() ->
                inputValication.checkGivenMoeny(givenMoney)).
                isInstanceOf(RuntimeException.class);
    }
    @Test
    void 문자_가를_입력받으면_런타임에러를_리턴한다() {
        //given
        String givenMoney = "가";
        //when
        //then
        assertThatThrownBy(() ->
                inputValication.checkGivenMoeny(givenMoney)).
                isInstanceOf(RuntimeException.class);
    }
    
    @Test
    void 문자_음수1000_입력받으면_런타임에러를_리턴한다() {
        //given
        String givenMoney = "-1000";
        //when
        //then
        assertThatThrownBy(() ->
                inputValication.checkGivenMoeny(givenMoney))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void _6개의당첨번호를_입력받으면_쉼표로_분리해서_숫자리스트를_리턴한다() {
        //given
        String winningNumbers = "1,2,3,4,5,6";
        //when
        List<Integer> result = inputValication.winningNumberParser(winningNumbers);
        //then
        assertThat(result.size()).isEqualTo(6);
        assertThat(result.get(0)).isEqualTo(1);
        assertThat(result.get(1)).isEqualTo(2);

    }
    @Test
    void _7개의당첨번호를_입력받으면_런타임_에러를_리턴() {
        //given
        String winningNumbers = "1,2,3,4,5,6,7";
        //when
        //then
        assertThatThrownBy(
                () -> inputValication.winningNumberParser(winningNumbers))
                .isInstanceOf(RuntimeException.class);
    }
    @Test
    void _1부터_45_외의_당첨번호를_입력받으면_런타임_에러를_리턴() {
        //given
        String winningNumbers = "1,2,3,4,5,90";
        //when
        //then
        assertThatThrownBy(
                () -> inputValication.winningNumberParser(winningNumbers))
                .isInstanceOf(RuntimeException.class);
    }
    @Test
    void _1부터_45_외의_음수당첨번호를_입력받으면_런타임_에러를_리턴() {
        //given
        String winningNumbers = "-1,2,3,4,5,6";
        //when
        //then
        assertThatThrownBy(
                () -> inputValication.winningNumberParser(winningNumbers))
                .isInstanceOf(RuntimeException.class);
    }
    @Test
    void 공백이_포함된_당첨번호를_입력받으면_공백을_무시하고_숫자리스트_리턴() {
        //given
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        //when
        List<Integer> result = inputValication.winningNumberParser(winningNumbers);
        //then
        assertThat(result.size()).isEqualTo(6);
        assertThat(result.get(0)).isEqualTo(1);
        assertThat(result.get(1)).isEqualTo(2);
    }
}
