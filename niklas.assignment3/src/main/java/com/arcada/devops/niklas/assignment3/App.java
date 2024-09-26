package com.arcada.devops.niklas.assignment3;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("Search for a persons friends list(try juha or elias): ");
    	String userInput = input.nextLine(); 
         String[] friends = getFriendsList(userInput);
         
         // Print friends list
         for (String friend : friends) {
             System.out.println(friend);
         }
     }

     public static String[] getFriendsList(String name) {
    	 System.out.println(name + "s Friendslist:");
    	 
    	 String[] juhaFriends = {
    	            "Kalle", "Ville", "Jukka", "Spurgu", 
    	            "Ukko", "Pelle", "Matti", "Sami", 
    	            "Antti", "Leena", "Riikka", "Kaisa", 
    	            "Timo", "Jani", "Eero", "Elias"
    	        };
    	 String[] eliasFriends = {
    	            "Aino", "Kyllikki", "Jouko", "Hannes", 
    	            "Eerik", "Antero", "Eeva", "Ilona", 
    	            "Seppo", "Rauni", "Aulikki", "Aarre", 
    	            "Martti", "Sirkka", "Terttu", "Ulla"
    	        };
    	 if(name.equals("juha")) {
    		 return juhaFriends;
    	 }
    	 if(name.equals("elias")) {
    		 return eliasFriends;
    	 }
         
    	 return new String[]{"No such user..."};
         
     }
    
}
