package testdata;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class mapExample {
    public static void main(String[] args){
        createMap();
    }
    public static void createMap() {
        /** 1- Creating an empty HashMap */
        HashMap<Integer, String> hash_map = new HashMap<>();

        /** 2 - Mapping string values to int keys */
        hash_map.put(10, "devopsify");
        hash_map.put(15, "40");
        hash_map.put(20, "devopsify.co");
        hash_map.put(25, "Welcomes");
        hash_map.put(30, "You");


        /** 3 - Print size and content of the Map */
        System.out.println("Size of map is: "+ hash_map.size()); // Size of map is: 5

        /**  4 - Access elements in the HashMap */
        System.out.println(hash_map.get(25)); // Output: Welcomes
        System.out.println(hash_map.get(10)); // Output: devopsify
        System.out.println(hash_map.get(11)); // Output: NULL
/*
        /** 5 - Check if an element is present in the HashMap */
        System.out.println(hash_map.containsKey(55)); // Output: false

        // Checking if a key is present and if present, print value by passing
        // random element
        String sValue = (hash_map.containsKey(20)) ? hash_map.get(20): "Not match any value";
        System.out.println("value for key" + " \"20\" is:- " + sValue);


        //** 6 - Printing elements in object of HashMap *//*
        System.out.println("Initial Mappings are: " + hash_map); // Initial Mappings are: {20=devopsify.co, 25=Welcomes, 10=devopsify, 30=You, 15=40}

        /** 7 - mapping for the key is present in HashMap, if found, return value, else return default value "Not Found"*/
      /*  String value1 = hash_map.getOrDefault(10, "Not Found");
        System.out.println("Value for key 10:  " + value1); //Value for key 10: devopsify*/

        // mapping for the key is not present in HashMap
    /*    String value2 = hash_map.getOrDefault(4, "Not Found");
        System.out.println("Value for key 4: " + value2); //Value for key 4: Not Found*/

     /** 8 - HashMap putIfAbsent()
         * *
         *    Inserts the specified key/value mapping to the hashmap if the specified key is already not present in the hashmap.
         *    Syntax     hashmap.putIfAbsent(K key, V value);
         *
         *    The putIfAbsent() method takes two parameters.
         *       key - the specified value is associated with this key
         *       value - the specified key is mapped with this value
         *
         *   putAbsent() Return Value:
         *       + Returns the value associated with the key, if the specified key is already present in the hashmap
         *       + Returns null, if the specified key is already not present in the hashmap
         *
         * * * * * * * * * * * * * * *
         *  Note:  If the specified key is previously associated with a null value, then also the method returns null.
         *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * **//*

        // key already not present in HashMap
        hash_map.putIfAbsent(6, "huyen tran");
        //the key 6 is not already associated with any value. Hence,
        // the putifAbsent() method adds the mapping {6 = huyen tran} to the hashmap.

        // key already present in HashMap
        hash_map.putIfAbsent(30, "Swift");
        System.out.println("Updated Languages: " + hash_map);

        *//** 9 - HashMap merge()
         * *

*/
        /**------------------------------------------------------------------------------------------------------------*/
        /**        ****  For…each loop for a map        * */
        //1 - iterate through keys only
        for (Integer key : hash_map.keySet()) {
            System.out.println("key: " + key);
        }

        // 2 - iterate through values only
        for (String value : hash_map.values()) {
            System.out.println("value: " + value);
        }
       // HashMap<Key: Integer, Value: String> hash_map = new HashMap<>();
        // 3 - Print keys and values
        for (Integer k : hash_map.keySet()) {
            System.out.println("key: " + k + " ---->   value: " + hash_map.get(k));
        }


        // 7 - Using entrySet() to get the set view
        System.out.println("The set view using entrySet() method is: " + hash_map.entrySet());  //The set view using entrySet() method is: [20=devopsify.co, 25=Welcomes, 10=devopsify, 30=You, 15=4]

        // 8 -  iterate through key/value entries
        for (HashMap.Entry<Integer, String> entry : hash_map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " -> with Value : " + entry.getValue());
        }


        /**-------------------------HashMap forEach()-----------------------------------------------------------------
         *   The Java HashMap forEach() method is used to perform the specified action to each mapping of the hashmap.
         *   Syntax:         hash_map.forEach(BiConsumer<K, V> action)
         *   The forEach() method takes a single parameter.
         *       + action - actions to be performed on each mapping of the HashMap
         * */

        //We have passed the lambda expression as an argument to the forEach() method. Here
        //  The forEach() method performs the action specified by lambda expression for each entry of the hashmap
        //   and prints all the keys and corresponding values

        hash_map.forEach((key, value) -> {
            System.out.println("Key: "+ key + "--> Value: " + value);
        });

        /* Remove item*//*
        hash_map.remove(15);  //K = 15, V= 40
        //remove all items
        hash_map.clear();
        System.out.println("Map after remove all has size is "+ hash_map.size() + hash_map);
        System.out.println("Map is "+ hash_map);*/
    }
 }

