import java.util.Scanner;

public class UserInteraction {

    public static int checkingUserAnswerForInt(String massage) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        int parseAnswer = 0;
        do {
            try {
                System.out.println(massage);
                String userAnswer = scanner.nextLine();
                if (userAnswer.isEmpty()) {
                    System.out.println("Ответ на запрос не может быть пустым! Попробуйте еще раз.");
                } else {
                    parseAnswer = Integer.parseInt(userAnswer);
                    flag = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введенное значение не число ");
            }
        } while (!flag);
        return parseAnswer;
    }

    public static double checkingUserAnswerForDouble(String massage) {
        boolean flag = false;
        double parseAnswer = 0;
        do {
            try {
                String checkAnswer = checkingUserAnswerFromEmpty(massage);
                parseAnswer = Double.parseDouble(checkAnswer);
                flag = true;
            } catch (NumberFormatException e) {
                System.out.println("Введенное значение не число ");
            }
        } while (!flag);
        return parseAnswer;
    }

    public static String checkingUserAnswerFromEmpty(String massage) {
        Scanner scanner = new Scanner(System.in);
        String userAnswer = null;
        boolean flag = false;
        do {
            System.out.println(massage);
            String parseAnswer = scanner.nextLine();
            if (parseAnswer.isEmpty()) {
                System.out.println("Ответ на запрос не может быть пустым! Попробуйте еще раз.");
            } else {
                userAnswer = parseAnswer;
                flag = true;
            }
        } while (!flag);
        return userAnswer;
    }

    public boolean isNotEmptyAnswerUser(String answerUser) {
        if (answerUser.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
