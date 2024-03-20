package org.prannoy.core.tests;

import java.util.Scanner;

/*
 * RescueOps
You are given a string S of size N containing 3 operations - L (turn left), R (turn right), and M (move one step forward). These were the directions followed by Ben but now, he is lost. Assume that he started from the origin , you have to reach him at the earliest. Initially, Ben was starting at origin facing North.

You can travel in all 8 cardinal directions.

Write a program to print the path of minimum length in terms of the numbering given on the cardinal directions. Also append a 0 at the end to indicate that the destination is reached. 

Note

In case there are multiple paths of same length, you are to output the lexicographically smallest of them.

Input format

First line: T (number of test cases)
For each test case
First line: N
Second line: S
Output format

For each test case, print the path of minimum length in terms of the numbering given on the cardinal directions. If there are multiple such paths, print the lexicographically smallest one.


Sample Input
2
4
MMLM
6
LMRMLM


Sample Output
450
480

Explanation
Case 1: Ben moves 2 steps North, then turns left and moves one step towards west. So if initial position is (0,0) his final position is (-1,2). You can reach this in multiple ways: (NORTH, NORTH, WEST) or (WEST,NORTH, NORTH) or (NORTH, NORTHWEST). But the path which gives lexicographically smallest string, is (NORTHWEST, NORTH).
 * */
class TestClasss2 {
	static void calculateShortestLength(String move)  { 
		
		/*String directions[] = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};
		return directions[ (int)Math.round((  ((double)x % 360) / 45)) % 8 ]*/
		int l = move.length(); 
		int countUp = 0, countDown = 0; 
		int countLeft = 0, countRight = 0; 
		for (int i = 0; i < l; i++) { 
			if (move.charAt(i) == 'M') 
				countUp++; 
			else if (move.charAt(i) == 'L') 
				countLeft++; 
			else if (move.charAt(i) == 'R') 
				countRight++; 
		} 

		System.out.println((countRight - countLeft)+(countUp - countDown)+"0"); 
	} 
	public static void main(String args[] ) throws Exception {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		String numOfTimes = s.nextLine();                 // Reading input from STDIN
		Integer num = Integer.parseInt(numOfTimes);

		for(int i=0;i<num;i++) {
			int numOfSteps = Integer.parseInt(s.nextLine());
			String actualArray = s.nextLine();
			calculateShortestLength(actualArray);
		}

	}
}