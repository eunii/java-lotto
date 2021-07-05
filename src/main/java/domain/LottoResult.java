package domain;

import java.util.List;

public class LottoResult {
    private List<Integer> lottoNumbers;
    public LottoResult(List<Integer> randomNumber) {
        this.lottoNumbers = randomNumber;
    }
    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public String getLottoNumberString() {
        String lottoString = "[";
        for (int i = 0; i < lottoNumbers.size()-1; i++) {
            lottoString=lottoString+lottoNumbers.get(i)+", ";
        }
        lottoString=lottoString+lottoNumbers.get(lottoNumbers.size()-1)+"]";
        return lottoString;
    }
}
