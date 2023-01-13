import java.util.Scanner;

public class ToLatex {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String equation = scan.nextLine();

        String latexString = "";
        for (int i = 0; i < equation.length(); i++) {
            switch (equation.charAt(i)) {
                case '∧':
                    latexString += "\\land ";
                    break;
                case '∨':
                    latexString += "\\lor ";
                    break;
                case '¬':
                    latexString += "\\neg ";
                    break;
                case '↔':
                    latexString += "\\leftrightarrow ";
                    break;
                case '→':
                    latexString += "\\rightarrow ";
                    break;
                default:
                    latexString += equation.charAt(i);

            }
        }
        System.out.println(latexString);
    }
}