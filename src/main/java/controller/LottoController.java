package controller;

import domain.Lotto;
import domain.LottoMachine;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoController {
    static InputView inputView = new InputView();
    static OutputView outputView =  new OutputView();
    static LottoMachine lottoMachine = new LottoMachine();
    public static void main(String[] args) {
        int money = inputView.inputMoney();
        List<Lotto> lottos = lottoMachine.buyLottos(money);
        outputView.printLottos(lottos);
        List<Integer> winningNumber = inputView.winningNumber();
        int bonusNumber = inputView.bonusNumber(winningNumber);

        lottoMachine.getLottoResult(winningNumber,bonusNumber,lottos);



    }
}
