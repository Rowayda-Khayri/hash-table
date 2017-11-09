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
        
        
        //scan for user operation choice
        
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Choose Operation number (1 , 2 or 3 ) : ");
        System.out.println("1 - Insert Contact ");
        System.out.println("2 - Search for Contact ");
        System.out.println("3 - Delete Contact ");
        int operation = reader.nextInt(); // Scans the next token of the input as an int.

        
        System.out.println("the user choosed : " + operation);
        
        if(operation ==1){ //insertion
            
            //scan for new contact 
            
            Contact newContact = new Contact();
            
            System.out.println("Enter name : ");
            newContact.name = reader.next(); // Scans the next token of the input as an contact's name

            System.out.println("Enter phone : ");
            newContact.phone = reader.nextInt(); // Scans the next token of the input as an contact's phone

            System.out.println("newContact name : " + newContact.name);
            System.out.println("newContact phone : " + newContact.phone);
            System.out.println("newContact lp : " + newContact.linearProb);
            System.out.println("newContact : " + newContact);

            //pass contact name to hash function to get its hash value
            
            HashFunction hF = new HashFunction();
            long hashValue ;
            hashValue = hF.calc_hash(newContact.name, hashTableSize);
            
            System.out.println("hash value : " + hashValue);
                    
        }else if (operation == 2) { // search
            
            
        }else if(operation == 3 ){ //deletion
            
        
    }
       
        
        
        
    }
   
    
    
    
}
