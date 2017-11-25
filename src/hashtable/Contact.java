
package hashtable;

/**
 * new Struct to contain the contact name and phone
 * @author row
 */
public class Contact {
    
    
    String name = new String();
    int phone ;
    int linearProb = 0; //to show whether linear prob is applyed on the object or not 
 
    
   
    /**
     * save new contact to the hash table (to the hash value or the new index after applying linear prob
     * @param hashTable
     * @param newContact
     * @param index 
     */
    
    public void saveNewContactInHashTable(Contact[] hashTable , int index){
        
        // index can be the hash value or the new index returned from the linear prob method 
        
        hashTable[index] = new Contact();
        hashTable[index].name  = this.name; 
        hashTable[index].phone  = this.phone; 
        hashTable[index].linearProb  = this.linearProb; 
    
    }
    
    
}
