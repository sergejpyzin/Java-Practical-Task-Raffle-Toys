import java.util.Scanner;

public class UserInteraction {

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

    public String answerIsEmpty(String massage){
        Scanner scanner = new Scanner(System.in);
        String answer;
        boolean flag = true;
        do {
            answer = scanner.next();
            if(answer.isEmpty()){
                System.out.println("Некорректный ввод. Попробуйте ещё раз");
            }else {
                flag = false;
            }
        }while (flag);
        return answer;
    }


}
