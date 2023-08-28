import java.util.ArrayList;
import java.util.List;

public class ToyService{

    List<Toy> toyList = new ArrayList<>();

    public void showToys(){
        if (toyList.isEmpty()){
            System.out.println("Список игрушек пуст");
        } else {
            toyList.forEach(System.out::println);
        }

    }

    public List<Toy> toysList(){
        List<Toy> toys = new ArrayList<>();
        int size = UserInteraction.checkingUserAnswerForInt("Введите количество игрушек для розыгрыша:\n");

        return toys;
    }


}
