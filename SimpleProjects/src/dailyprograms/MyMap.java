package dailyprograms;

import java.util.ArrayList;

public class MyMap<K,V> {
	private ArrayList<K> keys = new ArrayList<>();
    private ArrayList<V> values = new ArrayList<>();
    
    
    public void put(K key, V value) {
        int index = keys.indexOf(key);
        if (index != -1) {
            values.set(index, value);  
        } else {
            keys.add(key);
            values.add(value);         
        }
    }
    
    public V get(K key) {
        int index = keys.indexOf(key);
        if (index != -1) {
            return values.get(index);
        }
        return null; 
    }
    public boolean containsKey(K key) {
        return keys.contains(key);
    }
    public static void main(String[] args) {
        MyMap<String, Integer> map = new MyMap<>();

        map.put("Saikiran", 23);
        map.put("Kiran", 20);
        map.put("Prasad", 25);

        System.out.println("Saikiran's age: " + map.get("Saikiran")); 
        System.out.println("Kiran's age: " + map.get("Kiran"));  

        System.out.println("Map contains 'Saikiran': " + map.containsKey("Saikiran"));  // Output: true
        System.out.println("Map contains 'Kiran': " + map.containsKey("Kiran"));  // Output: false
    }

}
