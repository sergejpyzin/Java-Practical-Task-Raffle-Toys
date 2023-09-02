import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class ToyService {

    UserInteraction userInteraction = new UserInteraction();


    public void showToys(List<Toy> toyList) {
        if (toyList.isEmpty()) {
            System.out.println("Список игрушек пуст");
        } else {
            toyList.forEach(System.out::println);
        }

    }

    public void toyService(String pathWrite) {
        List<Toy> toys = new ArrayList<>();
        int size = userInteraction.checkingUserAnswerForInt("Введите количество игрушек для розыгрыша:");
        while (size > 0) {
            String userAnswer = userInteraction.checkingUserAnswerFromEmpty("""
                    Введите игрушки для розыграша в формате:
                    'кол-во игрушек наименование шанс выпадения в процентах'
                    Пример: 2 конструктор 30""");
            String[] splitString = userAnswer.split(" ");
            if (isSize(splitString)) {
                String name = splitString[1].replace(",", "");
                int count = parseCount(splitString);
                int frequencyOfLoss = parseFrequencyOfLoss(splitString);
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
            }
        }
        FileIO.writeFile(toys, pathWrite);
    }

    public void raffle(List<Toy> toysList, String path) {
        List<Toy> toyRaffle = new ArrayList<>();
        PriorityQueue<Toy> raffle = new PriorityQueue<>(toysList);
        while (!raffle.isEmpty()) {
            toyRaffle.add(raffle.poll());
        }
        System.out.println("Розыгрыш проведен успешно");
        FileIO.writeFile(toyRaffle, path);
    }

    public Toy createdToy(String toysString) {
        String[] splitString = toysString.split(" ");
        String name = splitString[1].replace(",", "");
        int frequencyOfLoss = parseFrequencyOfLoss(splitString);
        return new Toy(name, frequencyOfLoss);
    }

    private int parseCount(String[] someString) {
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

    private int parseFrequencyOfLoss(String[] someString) {
        boolean flag = false;
        int number = 0;
        do {
            try {
                number = Integer.parseInt(someString[4]);
                flag = true;
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());

            }
        } while (!flag);
        return number;
    }

    private boolean isSize(String[] someString) {
        return someString.length == 3;
    }


}
