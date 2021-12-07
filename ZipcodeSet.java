/*
   Christiana Smith
   November 4, 2021
   Desc: Lab 6
*/

import java.util.*;
import java.io.*;

public class ZipcodeSet{
   public static void main(String[] args) throws FileNotFoundException{
      //Declare scanner and attach to file
      Scanner ip = new Scanner(new File("us-500.csv"));
      
      //Declare Map to store student info
      Set<Integer> zcSet = new TreeSet<Integer>();
      
      //Discard column headers
      ip.nextLine();
      
      //loop through end of file
      for(int i = 0; i < 13; i++){
         String line = ip.nextLine();
         String[] stData = line.split(",");
         //System.out.println(Arrays.toString(stData));
         int zipcodes = Integer.parseInt(stData[7]);
         //adding elements to the TreeSet
         zcSet.add(zipcodes);         
         }
         
         //Display TreeSet of zipcodes
         System.out.println(zcSet);
          
         //Method Call: oddSet()
         System.out.println("This is the odd set: " + oddSet(zcSet));
         System.out.println("This is the even set: " + evenSet(zcSet));
         
         
         if(userMenu() == 'a'){
            minMax(evenSet(zcSet));
         }else{
            minMax(oddSet(zcSet));
         }
              

   }
   
      public static TreeSet<Integer> oddSet(Set<Integer> zcSet){
         //Declare iterator and attach to Set
         Iterator<Integer> itr = zcSet.iterator();
         
         //create new Set containing all odd numbers
         TreeSet<Integer> zcOddSet = new TreeSet<Integer>();
         
         //loop through elements
         while(itr.hasNext()){
            Integer next = itr.next();
            //remove even elements
            if(next % 2 == 1){
               zcOddSet.add(next);
            }
         }
         
         return zcOddSet;
      }
      
      public static TreeSet<Integer> evenSet(Set<Integer> zcSet){
         //Declare iterator and attach to Set
         Iterator<Integer> itr = zcSet.iterator();
         
         //create new Set containing all odd numbers
         TreeSet<Integer> zcOddSet = new TreeSet<Integer>();
         
         //loop through elements
         while(itr.hasNext()){
            Integer next = itr.next();
            //remove even elements
            if(next % 2 == 0){
               zcOddSet.add(next);
            }
         }
         
         return zcOddSet;
      }
      
      public static char userMenu(){
         System.out.println("Choose from the following choices: ");
         System.out.println("a. Display minimum and maximum value as an even zipcode");
         System.out.println("b. Display minimum and maximum value as an odd zipcode");
         
         //create scanner to read in user value
         Scanner keyboard = new Scanner(System.in);
         char userChoice = keyboard.next().charAt(0);
         
         return userChoice;
         
      }
      
      public static void minMax(TreeSet<Integer> zcSet){
         int min = zcSet.first();
         int max = zcSet.last();
         
         System.out.println("The minimum value is: " + min);
         System.out.println("The maximum value is: " + max);
      }

      
}