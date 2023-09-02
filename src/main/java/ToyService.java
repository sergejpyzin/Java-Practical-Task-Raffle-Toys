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
        List<Integer> idArray = new ArrayList<>();
        List<String> nameArray = new ArrayList<>();
        List<Integer> frequencyOfLossArray = new ArrayList<>();
        int size = userInteraction.checkingUserAnswerForInt("Введите количество игрушек для розыгрыша:");
        for (int i = 1; i < size + 1; i++) {
            idArray.add(i);
        }
        while (size > 0) {
            String userAnswer = userInteraction.checkingUserAnswerFromEmpty("""
                    Введите игрушки для розыгрыша в формате:
                    'количество игрушек, наименование, шанс выпадения в процентах'
                    Пример: 1, конструктор, 20""");
            String[] splitString = userAnswer.split(" ");
            int count = Integer.parseInt(splitString[0]);
            for (int i = 0; i < count; i++) {
                if (isSize(splitString)) {
                    nameArray.add(splitString[1].replace(",", ""));
                    frequencyOfLossArray.add(Integer.parseInt(splitString[2]));
                    size--;
                } else {
                    System.out.println("Внимание! Ошибка формата ввода. ");
                }
            }
        }
        for (int i = 0; i < idArray.size(); i++) {
            toys.add(new Toy(idArray.get(i), nameArray.get(i), frequencyOfLossArray.get(i)));
        }
        FileIO.writeFile(toys, pathWrite);
    }

    public void raffle(List<Toy> toysList, String path) {
        List<Toy> toyRaffle = new ArrayList<>();
        List<Toy> resultRaffle = new ArrayList<>();
        PriorityQueue<Toy> raffle = new PriorityQueue<>(toysList);
        while (!raffle.isEmpty()) {
            toyRaffle.add(createdToy(String.valueOf(raffle.poll())));
        }
        System.out.println(toyRaffle);
        while (!toyRaffle.isEmpty()) {
            double totalWeight = 0.0d;
            for (Toy toy : toyRaffle) {
                totalWeight += toy.getFrequencyOfLoss();
            }
            int randomIndex = -1;
            double random = Math.random() * totalWeight;
            for (int i = 0; i < toyRaffle.size(); ++i) {
                int toyWeight = toyRaffle.get(i).getFrequencyOfLoss();
                random -= toyWeight;
                if (random <= 0.0d) {
                    randomIndex = i;
                    break;
                }
            }
            Toy RandomToy = toyRaffle.get(randomIndex);
            resultRaffle.add(RandomToy);
            toyRaffle.remove(toyRaffle.get(randomIndex));
        }
        System.out.println("Розыгрыш проведен успешно");
        FileIO.writeFile(resultRaffle, path);
    }

    public Toy createdToy(String toysString) {
        String[] splitString = toysString.split(" ");
        int id = Integer.parseInt(splitString[1]);
        String name = splitString[4].replace(",", "");
        int frequencyOfLoss = Integer.parseInt(splitString[splitString.length - 1]);
        return new Toy(id, name, frequencyOfLoss);
    }

    private boolean isSize(String[] someString) {
        return someString.length == 3;
    }


}
