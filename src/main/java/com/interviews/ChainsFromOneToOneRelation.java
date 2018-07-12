package com.interviews;

import java.util.*;

/**
 * @author mummareddy.mahesh
 */
/*
IP: A->B ,C->D ,B->C,D->E ,F->G,Z->A

OP:Z->A->B->C->D->E
F->G
 */
public class ChainsFromOneToOneRelation {
    Map<String,String> ipMap = new HashMap<>();

    public List<LinkedList<String>> getResult() {
        return result;
    }

    List<LinkedList<String>> result = new ArrayList<>();
    ChainsFromOneToOneRelation(Map<String,String> ipMap) {
        this.ipMap = ipMap;
    }

    void createChains() {
        while(ipMap.size() > 0) {
            Map.Entry<String,String> entry = ipMap.entrySet().iterator().next();
            String key = entry.getKey();
            String value = entry.getValue();
            if(checkAndAddToExisting(key,value))
            {
                continue;
            }
            LinkedList<String> ll = new LinkedList<>();
            ll.add(key);
            ll.add(value);
            ipMap.remove(key);
            while (ipMap.keySet().contains(value)) {
                String temp = ipMap.get(value);
                ipMap.remove(value);
                value = temp;
                ll.add(value);
            }
                result.add(ll);
        }
    }

    private boolean checkAndAddToExisting(String key, String value) {
        for(LinkedList<String> list : result) {
            if(list.get(0).equals(value))
            {
               list.addFirst(key);
               ipMap.remove(key);
               return true;
            }
        }
        return false;
    }

    private void addFirst(LinkedList<String> ll, String key) {
        ll.addFirst(ipMap.get(key));
        ipMap.remove(key);
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("A","B");
        map.put("C","D");
        map.put("B","C");
        map.put("D","E");
        map.put("F","G");
        map.put("Z","A");

        ChainsFromOneToOneRelation chainsFromOneToOneRelation = new ChainsFromOneToOneRelation(map);
        chainsFromOneToOneRelation.createChains();
        List<LinkedList<String>> result = chainsFromOneToOneRelation.getResult();
        System.out.println(result);

    }

}
