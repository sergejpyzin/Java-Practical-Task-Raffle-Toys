import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileIO {

    public static void writeFile(List<Toy> toyList){
        try {
            FileWriter fileWriter = new FileWriter("test.txt");
            for (Toy toy:toyList) {
                String toys = toy.toString();
                System.out.println(toys);
                fileWriter.write(toys + "\n");
            }
//            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
