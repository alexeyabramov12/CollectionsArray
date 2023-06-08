package practice.twoDimensionalArray;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter number:");
        Scanner scanner = new Scanner(System.in);
        int sizeArray = scanner.nextInt();
        char [][] array = TwoDimensionalArray.getTwoDimensionalArray(sizeArray);
        for (char[] chars : array) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println("");
        }
    }
}
