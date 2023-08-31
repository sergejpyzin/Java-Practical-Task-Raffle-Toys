import java.util.*;

public class Main {
    public static void main(String[] args) {
        Toy firstToy = new Toy("First", 0.65);
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




        ToyService toyService = new ToyService();
        toyService.raffle(toys);
        /*List<Toy> test = toyService.toysList();
        List<Toy> testQueue = new ArrayList<>();
        PriorityQueue<Toy> priorityQueue = new PriorityQueue<>(test);
        while(!priorityQueue.isEmpty()){
            testQueue.add(priorityQueue.poll());

        }
        FileIO.writeFile(testQueue, "testTwo");
        for (int i = 0; i < 5; i++) {
            testQueue.add(priorityQueue.poll());
        }
        System.out.println(testQueue);
        toyService.showToys(toys);*/
    }

}
