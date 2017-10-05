package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers {

	public static void main(String[] args) {
		List<Integer> price = new ArrayList<>();
		price.add(2);
		price.add(3);
		price.add(4);
		List<List<Integer>> special = new ArrayList<>();
		List<Integer> offer = new ArrayList<>();
		offer.add(1);
		offer.add(1);
		offer.add(0);
		offer.add(4);
		special.add(offer);
		offer = new ArrayList<>();
		offer.add(2);
		offer.add(2);
		offer.add(1);
		offer.add(9);
		special.add(offer);
		List<Integer> needs = new ArrayList<>();
		needs.add(1);
		needs.add(2);
		needs.add(1);
		
		System.out.println(shoppingOffers(price, special, needs));
	}

	public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder str = new StringBuilder();
        for (int i=0; i<price.size(); i++) {
            str.append("0");
        }
        
        map.put(str.toString(), 0);
        
        return doDfs(price, special, needs, map);
    }
    
    public static int doDfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<String, Integer> map) {
        StringBuilder str = new StringBuilder();
        for (int i=0; i<needs.size(); i++) {
            str.append(String.valueOf(needs.get(i)));
        }
        if (map.containsKey(str.toString())) {
            return map.get(str.toString());
        }
        
        int res = Integer.MAX_VALUE;
        for(List<Integer> s : special) {
            List<Integer> needsCopy = new ArrayList<>(needs);
            boolean valid = true;
            for(int i=0; i<needs.size(); i++) {
                needsCopy.set(i, needsCopy.get(i) - s.get(i));
                if(needsCopy.get(i) < 0) {
                    valid = false;
                    break;
                }
            }
            if(valid) {
                res = Math.min(res, s.get(needs.size()) + doDfs(price, special, needsCopy, map));
            }
        }
        
        int noSpecial = 0;
        
        for (int i=0; i<needs.size(); i++) {
            noSpecial += needs.get(i)*price.get(i);
        }
        
        res = Math.min(res, noSpecial);    

        map.put(str.toString(), res);
        return res;
    }
}
