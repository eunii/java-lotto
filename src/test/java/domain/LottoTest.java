package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    static LottoMachine lottoMachine = new LottoMachine();
    @Test
    void 로또를_생성하면_로또_로또번호가_부여된다() {
        //given
        Lotto lotto = new Lotto(lottoMachine.createRandomNumber());
        //when
        //than
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
        assertThat(lotto.getLottoNumbers().stream().distinct().count()).isEqualTo(6);
    }
    @Test
    void 로또에_당첨번호_세개가_일치하면_당첨_결과를_로또에_저장한다() {
        //given
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber.add(1);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(4);
        lottoNumber.add(5);
        lottoNumber.add(6);
        Lotto lotto = new Lotto(lottoNumber);
        List<Integer> winningNumber = new ArrayList<>();
        int bonusNumber = 7;
        winningNumber.add(1);
        winningNumber.add(2);
        winningNumber.add(3);
        winningNumber.add(9);
        winningNumber.add(10);
        winningNumber.add(11);
        //when
        lotto.getLottoResult(winningNumber, bonusNumber);
        //than
        assertThat(lotto.getMatchCount()).isEqualTo(3);
        assertThat(!lotto.isMatchBonus());
    }
    @Test
    void 로또에_당첨번호_세개가_일치하고_보너스_번호가_일치하면_당첨_결과를_로또에_저장한다() {
        //given
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber.add(1);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(4);
        lottoNumber.add(5);
        lottoNumber.add(6);
        Lotto lotto = new Lotto(lottoNumber);
        List<Integer> winningNumber = new ArrayList<>();
        int bonusNumber = 6;
        winningNumber.add(1);
        winningNumber.add(2);
        winningNumber.add(3);
        winningNumber.add(9);
        winningNumber.add(10);
        winningNumber.add(11);
        //when
        lotto.getLottoResult(winningNumber, bonusNumber);
        //than
        assertThat(lotto.getMatchCount()).isEqualTo(3);
        assertThat(lotto.isMatchBonus());
    }
}
