package view;

import utils.InputValication;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static InputValication inputValication = new InputValication();
    public int inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        return inputValication.checkGivenMoeny(scanner.nextLine());
    }

    public List<Integer> winningNumber(){
        System.out.println("지난주 당첨 번호를 입력해주세요");
        return inputValication.winningNumberParser(scanner.nextLine());
    }

    public int bonusNumber(List<Integer> winningNumber){
        System.out.println("보너스 볼을 입력해주세요");
        return inputValication.bonusNumberParser(scanner.nextLine(), winningNumber);
    }
}
