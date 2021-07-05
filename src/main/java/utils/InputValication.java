package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValication {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private static final String LOTTO_PRICE_PATTERN = "\\d*000";
    private static final String LOTTO_BALL_NUMBER = "^[0-9]{1}$|^[1-3]{1}[0-9]{1}|^4{1}[0~5]{1}$";
    public static final String SPACE = " ";
    public static final String REPLACEMENT = "";
    public static final String DELIMITER = ",";
    public int checkGivenMoeny(String givenMoney) {
        if(!Pattern.matches(LOTTO_PRICE_PATTERN, givenMoney)){
            throw new RuntimeException("1000원 단위의 금액만 투입할 수 있습니다.");
        }
        return Integer.parseInt(givenMoney);
    }


    public List<Integer> winningNumberParser(String winningNumbers) {
        if(isNullEmpty(winningNumbers)){
            throw new RuntimeException("공백이나 null을 입력할 수 없습니다.");
        }
        List<String> parserlist = Arrays.asList(winningNumbers.replace(SPACE, REPLACEMENT).split(DELIMITER));
        if(parserlist.size()!=LOTTO_NUMBER_COUNT){
            throw new RuntimeException("총 6개의 숫자를 입력해주세요.");
        }
        Collections.sort(parserlist);
        return parserlist.stream()
                .filter(this::isLottoNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        }

    private boolean isLottoNumber(String number) {
        if(!Pattern.matches(LOTTO_BALL_NUMBER, number)){
            throw new RuntimeException("1~45사이의 숫자만 입력할 수 있습니다.");
        }
        return true;
    }

    private boolean isNullEmpty(String inputLine) {
        return inputLine == null || inputLine.isEmpty();
    }

    public int bonusNumberParser(String number, List<Integer> winningNumber) {
        if(isNullEmpty(number)){
            throw new RuntimeException("공백이나 null을 입력할 수 없습니다.");
        }
        isLottoNumber(number);
        int bonusNumber = Integer.parseInt(number);
        if(winningNumber.contains(bonusNumber)){
            throw new RuntimeException("로또번호와 중복된 숫자를 입력할 수 없습니다.");
        }
        return bonusNumber;
    }
}
