package utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @Test
    void _1에서_45_사이의_로또보너스번호_입력_하면_숫자로_리턴() {
        //given
        String bonusNumbers = "45";
        List<Integer> winningNumber = new ArrayList<>();
        winningNumber.add(1);
        winningNumber.add(2);
        winningNumber.add(3);
        winningNumber.add(4);
        winningNumber.add(5);
        winningNumber.add(6);
        //when
        int result = inputValication.bonusNumberParser(bonusNumbers, winningNumber);
        //then
        assertThat(result).isEqualTo(45);
    }
    @Test
    void _1에서_45_사이의_로또번호와_중복된_보너스번호_입력_하면_런타임_에러_리턴() {
        //given
        String bonusNumbers = "45";
        List<Integer> winningNumber = new ArrayList<>();
        winningNumber.add(1);
        winningNumber.add(2);
        winningNumber.add(3);
        winningNumber.add(4);
        winningNumber.add(5);
        winningNumber.add(45);
        //when

        //then
        assertThatThrownBy(
                () -> inputValication.bonusNumberParser(bonusNumbers, winningNumber))
                .isInstanceOf(RuntimeException.class);
    }
    @Test
    void _1에서_45_사이를_벗어니는_로또번호를_입력하면_런타임에러() {
        //given
        String bonusNumbers = "46";
        List<Integer> winningNumber = new ArrayList<>();
        winningNumber.add(1);
        winningNumber.add(2);
        winningNumber.add(3);
        winningNumber.add(4);
        winningNumber.add(5);
        winningNumber.add(45);
        //when

        //then
        assertThatThrownBy(
                () -> inputValication.bonusNumberParser(bonusNumbers, winningNumber))
                .isInstanceOf(RuntimeException.class);
    }
}
