package view;

import domain.Lotto;

import java.util.*;

public class OutputView {
    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for (int i=0; i<lottos.size(); i++){
            System.out.println(lottos.get(i).getLottoNumberString());
        }
    }

    public void printLottosResult(List<Lotto> lottos) {
        int[] reulst = new int[7];
        int[] prices = {0,0,30000000,5000,50000,150000,30000000,2000000000};
        int won = 0;

        for (int i=0; i<lottos.size(); i++){
            reulst[lottos.get(i).getMatchCount()]++;
            if(lottos.get(i).getMatchCount()==5 && lottos.get(i).isMatchBonus()){
                reulst[lottos.get(i).getMatchCount()]--;
                reulst[2]++;
            }
        }
        int price =0;
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i=3; i<=6; i++){
            if(i==6){
                System.out.printf("5개 일치, 보너스 볼 일치(%d원)- %d개\n",prices[2],reulst[2]);
                price=price+prices[2]*reulst[2];
            }
            System.out.printf("%d개 일치 (%d)- %d개\n",i,prices[i],reulst[i]);
            price=price+prices[i]*reulst[i];
        }
        System.out.println("총 수익률은 "+price/lottos.size()*1000*100+"입니다.");
    }
}
