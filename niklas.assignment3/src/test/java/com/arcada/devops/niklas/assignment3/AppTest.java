package com.arcada.devops.niklas.assignment3;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class AppTest {
	
	//App app;
	
	public void setUp() throws Exception
	{
		//app = new App();
	}
	
	@Test
	public void testGetFriendsList() {
		//	Does the name Joe(user doesnt exsist) bring a array of friends(Strings)
		assertTrue(App.getFriendsList("Joe") instanceof String[]);
		//	Test doesnt give a failure becuase the method always returns a array of strings, (return new String[]{"No such user..."};)
	}
	
	
	@Test	//	Test for known user "juha"
	public void testGetFriendsListJuha() {
		
		String[] expected = {
				"Kalle", "Ville", "Jukka", "Spurgu", 
	            "Ukko", "Pelle", "Matti", "Sami", 
	            "Antti", "Leena", "Riikka", "Kaisa", 
	            "Timo", "Jani", "Eero", "Elias"
	            };
		//	We test with the name juha (DOES have a friend list)
		String[] actual = App.getFriendsList("juha");
		
		assertArrayEquals(expected, actual, "Friends list for 'juha' should match the expected array");
	}
	@Test	//	Test for known user "elias"
	public void testGetFriendsListElias() {
		
		String[] expected = {
				"Aino", "Kyllikki", "Jouko", "Hannes", 
	            "Eerik", "Antero", "Eeva", "Ilona", 
	            "Seppo", "Rauni", "Aulikki", "Aarre", 
	            "Martti", "Sirkka", "Terttu", "Ulla"
	            };
		//	We test with the name elias (DOES have a friend list)
		String[] actual = App.getFriendsList("elias");
		
		assertArrayEquals(expected, actual, "Friends list for 'elias' should match the expected array");
	}
	
	@Test	//	Test for unknown user "unknown"
	public void testGetFriendsListUnknown() {
		
		String[] expected = {"No such user..."};
		//	We test with the name elias (DOES have a friend list)
		String[] actual = App.getFriendsList("unknown");
		
		assertArrayEquals(expected, actual, "This should always return \"No such user...\"");
	}
	
	@Test	//	Test if always returning an array (intended)
	public void testGetFriendsListReturnsArray() {
		String[] result1 = App.getFriendsList("juha");
		String[] result2 = App.getFriendsList("elias");
		String[] result3 = App.getFriendsList("unknown");
		
		assertTrue( result1 instanceof String[] ,"Result should be an array");
		assertTrue( result2 instanceof String[] ,"Result should be an array");
		assertTrue( result3 instanceof String[] ,"Result should be an array");
	}
	
	@Test	//	Test with wrong input, with a integer
	public void testGetFriendsListInteger() {
		
		//	We test with "1"
		String[] actual = App.getFriendsList("1");
		
		assertTrue(actual instanceof String[], "Result should be an array with one entry \"No such user...\"");
	}
	
	@Test	//	Test if case sensitive, "JuhA"
	public void testGetFriendsListCaseSensitive() {
		
		//	We test with wrong capitalization
		String[] actual = App.getFriendsList("JuhA");
		String[] expected = {
				"Kalle", "Ville", "Jukka", "Spurgu", 
	            "Ukko", "Pelle", "Matti", "Sami", 
	            "Antti", "Leena", "Riikka", "Kaisa", 
	            "Timo", "Jani", "Eero", "Elias"
	            };
		
		assertArrayEquals(expected, actual, "Friends list for 'Juha' should match the expected array if NOT case sensitive");
	}
	
	@Test	//	Test if trailing whitespace will cause failure, "juha "
	public void testGetFriendsListTrailingSpace() {
		
		//	We test with trailing space
		String[] actual = App.getFriendsList("juha ");
		String[] expected = {
				"Kalle", "Ville", "Jukka", "Spurgu", 
	            "Ukko", "Pelle", "Matti", "Sami", 
	            "Antti", "Leena", "Riikka", "Kaisa", 
	            "Timo", "Jani", "Eero", "Elias"
	            };
		
		assertArrayEquals(expected, actual, "Friends list for 'juha ' should match the expected array if trailing whitespace does NOT cause failure");
	}

}
