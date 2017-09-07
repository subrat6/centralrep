package com.hw.beans;

public class Calculator {

	public static void main(String[] args) {
		int arr[] = new int[10];
		int j = 1;
		while (j <= 10) {
			for (int i = 1; i <= arr.length; i++) {
				int total = j * i;
				System.out.println("total = " + j + "*" + i + " = " + total);
			}
			System.out.println("new------------------------------------------------new");
			j++;
		}
		System.out.println("Calculation completed");
	}

}
