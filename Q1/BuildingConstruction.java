package com.GA2.Q1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class BuildingConstruction {
	private static Scanner in = new Scanner(System.in);
	static ArrayList<Integer> tempList = new ArrayList<Integer>();
	public void Syscaper(int Floors){
		Stack<Integer> Stack = new Stack<Integer>();
		Stack<Integer> ts = new Stack<Integer>();
		int count = Floors;
			int[][] temp = new int[Floors][Floors];
		
		int i=0;
		int k = 0;
		for (i = 0; i < Floors; i++) {
			System.out.println("enter the floor n given on day : " + (i + 1));
			int n = in.nextInt();
			
			if (n > Floors || n < 1) {
				System.out.println("Invalid floor n");
				i--;
				continue;
			}
			if(ts.search(n)!=-1) {
				System.out.println("Size already present");
				i--;
				continue;
			}
			Stack.push(n);
			ts.push(n);
			
			while(!Stack.isEmpty()) {
				tempList.add(Stack.pop());
			}
			
			Collections.sort(tempList);
			
			for(int val : tempList) {
				Stack.push(val);
			}
			tempList.clear();
			
			k = 0;
			while (!Stack.isEmpty() && count == Stack.peek()) {
				count--;
				temp[i][k] = Stack.pop();
				k++;

			}
			sort(temp[i]);
		}
		i--;
		while(!Stack.isEmpty()) {
			temp[i][k++] = Stack.pop();
		}
		sort(temp[i]);

		for (i = 0; i < Floors; i++) {
			System.out.println("\nDay: " + (i + 1));
			for (int val : temp[i]) {
				if (val != 0)
					System.out.print(val + " ");
			}
		}
		
		ts.clear();

	}

	public void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] < temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}

	public void print(int[] arr) {
		for (int val : arr)
			System.out.print(val + " ");
	}
	public static void main(String[] args) {
		BuildingConstruction obj = new BuildingConstruction();

		System.out.println("enter the total no of floors in the building");
		obj.Syscaper(in.nextInt());

	}
	}