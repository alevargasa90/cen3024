
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Author Name: Alejandro Vargas
//Date: 9/12/2021
//Program Name: Vargas_SpellChecking
//Purpose: spell checking program that compares two files. the first is the dictionary, and the second is the file to be checked.
// Then it prints all the unknown words of the file to be checked. 
// I found a faster way to find the unknown words which does not requires a for loop


public class Vargas_SpellChecking {

	private static ArrayList<String>dictionaryArray = new ArrayList<String>(); // for the dictionary
	
	private static ArrayList<String>textToCheckArray = new ArrayList<String>(); // for the text
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		 System.out.print("Enter the dictionary file name: "); 
		 String dictionary = sc.next();
		
		 //filling the array list with the words of the dictionary file
		 try {
		      File myObj = new File(dictionary);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	  dictionaryArray.add(myReader.nextLine());
		        
//		        System.out.println(dictionaryArray);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		     
//		     
		    }
		 
		 Scanner sc1 = new Scanner(System.in);
		 System.out.print("File name: "); 
		 String textToCheck = sc.next();
	      
		//filling the array list with the words of the file to check
		 	 try {
			      File myObj2 = new File(textToCheck);
			      Scanner myReader = new Scanner(myObj2);
			      while (myReader.hasNextLine()) {
			    	  textToCheckArray.add(myReader.nextLine());
//			        System.out.println(textToCheckArray);
			      }
			      myReader.close();
			    } catch (FileNotFoundException e1) {
			      System.out.println("An error occurred.");
			      e1.printStackTrace();
			      
			    }	
		    sc.close();
		    sc1.close();
				
		
	 check(textToCheckArray,dictionaryArray);
		
	}
	
	//comparing both arraysList and printing the unknown words 
	private static void check(ArrayList<String> textToCheckArray, ArrayList<String> dictionaryArray) throws IOException{
		if (textToCheckArray.equals(dictionaryArray)== true) {
			System.out.print("The text is good :)");	
			System.exit(0);
			}
		
		else
			for (int i = 0; i<= textToCheckArray.size()-1; i++ ) { 
			
				if (dictionaryArray.contains(textToCheckArray.get(i)) == false) { 
 			
					System.out.println("Unknown word: "+textToCheckArray.get(i));	
				}
			}
//		FAST Method removing all the known words from the array
		textToCheckArray.removeAll(dictionaryArray);
		System.out.print("Unknown word/s:" + textToCheckArray);
		
	}
}		
			
		