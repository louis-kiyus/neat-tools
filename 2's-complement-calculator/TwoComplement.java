import java.util.Scanner;

public class TwoComplement {
    private static String toSignedInteger(String num) {
        String signedInteger;
        if (Integer.parseInt(num.substring(0, 1)) == 1)
            signedInteger = Integer
                    .toString(Integer.parseInt(num.substring(1), 2) - (int) Math.pow(2, num.length() - 1));
        else
            signedInteger = Integer.toString(Integer.parseInt(num, 2));
        return signedInteger;
    }

    private static String zeroPadding(String num, int bits) {
        while (num.length() < bits) { // zero padding
            num = "0" + num;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println("--------------------");
        System.out.println("Brief Notes: ");
        System.out.println("One's Complement simply flips all the bits to represent negative numbers.");
        System.out.println("Two's Complement is the same as One's Complement, but adds 1 to the flipped bits.");
        System.out.println("The most significant bit (left-most) is the sign bit.");
        System.out.println("If the sign bit is 0, the number is positive.");
        System.out.println("If the sign bit is 1, the number is negative.");
        System.out.println(
                "With Two's Complement, we can simply add two positive and negative binaries together to get the correct sum.");
        System.out.println(
                "To find the value of Two's Complement, we calculate the value of the left-most digit and treat it as a negative number. The rest of the digits are treated as positive.");
        System.out.println("--------------------");
        Scanner input = new Scanner(System.in);
        System.out.println("Number of bits:");
        int bits = input.nextInt();
        input.nextLine();
        System.out.println("Integer or Binary? (I/B)");

        String num;
        if (input.nextLine().equalsIgnoreCase("I")) {
            System.out.println("Enter an integer: ");
            num = input.nextLine();

            if (Integer.parseInt(num) > 0) {

                num = Integer.toBinaryString(Integer.parseInt(num));
                num = zeroPadding(num, bits);
                System.out.println("Binary: " + num);
            } else {
                num = Integer.toBinaryString(0 - Integer.parseInt(num));
                num = zeroPadding(num, bits);
            }
        } else {
            System.out.println("Enter a binary number: ");
            num = input.nextLine();
            num = zeroPadding(num, bits);
            System.out.println("--------------------");
            System.out.println("Unsigned Integer Interpretation: " + Integer.parseInt(num, 2));

            System.out.println("Signed Integer Interpretation: " + toSignedInteger(num));
        }

        String complement = "";
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                complement += "1";
            } else {
                complement += "0";
            }
        }
        if (complement.charAt(complement.length() - 1) == '0') {
            complement = complement.substring(0, complement.length() - 1) + "1";
        } else {
            complement = complement.substring(0, complement.length() - 1) + "0";
            int i = complement.length() - 2;
            while (complement.charAt(i) == '1') {
                complement = complement.substring(0, i) + "0" + complement.substring(i + 1);
                i--;
            }
            complement = complement.substring(0, i) + "1" + complement.substring(i + 1);
        }
        System.out.println("--------------------");
        System.out.println("Two's complement: " + complement);
        System.out.println("Unsigned Integer: " + Integer.parseInt(complement, 2));
        System.out.println("Signed Integer Interpretation: " + toSignedInteger(complement));
    }
}