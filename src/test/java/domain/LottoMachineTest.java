package domain;

import enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void 돈을_입력받으면_구매한_로또_수를_리턴한다() {
        //given
        int givenMoney = 14000;
        LottoMachine lottoMachine = new LottoMachine(givenMoney);
        //when
        lottoMachine.getLottoTicketCount();
        //than
        assertThat(lottoMachine.getLottoTicketCount()).isEqualTo(14);
    }

    @Test
    void _1부터_45사이의_숫자중_중복되지_않는_7개를_뽑아서_오름차순으로_리턴한다() {
        //given
        LottoMachine lottoMachine = new LottoMachine(1000);
        //when
        List<Integer> lottoNumbers = lottoMachine.createRandomNumber();
        //than
        assertThat(lottoNumbers.size()).isEqualTo(6);
        assertThat(lottoNumbers.stream().distinct().count()).isEqualTo(6);

    }

    @Test
    void 부여받은_티켓_개수대로_로또_만들어서_리턴한다() {
        //given
        int money = 1000;
        LottoMachine lottoMachine = new LottoMachine(money);
        //when
        List<Integer> lottoNumbers = lottoMachine.createRandomNumber();
        List<Lotto> lottoTickets = lottoMachine.getLottoTickets();
        //than
        assertThat(lottoTickets.size()).isEqualTo(1);

    }

    @Test
    @DisplayName("1등_당첨_결과를_리턴한다")
    void getRankResult() {
        //given
        int money = 1000;
        LottoMachine lottoMachine = new LottoMachine(money);
        List<Lotto> lottoTicket = new ArrayList<>();

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoTicket.add(lotto);

        //when
        lottoMachine.getRankResult(lottoTicket, Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Map<Rank, Integer> rankResult = lottoMachine.getRankResult(lottoTicket);

        //then
        assertThat(rankResult.get(Rank.FIRST_PLACE)).isEqualTo(1);
        assertThat(rankResult.get(Rank.SECOND_PLACE)).isEqualTo(0);
        assertThat(rankResult.get(Rank.THIRD_PLACE)).isEqualTo(0);
    }

    @Test
    @DisplayName("2등_당첨_결과를_리턴한다")
    void getRankResult2() {
        //given
        int money = 1000;
        LottoMachine lottoMachine = new LottoMachine(money);
        List<Lotto> lottoTicket = new ArrayList<>();

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoTicket.add(lotto);

        //when
        lottoMachine.getRankResult(lottoTicket, Arrays.asList(1, 2, 3, 4, 5, 7), 6);
        Map<Rank, Integer> rankResult = lottoMachine.getRankResult(lottoTicket);

        //then
        assertThat(rankResult.get(Rank.SECOND_PLACE)).isEqualTo(1);
    }
}
