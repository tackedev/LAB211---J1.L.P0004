package utils;

import java.util.Scanner;

/**
 *
 * @author tackedev
 */
public class KeyboardIO {
    
    static final Scanner sc = new Scanner(System.in);
    
    public static int getInteger(String inputMsg, String errorMsg) {
        while (true) {
            System.out.print(inputMsg);
            String input = sc.nextLine().trim();
            try {
                int n = Integer.parseInt(input);
                return n;
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static int getInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        
        while (true) {
            int n = getInteger(inputMsg, errorMsg);
            if (n < lowerBound || upperBound < n) {
                System.out.println("input out of range");
            } else {
                return n;
            }
        }
    }
    
    public static double getDouble(String inputMsg, String errorMsg) {
        while (true) {
            System.out.print(inputMsg);
            String str = sc.nextLine().trim();
            if (str.isEmpty()) {
                return 0;
            }
            try {
                double n = Double.parseDouble(str);
                return n;
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static double getDouble(String inputMsg, String errorMsg, double lowerBound, double upperBound) {
        if (lowerBound > upperBound) {
            double tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        
        while (true) {
            double n = getDouble(inputMsg, errorMsg);
            if (n < lowerBound || upperBound < n) {
                System.out.println("input out of range");
            } else {
                return n;
            }
        }
    }
    
    public static String getString(String inputMsg) {
        System.out.print(inputMsg);
        String str = sc.nextLine().trim();
        return str;
    }
    
    public static String getNoneEmptyString(String inputMsg, String errorMsg) {
        while (true) {
            try {
                String str = getString(inputMsg);
                if (str.length() == 0 || str.isEmpty()) {
                    throw new Exception("empty input");
                }
                return str;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static boolean confirm(String inputMsg, String errorMsg) {
        String input;
        do {
            input = getString(inputMsg + " (Y/N): ");
            if (!input.equals("Y") && !input.equals("y") && !input.equals("N") && !input.equals("n")) {
                System.out.println(errorMsg);
            }
        } while (!input.equals("Y") && !input.equals("y") && !input.equals("N") && !input.equals("n"));
        return (input.equals("Y") || input.equals("y"));
    }
}