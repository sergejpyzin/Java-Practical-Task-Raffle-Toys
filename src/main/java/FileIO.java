import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileIO {

    public static void writeFile(List<Toy> toyList){
        try {
            FileWriter fileWriter = new FileWriter("test.txt");
            for (Toy toy:toyList) {
                fileWriter.write(toy.toString() + "\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
