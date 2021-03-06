
package hashtable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write and read from file
 * @author row
 */
public class File {
    
/**
 * Save passed hash table in a file.
 * @param hashTable
 * @param fileName 
 */
    public void SaveHashTableToFile(Contact[] hashTable, String fileName){
        
        // The name of the file to create
        fileName = fileName + ".txt";
        
        String delimiter1 = new String();
        String delimiter2 = new String();
        
        delimiter1 = "\n";
        delimiter2 = ",";

        //save to file
        try {
            // Assume default encoding
            FileWriter fileWriter =
                new FileWriter(fileName);
            
            

            //  wrap FileWriter in BufferedWriter
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            
            for(int i = 0;i< hashTable.length;i++){
                
                //write value 
                if (hashTable[i] != null) {
                    bufferedWriter.write(hashTable[i].name + delimiter2 +  hashTable[i].phone + delimiter2 +  hashTable[i].linearProb + delimiter1);
                }else{
                    bufferedWriter.write(hashTable[i] + delimiter1 );
                }
                
            }
            
            System.out.println("Hash table is saved to file :) ");
            
            //  close file
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            
        }
    
        
        
    }
    
    /**
     * Read hash table from file
     * @param fileName
     * @param size
     * @return 
     */
    public Contact[] readhashTable(String fileName , int size){
        
        Contact[] hashTable = new Contact[size];
        
        String contact = new String(); // to save 
        
        
        // The name of the file to open
        fileName = fileName + ".txt";

        // This will reference one line at a time
        String line ;

        
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            
            for(int i = 0 ; i< size ; i++){
                
                line = bufferedReader.readLine();
                
                
                if(!line.equals("null")) { // "null" not null -_-
                
                    contact = line;
                    
                    //split contact with ',' to get each property 
                    String splittedContact[] = new String[3];
                    
                    splittedContact = contact.split(",");
                    
                    //set properties
                    
                    hashTable[i] = new Contact(); //create instance 
                    hashTable[i].name = splittedContact[0];
                    hashTable[i].phone = Integer.parseInt(splittedContact[1]);
                    hashTable[i].linearProb = Integer.parseInt(splittedContact[2]);
                    
                    
                }  else{
                    hashTable[i] = new Contact(); //create instance 
                    hashTable[i]= null;
                }
                
            }
            
            

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            
        }
        
        
        return hashTable;
    }
    
    
    
    
    
    
    
}
