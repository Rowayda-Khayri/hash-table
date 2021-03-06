/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.util.Arrays;

/**
 * Contain linear prob method
 * @author row
 */
public class linearProb {
    
    /**
     * search for the first empty index .
     * return the first empty index or -1 if there isn't any empty index 
     * @author row
     */
    public int linearProb(int hashValue , Contact[] hashTable , Contact newContact){
    
        int index = hashValue;
        int emptyIndex = 0;
        int secondLoopFlag = 0;
        
        System.out.println("enter linear prob method ");
        
        newContact.linearProb = 1; // to indicate that linear prob is applied on this contact // this will help in rehashing 
        
        
//        System.out.println("contact in the hash value index before loop : " + hashTable[hashValue].name);

        for(index = hashValue ;index < hashTable.length;index++){
        
            if(hashTable[index] ==null){ 
                emptyIndex = index ;
                break;
            }
            //if the end of hash table is reached : start from the beginning
        
            if (index == hashTable.length - 1 ) { 
                
                //check if entered this statement before i.e : searched for an empty index in all the hash table and didn't found 
                if(secondLoopFlag ==1){ 
                    return -1;  //  on insertion : no empty place to save in .. on search :not found 
                }else{
                   
                    index = -1 ; //to become 0 after incrementing it 
                    secondLoopFlag = 1; // to prevent looping over the hash table from the begining more than one time 
                }
                
            }
        }
     
        
//        System.out.println("contact in the hash value index after loop : " + hashTable[hashValue].name);
        

        
        //should return also the new contact after modifications -> create new struct 
        return emptyIndex;
    }
    
    
}
