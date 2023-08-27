import java.util.Scanner;

public class UserInteraction {

    public int checkingIntMassage(String massage) {
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.next();
        int number = 0;
        try {
           number = Integer.parseInt(userAnswer);
           
        } catch (NumberFormatException e){
            System.out.println("Введенное значение не число " + e.getMessage());
        }
        return number;
    }
}
