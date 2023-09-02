import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
/*        Toy firstToy = new Toy("1", "First", "20");
        Toy secondToy = new Toy("2","First", "20");
        Toy thirdToy = new Toy("3", "Second", "20");
        List<Toy> toys = new ArrayList<>();
        toys.add(firstToy);
        toys.add(secondToy);
        toys.add(thirdToy);
        toys.add(new Toy("4","Second", "20"));
        toys.add(new Toy("5","Third", "60"));
        toys.add(new Toy("6","Third", "60"));
        toys.add(new Toy("7","Third", "60"));
        toys.add(new Toy("8","Third", "60"));
        toys.add(new Toy("9","Third", "60"));
        toys.add(new Toy("10","Third", "60"));



// Compute the total weight of all items together
// Now choose a random item
        List<Toy> resultRaffle = new ArrayList<>();
        while (!toys.isEmpty()){
            double totalWeight = 0.0d;
            for (Toy toy : toys)
            {
                totalWeight += Integer.parseInt(toy.getFrequencyOfLoss());
            }
            int randomIndex = -1;
            double random = Math.random() * totalWeight;
            for (int i = 0; i < toys.size(); ++i)
            {
                int toyWeight = Integer.parseInt(toys.get(i).getFrequencyOfLoss());
                random -= toyWeight;
                if (random <= 0.0d)
                {
                    randomIndex = i;
                    break;
                }
            }
            Toy RandomToy = toys.get(randomIndex);
            resultRaffle.add(RandomToy);
            toys.remove(toys.get(randomIndex));
        }*/
//        Collections.sort(toys);
        ToyService toyService = new ToyService();
        List<Toy> result = FileIO.readFile("inputToys.txt");
//        System.out.println(result);
        /*toyService.raffleAllToys(result, "result.txt");
        toyService.randomToyIndex(result);*/
        toyService.printRaffleToy(result);


//        UserInterface.runApp();
        /*List<String> name = new ArrayList<>();
        List<Integer> frequency = new ArrayList<>();
        for (Toy toy: toys){
            name.add(toy.getName());
            frequency.add(Integer.parseInt(toy.getFrequencyOfLoss()));
        }
        String []nameArray = new String[name.size()];
        int[] frequencyArray = new int[frequency.size()];
        for (int i = 0; i < nameArray.length; i++){
            nameArray[i] = name.get(i);
            frequencyArray[i] = frequency.get(i);
        }
        *//*int[] number = new int[] {0, 1,  23, 456, 7890, 12345}; // Числа
        int[] chance = new int[] {0, 50, 1, 1,    1,    10   }; // Количество*//*

        int count = IntStream.of(frequencyArray).sum(); // Считаем количество элементов воображаемого массива

        // Вывод вероятностей:
        for (int i = 0; i < frequencyArray.length; i++) {
            System.out.println("Вероятность игрушки \"" + nameArray[i] + "\":  \t" + (frequencyArray[i]*100d/count) + "%");
        }

        // Генерация случайного числа
        Random random = new Random();
        for (int randomNumsCount = 0; randomNumsCount < 10; randomNumsCount++) {

            int index = random.nextInt(count); // Выбираем случайный индекс из воображаемого массива

            for (int i = 0; i < frequencyArray.length; i++) { // Ищем элемент, которому принадлежит этот индекс
                index -= frequencyArray[i];
                if(index < 0) {
                    System.out.println("Случайная игрушка: " + nameArray[i]);
                    break;
                }
            }

        }
*/
    }

}
