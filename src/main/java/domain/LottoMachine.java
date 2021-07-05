package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int LOTTO_PRICE = 1000;


    public int getLottoTicktCount(int givenMoney) {
        return givenMoney/LOTTO_PRICE;
    }

    public List<Integer> createRandomNumber() {
        List<Integer> balls = IntStream.range(1,45).boxed().collect(Collectors.toList());
        Collections.shuffle(balls);
        List<Integer> lottoNumbers = balls.subList(0,6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Lotto> buyLottos(int money){
        int ticketCount = getLottoTicktCount(money);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i< ticketCount; i++){
            lottos.add(new Lotto(createRandomNumber()));
        }
        return lottos;
    }
}
