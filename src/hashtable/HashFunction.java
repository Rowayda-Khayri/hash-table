/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

/**
 * Hash function class
 * @author row
 */
public class HashFunction {
    
    /**
 * Hash function that receives contact name and returns the hash value 
 * @author row
 */
    public static int calc_hash( String key, int table_size) {
        
        int i, l = key.length();
        int hash = 0;
        
        for (i = 0; i < l; i++) {
            
            hash += Character.getNumericValue(key.charAt(i));
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
        
        if ( hash > 0) return hash % table_size;
        else return -hash % table_size;
    }

    
}
