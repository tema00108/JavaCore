package by.incubator.task14.hashs;

import java.util.HashMap;
import java.util.Map;

public class ProductManager {
    public int mostFrequent(HashMap<String, Integer> map) {
        int most = 0;

        for (Map.Entry<String,Integer> entry : map.entrySet() ){
            int amount = entry.getValue();

            if (amount > most) {
                most = amount;
            }
        }

        return most;
    }
}
