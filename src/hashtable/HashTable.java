/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.util.*;

/**
 * The main class
 * @author row
 */
public class HashTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
                        /*=====================================*/
                        /*Create Hash Table and save it to file*/
                        /*=====================================*/
                        
                /**make this only for the first time to run the app**/
                /*--------------------------------------------------*/
         
                
        //create hash table 
        
        int hashTableSize = 1009;
        Contact[] hashTable = new Contact[hashTableSize];
        
        
//        System.out.println("hashTable to write " + Arrays.toString(hashTable));
        
        //save hash table to file 
        
        /****** //comment creating new hash table to avoid rewriting it *******/
//        File f = new File();
//        String fileName = new String();
//        fileName = "hashTable";
//        f.SavehashTableToFile(hashTable, fileName);
        
                
        /******************************************************************************/
        /******************************************************************************/
        
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
            int hashValue ;
            hashValue = hF.calc_hash(newContact.name, hashTableSize);
            
            System.out.println("hash value : " + hashValue);
            
            //read hash table from file 
            
            File file = new File();
            hashTable = file.readhashTable("hashTable", hashTableSize);
            
            
            System.out.println("old hash table : " + Arrays.toString(hashTable));
            System.out.println("stored Contact : " + hashTable[386]);
            
            //check whether the index of the hash value is empty or not 
            
            if (hashTable[hashValue] == null) {  // it's ok to store the new contact in this index 
                
                System.out.println("index of hash value is empty");

                // save newContact in the hash table 
//                newContact.saveNewContactInHashTable(hashTable, newContact, hashValue);
                newContact.saveNewContactInHashTable(hashTable, newContact, 0);
                    
                //save hashTable to file after the new contact insertion 
                file.SavehashTableToFile(hashTable, "hashTable");
                
            }else{ // this index isn't available to store the new contact in 
                
                System.out.println("index of hash value is  noooot empty");
                
                //linear prob
                
                //create linearProb object to access linearProb method
                
                linearProb l = new linearProb();
                
                //apply linear prob on the new contact 
                
                int emptyIndex = l.linearProb(hashValue, hashTable, newContact);
                
                System.out.println("check contact.linearProb : " + newContact.linearProb);
                
                System.out.println("empty index = " + emptyIndex);
                
                
            }
                    
        }else if (operation == 2) { // search
            
            
        }else if(operation == 3 ){ //deletion
            
        
    }
       
        
        
        
    }
   
    
    
    
}
