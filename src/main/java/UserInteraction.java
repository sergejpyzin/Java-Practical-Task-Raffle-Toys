import java.util.Scanner;

public class UserInteraction {

    /**
     * Метод преобразования полученного строкового значения в целочисленное.
     * Возвращает целочисленное значение
     * @param massage - сообщение для пользователя
     * */
    protected int checkingUserAnswerForInt(String massage) {
        boolean flag = false;
        int parseAnswer = 0;
        do {
            try {
                String checkAnswer = checkingUserAnswerFromEmpty(massage);
                parseAnswer = Integer.parseInt(checkAnswer);
                flag = true;
            } catch (NumberFormatException e) {
                System.out.println("Введенное значение не число!");
            }
        } while (!flag);
        return parseAnswer;
    }

    /**
     * Метод преобразования элемента массива строк в целочисленное значение.
     * Возвращает целочисленное значение.
     * @param someString - массив строк
     * @param index - индекс элемента массива строк
     * */
    protected int checkStringParseToInt(String[] someString, int index) {
        int parseStringToInt = 0;
        try {
            parseStringToInt = Integer.parseInt(someString[index].replace(",", ""));
        } catch (NumberFormatException e) {
            System.out.println("Введенное значение не число!");
        }
        return parseStringToInt;
    }

    /**
     * Метод проверки ответа от пользователя на содержание.
     * Возвращает полученный ответ от пользователя.
     * @param massage - сообщение для пользователя
     * */
    protected String checkingUserAnswerFromEmpty(String massage) {
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
}
