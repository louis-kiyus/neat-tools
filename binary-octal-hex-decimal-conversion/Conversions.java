public class Conversions {
    public static void main(String[] args) {
        System.out.println("--------------------");
        System.out.println("Binary, Decimal, Octal and Hexadecimal Conversions");
        System.out.println("--------------------");
        if (args[0].equalsIgnoreCase("b")) {
            System.out.println("Binary to Decimal: " + Integer.parseInt(args[1], 2));
            System.out.println();
            System.out.println("Binary to Octal: " + Integer.toOctalString(Integer.parseInt(args[1], 2)));
            System.out.println();
            System.out.println("Binary to Hexadecimal: " + Integer.toHexString(Integer.parseInt(args[1], 2)));
        } else if (args[0].equalsIgnoreCase("d")) {
            System.out.println("Decimal to Binary: " + Integer.toBinaryString(Integer.parseInt(args[1])));
            System.out.println();
            System.out.println("Decimal to Octal: " + Integer.toOctalString(Integer.parseInt(args[1])));
            System.out.println();
            System.out.println("Decimal to Hexadecimal: " + Integer.toHexString(Integer.parseInt(args[1])));
        } else if (args[0].equalsIgnoreCase("o")) {
            System.out.println("Octal to Binary: " + Integer.toBinaryString(Integer.parseInt(args[1], 8)));
            System.out.println();
            System.out.println("Octal to Decimal: " + Integer.parseInt(args[1], 8));
            System.out.println();
            System.out.println("Octal to Hexadecimal: " + Integer.toHexString(Integer.parseInt(args[1], 8)));
        } else if (args[0].equalsIgnoreCase("h")) {
            System.out.println("Hexadecimal to Binary: " + Integer.toBinaryString(Integer.parseInt(args[1], 16)));
            System.out.println();
            System.out.println("Hexadecimal to Decimal: " + Integer.parseInt(args[1], 16));
            System.out.println();
            System.out.println("Hexadecimal to Octal: " + Integer.toOctalString(Integer.parseInt(args[1], 16)));
        }

    }
}