package org.prannoy.core.tests;

import java.util.Scanner;
/*
 * Sum of sub-arrays
An array X consists of N elements. You are given an integer K.

Write a program to find the sum of the lengths of the sub-arrays with K as its maximum number. Any two sub-arrays that are considered should not overlap each other. Find the maximum possible sum.

Input format

First line: T (number of test cases)
For each test case
First line: N and K
Second line: N space-separated integers (denoting the elements of the array)
Output format

For each test case, print the maximum sum.

Sample Input
3
5 4
4 8 5 2 4
10 3
7 2 3 1 2 3 1 6 2 3
1 2
3

Sample Output
3
8
0

Explanation
Case #1:
K = 4, A[] = {4,8,5,2,4}
All contiguous arrays that have 4 as maximum integer are {4}, {2,4}, {4}. Since we are not allowed to consider overlapping sub arrays, required answer is 1 + 2 = 3

Case #3:
No sub-array has K as maximum value. Hence answer is 0.
*/class TestClasss {
	static int calculateMaxSumLength(int arr[], int n, int k) { 
		int ans = 0; 
		int count = 0; 
		int flag = 0; 
		for (int i = 0; i < n;) { 
			count = 0; 
			flag = 0; 
			while (i < n && arr[i] <= k) { 
				count++; 
				if (arr[i] == k) 
					flag = 1; 
				i++; 
			} 
			if (flag == 1) 
				ans += count; 
			while (i < n && arr[i] > k) 
				i++; 
		} 
		return ans; 
	} 
	public static void main(String args[] ) throws Exception {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		String numOfTimes = s.nextLine();                 // Reading input from STDIN
		Integer num = Integer.parseInt(numOfTimes);

		for(int i=0;i<num;i++) {
			// Write your code here
			String[] numOfElementsAndMaxN = null;
			String nOfElem= null;
			String maxNum= null;
			Integer nOfElem2= null;
			Integer maxNum2= null;
			String[] eachElem= null;
			String numOfElementsAndMaxNumber = s.nextLine();
			numOfElementsAndMaxN = numOfElementsAndMaxNumber.split("\\s+");
			nOfElem = numOfElementsAndMaxN[0];
			maxNum = numOfElementsAndMaxN[1];

			nOfElem2 = Integer.parseInt(nOfElem);
			maxNum2 = Integer.parseInt(maxNum);

			String actualArray = s.nextLine();
			eachElem = actualArray.split("\\s+");

			int actualArrayNum[] = new int[nOfElem2];
			
			if(nOfElem2 == 1) {
				
				actualArrayNum[0] =  Integer.parseInt(eachElem[0]);
				
			} else {
				for (int j=0;j<nOfElem2;j++) {
					actualArrayNum[j] = Integer.parseInt(eachElem[j]);
				}
			}
			int ans = calculateMaxSumLength(actualArrayNum, nOfElem2, maxNum2);
			System.out.println(ans);

		}

	}
}