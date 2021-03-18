package projectthree;

/**
 * class MyHashTable. A simple HashTable. Handle collision by chain
 * 
 * @author Brasher, Bryan R
 * @version 13MAR2021
 */
import java.util.ArrayList;


public class MyHashTable<K extends Comparable<K>, V>
{
    private ArrayList<MyHashEntry<K, V>> table;
    private int count; // how many elements in table
    
    /**
     * Constructor. Constructor an empty MyHashTable with given number of Buckets
     * @param tableSize The number of Buckets of the table
     */
    public MyHashTable(int tableSize){
        table = new ArrayList<>();
        for (int i = 0; i < tableSize; i++) {
            table.add(null);
        }
    }

    /**
     * constructor. Construct an empty MyHashTable with capacity 10 buckets
     */
    public MyHashTable(){
        table = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            table.add(null);
        }
    }
    
    /**
     * get the number of elements in the table
     * @return the number of elements in the table
     */
    public int size(){
       return table.size();
    }
    
    /**
     * clear the table
     */
    public void clear(){
        for (int i = 0; i < table.size(); i++) {
            table.set(i,null);
        }
    }
    
    /**
     * get the value with given key.
     * @param key The given key
     * @return the value that have the key matches the given key. If no such a value, return null
     */
    public V get(K key){
       return table.get(Math.abs(key.hashCode()%table.size())).getValue();
    }
    
    /**
     * insert (key, value) pair into the table
     * @param key The key of the pair
     * @param value The value of the pair
     */

    public void insert(K key, V value){
        count++;
        int bucket = Math.abs(key.hashCode()%table.size());
        // empty bucket
        if(table.get(bucket) == null) {
            table.set(bucket,new MyHashEntry(key,value));
        }
        // collision; begin chain
        else {
            MyHashEntry<K, V> pointer = table.get(bucket);
            MyHashEntry<K, V> link = new MyHashEntry<>(key,value);
            while(pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = link;
        }
    }
    
    /**
     * remove the value with given key from the table
     * @param key The given key
     * @return the value whose key matches the given key. If no such value, null is returned
     */


    public V remove(K key){
        int searchBucket = Math.abs(key.hashCode()%table.size());
        MyHashEntry<K,V> curEntry = table.get(searchBucket);
        // empty bucket
        if (curEntry == null) {
            return null;
        }
        // correct key; no chain
        if (curEntry.getKey().toString().equals(key) && curEntry.next == null) {
            table.set(searchBucket,null);
            return curEntry.getValue();
        }
        // correct key; with chain
        if (curEntry.getKey().toString().equals(key) && curEntry.next != null) {
            table.set(searchBucket,curEntry.next);
        }
        // incorrect key, but bucket has multiple elements
        else {
            MyHashEntry<K, V> prevEntry = curEntry;
            while(curEntry.next != null) {
                curEntry = curEntry.next;
                // key found
                if(curEntry.getKey().toString().equals(key)) {
                    // end of chain
                    if (curEntry.next==null) {
                        prevEntry.next=null;
                    }
                    // middle of chain
                    else {
                        prevEntry.next = curEntry.next;
                    }
                    return curEntry.getValue();
                }
                // key not found
                else {
                    prevEntry = curEntry;
                }
            }
            // not found in chain
            return null;
        }
        return null;
    }
    
    /**
     * check if the table is empty,i.e. no entry
     * @return true if the table holds no elements; false otherwise
     */
    public boolean isEmpty(){
        // check to ensure each bucket is null
        for (MyHashEntry<K, V> kvMyHashEntry : table) {
            if (kvMyHashEntry != null) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * return a String representation of the table
     * @return a String representation of the table
     */

    public String toString(){
        String tableString = "";
        for (int i = 0; i < table.size(); i++) {
            String s = "";
            MyHashEntry<K,V> pointer;
            // chain; move through each element in linked list
            if (table.get(i) != null) {
                pointer = table.get(i);
                while(pointer != null) {
                    s = s + " " + pointer.getValue().toString();
                    pointer = pointer.next;
                }
            }
            tableString = tableString + "\nBucket " + i + " : " + s;
        }
        return tableString;
    }
}
