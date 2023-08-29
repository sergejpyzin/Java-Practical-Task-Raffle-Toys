import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Toy firstToy = new Toy("First", 0.35);
        Toy secondToy = new Toy("Second", 0.35);
        Toy thirdToy = new Toy();

        thirdToy.setName("Third");
        thirdToy.setFrequencyOfLoss(0.5);

        List<Toy> toys = new ArrayList<>();
        toys.add(firstToy);
        toys.add(secondToy);
        toys.add(thirdToy);
        toys.add(new Toy("Four", 0.22));
        toys.add(new Toy("Five", 0.66));
        FileIO.writeFile(toys);*/


        /*int number = UserInteraction.checkingUserAnswerForInt("Введите число: ");
        System.out.println(number);*/
        ToyService toyService = new ToyService();
        List<Toy> toys = toyService.toysList();
        System.out.println(toys);
        FileIO.writeFile(toys);
        /*double number = UserInteraction.checkingUserAnswerForDouble("222");
        System.out.println(number);*/
    }

}
