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
        
        //save hash table to file 
        
        /****** //comment creating new hash table file to avoid rewriting it *******/
//        File f = new File();
//        String fileName = new String();
//        fileName = "hashTable";
//        f.SaveHashTableToFile(hashTable, fileName);
        
                
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
        Operations operationInstance = new Operations();
        
        if(operation ==1){ //insertion
            
            //scan for new contact 
            
            Contact newContact = new Contact();
            
            System.out.println("Enter name : ");
            newContact.name = reader.next(); // Scans the next token of the input as an contact's name

            System.out.println("Enter phone : ");
            newContact.phone = reader.nextInt(); // Scans the next token of the input as an contact's phone

            operationInstance.insert(hashTableSize, hashTable , newContact);
            
        }else if (operation == 2) { // search
            
            //scan for the contact's name
            
            System.out.println("Enter name : ");
            String name = new String();
            name = reader.next(); // Scans the next token of the input as an contact's name
            
            
            Contact contact = new Contact(); // to put the returned contact in 
            
            //search for this name in the hash table 
            contact = operationInstance.search(name , hashTableSize , hashTable);
            
            if (contact == null) {
                System.err.println("contct not found!");
            }else{
                System.out.println("Name : " + contact.name + ", Phone : " + contact.phone);
            }

        }else if(operation == 3 ){ //deletion
            
        
    }
       
        
        
        
    }
   
    
    
    
}
