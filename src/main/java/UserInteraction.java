import java.util.Scanner;

public class UserInteraction {

    public static int checkingUserAnswerForInt(String massage) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(massage);
        boolean flag = false;
        int userAnswer = 0;
        do {
            try {
                userAnswer = Integer.parseInt(scanner.next());
                flag = true;
            } catch (NumberFormatException e) {
                System.out.println("Введенное значение не число ");
            }
        } while (!flag);
        return userAnswer;
    }

    public static double checkingUserAnswerForDouble(String massage) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(massage);
        boolean flag = false;
        double userAnswer = 0;
        do {
            try {
                userAnswer = Double.parseDouble(scanner.next());
                flag = true;
            } catch (NumberFormatException e) {
                System.out.println("Введенное значение не число ");
            }
        } while (!flag);
        return userAnswer;
    }
}
