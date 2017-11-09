/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.util.*;

/**
 *
 * @author row
 */
public class HashTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //create hash table 
        
        int hashTableSize = 1009;
        Contact[] hashTable = new Contact[hashTableSize];
        
        System.out.println("hashTable to write " + Arrays.toString(hashTable));
        
        //save hash table to file 
        
        File f = new File();
        f.SavehashTableToFile(hashTable, "hashTable");
    }
    
}
