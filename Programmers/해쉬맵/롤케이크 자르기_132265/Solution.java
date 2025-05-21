import java.util.*;
class Solution {
    public int solution(int[] topping) {
        HashMap<Integer, Integer> chulsooMap = new HashMap<>();
        HashMap<Integer, Integer> broMap = new HashMap<>();
        int answer = 0;
        for(int i=0;i<topping.length;i++) {
            if(chulsooMap.containsKey(topping[i]))
                chulsooMap.put(topping[i],chulsooMap.get(topping[i])+1);
            else
                chulsooMap.put(topping[i],1);
        }
        for(int i=0;i<topping.length;i++) {
            if(chulsooMap.get(topping[i])==1)
                chulsooMap.remove(topping[i]);
            else
                chulsooMap.put(topping[i], chulsooMap.get(topping[i])-1);
            
            if(broMap.containsKey(topping[i])) 
                broMap.put(topping[i], broMap.get(topping[i])+1);
            else
                broMap.put(topping[i],1);

            
            if(chulsooMap.size() == broMap.size())
                answer++;
        }

        return answer;
    }
}
