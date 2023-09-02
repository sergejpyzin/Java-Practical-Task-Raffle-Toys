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
        List<String> idArray = new ArrayList<>();
        List<String> nameArray = new ArrayList<>();
        List<String> frequencyOfLossArray = new ArrayList<>();
        int size = userInteraction.checkingUserAnswerForInt("Введите количество игрушек для розыгрыша:");
        while (size > 0) {
            String userAnswer = userInteraction.checkingUserAnswerFromEmpty("""
                    Введите игрушки для розыграша в формате:
                    'id игрушки, наименование, шанс выпадения в процентах'
                    Пример: 1, конструктор, 30""");
            String[] splitString = userAnswer.split(" ");
            if (isSize(splitString)) {
                idArray.add(splitString[0]);
                nameArray.add(splitString[1].replace(",", ""));
                frequencyOfLossArray.add(splitString[2]);
                size--;
            } else {
                System.out.println("Внимание! Ошибка формата ввода. ");
            }
        }
        for (int i = 0; i < idArray.size(); i++) {
            toys.add(new Toy(idArray.get(i), nameArray.get(i), frequencyOfLossArray.get(i)));
        }
        FileIO.writeFile(toys, pathWrite);
    }

    public void raffle(List<Toy> toysList, String path) {
        List<Toy> toyRaffle = new ArrayList<>();
        PriorityQueue<Toy> raffle = new PriorityQueue<>(toysList);
        while (!raffle.isEmpty()) {
            toyRaffle.add(0, raffle.poll());
        }
        System.out.println("Розыгрыш проведен успешно");
        FileIO.writeFile(toyRaffle, path);
    }

    public Toy createdToy(String toysString) {
        String[] splitString = toysString.split(" ");
        String id = splitString[1];
        String name = splitString[2].replace(",", "");
        String frequencyOfLoss = splitString[splitString.length - 1];
        return new Toy(id, name, frequencyOfLoss);
    }

    private boolean isSize(String[] someString) {
        return someString.length == 3;
    }


}
