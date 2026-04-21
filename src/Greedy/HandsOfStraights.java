package Greedy;

import java.util.TreeMap;

public class HandsOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // invalid size edge case
        if(hand.length % groupSize != 0) return false;
        // store frequency
        TreeMap<Integer,Integer> cardFreq = new TreeMap<>();
        for (int card: hand){
            cardFreq.put(card,cardFreq.getOrDefault(card,0)+1);
        }

        while (!cardFreq.isEmpty()){
            int firstKey = cardFreq.firstKey();
            for (int i = 0; i< groupSize;i++){
                int next = firstKey+i;
                if(!cardFreq.containsKey(next)) return false;

                int count = cardFreq.get(next);
                if(count == 1){
                    cardFreq.remove(next);
                }else {
                    cardFreq.put(next,count-1);
                }
            }
        }
        return true;
    }
}
