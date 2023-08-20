public class Main {
    public static void main(String[] args) {
        Toy firstToy = new Toy("First", 0.35);
        Toy secondToy = new Toy("Second", 0.35);
        Toy thirdToy = new Toy();
        thirdToy.setName("Third");
        thirdToy.setFrequencyOfLoss(0.5);

        System.out.println(firstToy);
        System.out.println(secondToy);
        System.out.println(thirdToy);
    }
}
