package practice.reverseArray;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter text:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(Arrays.toString(ReverseArray.reverse(line.split(" +"))));
    }
}
