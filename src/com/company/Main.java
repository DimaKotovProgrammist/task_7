package com.company;
import java.util.Scanner;

public class Main {
    public static int[] tests () {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 1, 1, 1, 1};
        int[] arr3 = {1, 2, 3, 3, 4};
        int[] arr4 = {1, 2, 2, 3, 4};
        int[] arr5 = {1, 2, 1, 2, 1, 2};
        int[] arr6 = {1, 2, 2, 3, 4, 4, 5, 6, 7};
        int[] arr7 = {1, 2, 2, 3, 4, 5, 5, 6, 7};
        int[] arr8 = {1, 1, 1, 2, 2, 2};
        int[] arr9 = {1, 1, 2, 1, 2, 3};
        int[] arr10 = {1, 1, 2, 3, 1, 2};
        return solution(arr1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Количество элементов подпоследовательности: " + solution(arr)[0]);
        System.out.println("Позиция её первого элемента: " + solution(arr)[1]);
        System.out.println("----------------tests----------------");
        System.out.println("Количество элементов подпоследовательности: " + tests()[0]);
        System.out.println("Позиция её первого элемента: " + tests()[1]);
    }

    public static int[] solution (int[] arr) {
        int counter = 0;
        int numPos = 0;
        int len = 0;
        int lenMax = 0;
        int[] otvet = new int[2];

        for (int i = 0; i < arr.length; i++) {
            len++;
            for (int j = counter; j < i + 1; j++) {
                if (i == arr.length - 1) {
                    break;
                }
                if (arr[i + 1] == arr[j]) {
                    if (lenMax < len) {
                        lenMax = len;
                        numPos = counter + 1;
                    }
                    len = 0;
                    counter = i + 1;
                }
            }
        }

        if (lenMax < len) {
            lenMax = len;
            numPos = counter + 1;
        }

        otvet[0] = lenMax;
        otvet[1] = numPos;

        return otvet;
    }
}

