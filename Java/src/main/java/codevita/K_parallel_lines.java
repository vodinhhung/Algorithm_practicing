package codevita;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Codevita
 */
public class K_parallel_lines {
    public int countLines(String s1, String s2){
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Map<List<Integer>, Integer> count = new HashMap<>();

        for(int i=0; i<ch1.length; i++){
            for(int j=0; j<ch2.length; j++){
                if(ch1[i] == ch1[j]){
                    List<Integer> child = new ArrayList<>();
                    child.add(i);
                    child.add(j);
                    if(count.containsKey(child))
                        count.put(child, count.get(child)+1);
                    else
                        count.put(child, 1);
                }
            }
        }

        int result = 0;
        for(List<Integer> child: count.keySet()){
            int countPa = count.get(child);
            if (countPa > 1){
                result += (countPa*(countPa-1))/2;
            }
        }

        return result;
    }
}
