/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author row
 */
public class File {
    
    
    public void SaveDataToFile(Contact[] hashTable, String fileName){
        
        // The name of the file to create
        fileName = fileName + ".txt";
        
        String delimiter = new String();
        
        delimiter = "\n";

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
                bufferedWriter.write(hashTable[i] + delimiter);
            }
            
            //  close file
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            
        }
    
        
        
    }
    
    
//    public Contact[] readData(String fileName , int size){
//        
//        Contact[] data = new Contact[size];
//        
//        // The name of the file to open
//        fileName = fileName + ".txt";
//
//        // This will reference one line at a time
////        String line = null ;
//        Contact[] line = null ;
//
//        
//        try {
//            // FileReader reads text files in the default encoding.
//            FileReader fileReader = 
//                new FileReader(fileName);
//
//            // Always wrap FileReader in BufferedReader.
//            BufferedReader bufferedReader = 
//                new BufferedReader(fileReader);
//
//            while((line = bufferedReader.readLine()) != null) {
//                
////                data.add(Integer.parseInt(line));
//
//                data = line;
//            }   
//
//            // Always close files.
//            bufferedReader.close();         
//        }
//        catch(FileNotFoundException ex) {
//            System.out.println(
//                "Unable to open file '" + 
//                fileName + "'");                
//        }
//        catch(IOException ex) {
//            System.out.println(
//                "Error reading file '" 
//                + fileName + "'");                  
//            
//        }
//        
//        List<Integer> specificSizeList = new ArrayList<Integer>(data.subList(0,size)); ///not size - 1
//
//        ArrayList<Integer> specificSizeArrayList = new ArrayList<Integer>(specificSizeList);
//        
//        
//        return specificSizeArrayList;
//    }
    
    
    
    
}
