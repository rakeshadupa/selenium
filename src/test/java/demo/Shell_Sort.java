package demo;

import java.util.Scanner;

public class Shell_Sort {
	static void shellsort(int[] arr, int length) {
		int i, j, k, tmp;
		for (i = length / 2; i > 0; i = i / 2) {
			for (j = i; j < length; j++) {
				for (k = j - i; k >= 0; k = k - i) {
					if (arr[k + i] >= arr[k])
						break;
					else {
						tmp = arr[k];
						arr[k] = arr[k + i];
						arr[k + i] = tmp;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[30];
		int k, length;
		System.out.println("Enter total no. of elements : ");
		length = sc.nextInt();
		for (k = 0; k < length; k++) {
			arr[k] = sc.nextInt();
		}
		sc.close();
		shellsort(arr, length);
		System.out.println("\n Sorted array is: ");
		for (k = 0; k < length; k++)
			System.out.println(arr[k]);
	}
}