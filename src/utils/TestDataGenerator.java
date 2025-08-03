package utils;

import java.util.Random;

public class TestDataGenerator {
	static Random rand = new Random ();
	
	
	public static String getRandomFirstName () {

	String[] firstnames = { "Rahaf", "Zaina", "Bayan", "Heba", "Sara" };
	return firstnames[rand.nextInt(firstnames.length)];
}
	
	public static String getRandomLastName () {
		String[] lastnames = { "Alrajabi", "Abdullah", "Muhamad" };
		return lastnames [rand.nextInt(lastnames.length)];
}
	
	public static String getEmail(String first, String last) {
		return first + last + rand.nextInt(7000) + "@gmail.com";
	}
	
	public static String getRandomUsername(String first, String last) {
        return first + last + rand.nextInt(7000); 
	}
}