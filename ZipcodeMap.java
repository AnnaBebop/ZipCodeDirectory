/*
   Christiana Smith
   November 4, 2021
*/

import java.util.*;
import java.io.*;

public class ZipcodeMap{
   public static void main(String[] args) throws FileNotFoundException{
      //Declare scanner and attach to file
      Scanner ip = new Scanner(new File("us-500.csv"));
      
      //Declare Map to store student info
      Map<String, List<String>> zcMap 
                  = new TreeMap<String, List<String>>();
      
      //Discard column headers
      ip.nextLine();
      
      
      for(int i = 0; i < 13; i++){
         String line = ip.nextLine();
         String[] stData = line.split(",");
         //System.out.println(Arrays.toString(stData));
         String firstName = stData[0];
         String lastName = stData[1];
         String company = stData[2];
         String address = stData[3];
         String city = stData[4];
         String county = stData[5];
         String state = stData[6];
         int zipcodes = Integer.parseInt(stData[7]);
         String phone = stData[8];
         String email = stData[9];
         
         List<String> list = new ArrayList<String>(Arrays.asList(stData));
         
         
         //adding elements to the TreeMap 
         zcMap.put(phone, list);
         }
         
         System.out.println(zcMap);
         searchKey(zcMap);

      
   }
   
   public static void searchKey(Map<String, List<String>> zcMap){
      System.out.println("Enter the phone number to search for in the following format (XXX-XXX-XXXX): ");
      
      //create scanner to read in user value
      Scanner keyboard = new Scanner(System.in);
      String userChoice = keyboard.next();
      
      
         if(zcMap.containsKey(userChoice)){
            System.out.println("First_Name: " + zcMap.get(userChoice).get(0));
            System.out.println("Last_Name: " + zcMap.get(userChoice).get(1));
            System.out.println("Company_Name: " + zcMap.get(userChoice).get(2));
            System.out.println("Address: " + zcMap.get(userChoice).get(3));
            System.out.println("City: " + zcMap.get(userChoice).get(4));
            System.out.println("County: " + zcMap.get(userChoice).get(5));
            System.out.println("State: " + zcMap.get(userChoice).get(6));
            System.out.println("Zip_Code: " + zcMap.get(userChoice).get(7));
            System.out.println("Phone: " + zcMap.get(userChoice).get(8));
            System.out.println("Email : " + zcMap.get(userChoice).get(9));
            
         }     
      }
     
}
