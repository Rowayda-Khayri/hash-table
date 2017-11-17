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
    public void insert( int hashTableSize , Contact[] hashTable , Contact newContact){
        
        
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
                
                 if (emptyIndex == -1) {
                     System.out.println("Sorry, there is no space to save the new contact!");
                 }else{
                     System.out.println("The new contact has been saved successfully :) ");
                 }
                System.out.println("check contact.linearProb : " + newContact.linearProb);
                
                System.out.println("empty index = " + emptyIndex);
                
                //save new contact to hash table 
                
                newContact.saveNewContactInHashTable(hashTable, emptyIndex);
                
                
            }
            
            //save hashTable to file after the new contact insertion 
                file.SaveHashTableToFile(hashTable, "hashTable");
                    
    }
    
    public Contact search(String name , int hashTableSize , Contact[] hashTable){
        
        //pass name to hash function to get its hash value
            
        HashFunction hF = new HashFunction();
        int hashValue ;
        hashValue = hF.calc_hash(name, hashTableSize);

        System.out.println("hash value : " + hashValue);
            
        //read hash table from file 
        File file = new File();
        hashTable = file.readhashTable("hashTable", hashTableSize);
        
        //get contact in the returned hash value 
        
        Contact contact = new Contact();
        contact = hashTable[hashValue];
        
        //check whether the contact name in this hash value is the same as the entered name 
        //to make sure that linear prob hasn't been applyed on inserting this contact 
        
        if (contact.name.equals(name)) {
            
            return contact;
            
        }else{ // Keep moving forward until finding the key, or reaching an empty spot
            
                
            for(int index = hashValue + 1 ; //to start searching from the next index 
                index != hashValue ; // to search in the array only once and avoid entring an infinite loop if contact isn't found
                index++){

                contact = hashTable[index];
                
                if (contact == null) {
                    return contact; // to be checked in main to know tht null indictes "not found" 
                
                }else{ // not null
                    if (contact.name.equals(name)) {
                        return contact; // found
                    } // if not : start the next iteration 
                    
                } 
                
                if (index == hashTable.length - 1 ) { //reached the end of the array
                    
                    //start from the beginning 
                    index = -1; // to become 0 after incremention
                }
            }
                
            
        }
        
        //if hashTable is full-> no empty spots && contact not found
        contact = null; 
        return contact; // to be checked in main to know tht null indictes "not found" 
    }
    
    
    
    
}
