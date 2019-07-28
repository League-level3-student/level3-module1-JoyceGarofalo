package _02_Integer_Stack;

import java.util.ArrayList;

public class IntegerStack {
	//1. create a private array of integers
	private int[] ints;

	//2. complete the constructor by initializing the member array
	//   to a new array of length 0. This prevents null pointer exceptions.

	public IntegerStack() {
		ints = new int[0];
	}
	
	//3. Complete the steps in the push method.
	public void push(int v) {
		//A. create a new array that is one element larger than the member array
		int[] newArray = new int[ints.length+1];
		//B. set the last element of the new array equal to the integer passed into the method
		newArray[newArray.length-1] = v;
		//C. iterate through the member array and copy all the elements into the new array
		for (int i = 0; i < ints.length; i++) {
			newArray[i] = ints[i];
		}
		//D. set the member array equal to the new array.
		ints = newArray;
	}
	
	//4. Complete the steps in the pop method.
	public int pop() {
		//A. create an integer variable and initialize it to the
		//   last element of the member array.
		int last = ints[ints.length-1];
		//B. create a new array that is one element smaller than the member array
		int[] smallArray = new int[ints.length-1];
		//C. iterate through the new array and copy every element from the
		//   member array to the new array
		for (int i = 0; i < smallArray.length; i++) {
			smallArray[i] = ints[i];
		}
		//D. set the member array equal to the new array
		ints = smallArray;
		//E. return the variable you created in step A
		return last;
		
	}
	
	//5. Complete the clear method to set the
	//   member array to a new array of length 0
	public void clear() {
		ints = new int[0];
	}
	
	//6. Complete the size method to return 
	//   the length of the member array
	public int size() {
		return ints.length;
	}
}
