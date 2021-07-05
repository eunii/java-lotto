package domain;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;
    private int matchCount;
    private boolean matchBonus;

    public Lotto(List<Integer> randomNumber) {
        this.lottoNumbers = randomNumber;
    }
    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public String getLottoNumberString() {
        String lottoString = "[";
        for (int i = 0; i < lottoNumbers.size()-1; i++) {
            lottoString=lottoString+lottoNumbers.get(i)+", ";
        }
        lottoString=lottoString+lottoNumbers.get(lottoNumbers.size()-1)+"]";
        return lottoString;
    }

    public void getLottoResult(List<Integer> winningNumber, int bonusNumber){
        int[] checkScore = new int[45];
        for (int i=0; i<winningNumber.size(); i++){
            checkScore[winningNumber.get(i)]++;
            checkScore[lottoNumbers.get(i)]++;
        }
        matchCount = (int) Arrays.stream(checkScore).filter(value -> value>=2).count();
        matchBonus = lottoNumbers.contains(bonusNumber);
    }
}
