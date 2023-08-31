import java.util.ArrayList;
import java.util.List;


public class ToyService {

    List<Toy> toyList = new ArrayList<>();

    //
    public void showToys(List<Toy> toyList) {
        if (toyList.isEmpty()) {
            System.out.println("Список игрушек пуст");
        } else {
            toyList.forEach(System.out::println);
        }

    }

    public List<Toy> toysList() {
        List<Toy> toys = new ArrayList<>();
        int size = UserInteraction.checkingUserAnswerForInt("Введите количество игрушек для розыгрыша:");
        while (size > 0) {
            String userAnswer = UserInteraction.checkingUserAnswerFromEmpty(
                    """
                            Введите игрушки для розыграша в формате:
                            'кол-во игрушек наименование шанс выпадения в процентах'
                            Пример: 2 конструктор 30
                            """);
            String[] splitString = userAnswer.split(" ");
            if (isSize(splitString)) {
                String name = splitString[1];
                int count = parseInt(splitString);
                double frequencyOfLoss = parseDouble(splitString);
                int temp = size;
                int countPlace = size - count;
                size = countPlace;
                System.out.println("ВНИМАНИЕ! Осталось мест в списке для розыграша - " + size);
                if (countPlace < 0) {
                    System.out.println("Количество игрушек превышает максимально возможное. Будет добавлено игрушек " + name + " - " + temp);
                    count = temp;
                }
                for (int i = 0; i < count; i++) {
                    toys.add(new Toy(name, frequencyOfLoss));
                }
            } else {
                System.out.println("Внимание! Ошибка формата ввода. ");
                toysList();
            }
        }
        return toys;

    }

    private int parseInt(String[] someString) {
        int number = 0;
        boolean flag = false;
        do {
            try {
                number = Integer.parseInt(someString[0]);
                flag = true;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!flag);
        return number;
    }

    private double parseDouble(String[] someString) {
        boolean flag = false;
        double number = 0;
        do {
            try {
                number = Double.parseDouble(someString[2].replace(",", "."));
                flag = true;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!flag);
        return number;
    }

    private boolean isSize(String[] someString) {
        return someString.length == 3;
    }


}
