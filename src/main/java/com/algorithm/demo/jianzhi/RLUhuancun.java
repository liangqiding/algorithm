package com.algorithm.demo.jianzhi;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * date: 2021-02-01 13:47
 * description
 *
 * @author qiDing
 */
public class RLUhuancun {
    public int[] LRU(int[][] operators, int k) {
        // write code here
        ArrayList<Integer> output = new ArrayList<>();
        LRU<Integer, Integer> lru = new LRU<>(k);
        for (int[] operator : operators) {
            if (operator[0] == 1) {
                lru.put(operator[1], operator[2]);
            } else {
                Integer v = lru.get(operator[1]);
                if (v != null) {
                    output.add(v);
                } else {
                    output.add(-1);
                }
            }
        }
        return output.stream().mapToInt(Integer::valueOf).toArray();
    }

    class LRU<K, V> {
         LinkedHashMap<K, V> map;
         int cacheSize;

        public LRU(int cacheSize) {
            this.cacheSize = cacheSize;
            map = new LinkedHashMap<K, V>(16, 0.75F, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                    if (cacheSize + 1 == map.size()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            };  //end map
        }

        public void put(K k, V v) {
            map.put(k, v);
        }

        public V get(K k) {
            return map.get(k);
        }
    }
}
