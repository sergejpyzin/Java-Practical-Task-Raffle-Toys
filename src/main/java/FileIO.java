import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {



    public static void writeFile(List<Toy> toyList, String pathFile){
        try {
            File file = new File(pathFile);
            if (file.createNewFile()){
                System.out.println("Файл создан");
            }
            FileWriter fileWriter = new FileWriter(file);
            for (Toy toy:toyList) {
                fileWriter.write(toy.toString() + "\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<Toy> readFile(String path){
        List<Toy> toyList = new ArrayList<>();
        ToyService toyService = new ToyService();
        File file = new File(path);
        String toy;
        try(Scanner scanner = new Scanner(file, StandardCharsets.UTF_8)){
            while (scanner.hasNextLine()){
                toy = scanner.nextLine();
                toyList.add(toyService.createdToy(toy));
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return toyList;
    }
}
