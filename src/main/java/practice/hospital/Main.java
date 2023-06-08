package practice.hospital;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the number of hospital patients:");
        Scanner scanner = new Scanner(System.in);
        int patientsCount = scanner.nextInt();
        float[] temperatureData = Hospital.generatePatientsTemperatures(patientsCount);
        System.out.println(Hospital.getReport(temperatureData));
    }
}
