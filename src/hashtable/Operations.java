/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.util.*;


/**
 * The operations methods that can be applied on the hash table.
 * @author row
 */
public class Operations {
    
    /**
     * Insert a new contact to the hash table.
     * @param hashTableSize
     * @param hashTable 
     */
    public void insert( int hashTableSize , Contact[] hashTable){
        
        //scan for new contact 
            
            Contact newContact = new Contact();
            
            System.out.println("Enter name : ");
            
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            newContact.name = reader.next(); // Scans the next token of the input as an contact's name

            System.out.println("Enter phone : ");
            newContact.phone = reader.nextInt(); // Scans the next token of the input as an contact's phone

            System.out.println("newContact name : " + newContact.name);
            System.out.println("newContact phone : " + newContact.phone);
            System.out.println("newContact lp : " + newContact.linearProb);
            System.out.println("newContact : " + newContact);

            //pass contact name to hash function to get its hash value
            
            HashFunction hF = new HashFunction();
            int hashValue ;
            hashValue = hF.calc_hash(newContact.name, hashTableSize);
            
            System.out.println("hash value : " + hashValue);
            
            
            //read hash table from file 
            
            File file = new File();
            hashTable = file.readhashTable("hashTable", hashTableSize);
            //check whether the index of the hash value is empty or not 
            
            System.out.println("hash value +  hashTable[hashValue]" + hashValue + hashTable[hashValue]);
            
             if (hashTable[hashValue] == null) {  // it's ok to store the new contact in this index 
                
                System.out.println("index of hash value is empty");

                // save newContact in the hash table 
                newContact.saveNewContactInHashTable(hashTable, hashValue);
//                newContact.saveNewContactInHashTable(hashTable, newContact, 1008); //just test
                    
                
                
            }else{ // this index isn't available to store the new contact in 
                
                System.out.println("index of hash value is  not empty");
                
                //linear prob
                
                //create linearProb object to access linearProb method
                
                linearProb l = new linearProb();
                
                //apply linear prob on the new contact 
                
                int emptyIndex = l.linearProb(hashValue, hashTable, newContact);
                
                System.out.println("check contact.linearProb : " + newContact.linearProb);
                
                System.out.println("empty index = " + emptyIndex);
                
                //save new contact to hash table 
                
                newContact.saveNewContactInHashTable(hashTable, emptyIndex);
                
                
            }
            
            //save hashTable to file after the new contact insertion 
                file.SaveHashTableToFile(hashTable, "hashTable");
                    
    }
    
    
    
    
}
