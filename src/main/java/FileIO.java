import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileIO {

    public static void writeFile(List<Toy> toyList, String pathFile){
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            for (Toy toy:toyList) {
                fileWriter.write(toy.toString() + "\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
