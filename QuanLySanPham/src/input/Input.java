package input;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static int number() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Hãy nhập số nguyên!");
            }
        }
    }

    public static String string() {
        while (true) {
            String regex = ".+";
            String str = scanner.nextLine();
            if (str.matches(regex)) return str;
            else System.out.println("Không nhập chuỗi trống");
        }
    }

    public static double inputDoubleNumber() {
        while (true) {
            try {
                double number = Double.parseDouble(scanner.nextLine());
                return number;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Hãy nhập kiểu giá số nguyên hoặc số thực");
            }
        }
    }
}