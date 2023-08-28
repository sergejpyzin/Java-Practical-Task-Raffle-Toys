import java.util.ArrayList;
import java.util.List;


public class ToyService {

    List<Toy> toyList = new ArrayList<>();

    public void showToys() {
        if (toyList.isEmpty()) {
            System.out.println("Список игрушек пуст");
        } else {
            toyList.forEach(System.out::println);
        }

    }

    public List<Toy> toysList() {
        List<Toy> toys = new ArrayList<>();
        int size = UserInteraction.checkingUserAnswerForInt("Введите количество игрушек для розыгрыша:\n");
        while (size > 0) {
            String userAnswer = UserInteraction.checkingUserAnswerFromEmpty("Введите игрушку для розыгрыша в формате " +
                    "'кол-во наименование вероятность выпадения'");
            String[] splitString = userAnswer.split(" ");
            int count = Integer.parseInt(splitString[0]);
            for (int i = 0; i < count; i++) {
                toys.add(new Toy(splitString[1], Double.parseDouble(splitString[2])));
            }
            size -=count;
        }
        return toys;
    }


}
