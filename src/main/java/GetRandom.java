import java.util.Random;

public class GetRandom {
    public static int random(){
        Random random = new Random();
        return random.nextInt(1, 101);
    }
}
