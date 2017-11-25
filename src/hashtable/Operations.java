/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.util.*;

//import org.apache.commons.lang;



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
                     System.err.println("Sorry, there is no space to save the new contact!");
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
        
        System.out.println("contact in the hash value index : " + contact);
        
        //check whether the contact name in this hash value is the same as the entered name 
        //to make sure that linear prob hasn't been applyed on inserting this contact 
        
        if (contact ==null) {
            return contact; // to be checked in main to know that null indictes "not found" 
                
        }else{ //not null
            if (contact.name.equals(name)) {

                return contact;

            }else{ // Keep moving forward until finding the key, or reaching an empty spot


                for(int index = hashValue + 1 ; //to start searching from the next index 
                    index != hashValue ; // to search in the array only once and avoid entring an infinite loop if contact isn't found
                    index++){

                    contact = hashTable[index];

                    if (contact == null) {
                        return contact; // to be checked in main to know that null indictes "not found" 

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
        }
        
        //if hashTable is full-> no empty spots && contact not found
        contact = null; 
        return contact; // to be checked in main to know that null indictes "not found" 
    }
    
    public boolean delete(String name , int hashTableSize , Contact[] hashTable){
        
        boolean deleted ; // to indicate deletion
        
        Contact contact = new Contact(); // to put the returned contact in 

        //read hash table from file 
        File file = new File();
        hashTable = file.readhashTable("hashTable", hashTableSize);
        
        
        //search for this name in the hash table 
        contact = this.search(name , hashTableSize , hashTable);

//        System.out.println("contact after search : " +contact.name);
        
        if (contact == null) { //not found
            deleted = false; //to be checked in main 
        }else{ //found
            
            //get index of contact in hashTable
            //.........
            int deletedContactIndex  =  0;
            deletedContactIndex=Arrays.asList(hashTable).indexOf(contact);
//            int deletedContactIndex  =  ArrayUtils.indexOf(hashTable, contact);
//            int deletedContactIndex  =  1;
            
            System.out.println("deletedContactIndex :  " + deletedContactIndex);
            
            System.out.println("before deletion : " + hashTable[206].name);
            //delete contact 
            
            hashTable = ArrayUtils.removeElement(hashTable, contact);
//            contact = null;
            
            deleted = true; //to be checked in main 
            
            //rehashing
            
            this.rehash(deletedContactIndex , hashTable,hashTableSize);
            
            //save hashTable to the file
//            File file = new File();
            file.SaveHashTableToFile(hashTable, "hashTable");
            
        }

        
        return deleted;
    }
    
    public void rehash(int deletedContactIndex , Contact[] hashTable ,int hashTableSize ){
        
        for(int index = deletedContactIndex + 1 ; //to start from the next index 
                    index != deletedContactIndex ; // to rehash the array only once and avoid entring an infinite loop 
                    index++){
            
            if (hashTable[index] ==null || hashTable[index].linearProb == 0) { // there is no contacts to rehash
                
                break;
                
            }else if(hashTable[index].linearProb == 1){ // or just else ??!
                
//                int rehashedContactIndex = index; 
                this.insert(hashTableSize, hashTable, hashTable[index]);
                
                //delete contact from the old place 
                hashTable[index] = null; //to be tested
                
            }
            
            if (index == hashTable.length - 1 ) { //reached the end of the array

                //start from the beginning 
                index = -1; // to become 0 after incremention
            }
            
            
        }
    }
    
    
    
    
}
