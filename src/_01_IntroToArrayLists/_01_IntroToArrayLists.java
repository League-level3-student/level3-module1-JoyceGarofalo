package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		String[] strings = new String[5];
		//2. Add five Strings to your list
		
		//3. Print all the Strings using a standard for-loop
		for (int i = 0; i < strings.length; i++) {
			strings[i]="string:"+i;
			System.out.println(strings[i]);
		}
		System.out.println("");
		//4. Print all the Strings using a for-each loop
		for (String string : strings) {
			System.out.println(string);
		}
		System.out.println("");
		//5. Print only the even numbered elements in the list.
		for (int j = 0; j < strings.length; j++) {
			strings[j]="string:"+j;
			if(j%2==0) {
				System.out.println(strings[j]);
			}
		}
		System.out.println("");
		//6. Print all the Strings in reverse order.
		for (int i = 4; i < strings.length; i--) {
			System.out.println(strings[i]);
			if(i<=0) {
				break;
			}
		}
		//7. Print only the Strings that have the letter 'e' in them.
		for (int i = 0; i < strings.length; i++) {
			if(strings[i].contains("e")) {
				System.out.println(strings[i]);
			}
		}
	}
}
