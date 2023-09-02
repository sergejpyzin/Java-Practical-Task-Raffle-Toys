import java.util.List;
import java.util.Scanner;

public class UserInterface {

    static UserInteraction userInteraction = new UserInteraction();


    private static void menuApp(String pathForRaffleFile, String pathRaffleFile) {
        ToyService toyService = new ToyService();
        Scanner scanner = new Scanner(System.in);
        String answer;
        do {
            System.out.println("""
                    Здравствуйте, Вас приветствует программа для розыгрыша игрушек.
                    Данная программа имеет следующий функционал:
                    1. Добавление игрушки в меню розыгрыша;
                    2. Розыгрыш игрушек;
                    Результаты розыгрыша можно вывести на экран и сохранить в текстовом файле.
                    =================================
                    Введите 1 для добавления игрушки в список для розыгрыша;
                    Введите 2 для проведения розыгрыша;
                    Введите 3 для выхода из программы.
                    =================================
                    Введите номер меню:""");
            answer = scanner.next();
            if (answer.equals("1")){
                toyService.toyService(pathForRaffleFile);
            }
            if (answer.equals("2")){
                List<Toy> toysForRaffle = FileIO.readFile(pathForRaffleFile);
                if (toysForRaffle.isEmpty()){
                    System.out.println("""
                            Список игрушек для розыгрыша пуст. Внесите хотя бы одну игрушку.
                            ===================================================""");
                    toyService.toyService(pathForRaffleFile);
                }else{
                    toyService.raffle(toysForRaffle, pathRaffleFile);
                }
            }
        }while (!answer.equals("3"));
    }

    public static void runApp(){
        String pathForRaffleFile = userInteraction.checkingUserAnswerFromEmpty("Введите имя файла для сохранения списка игрушек:");
        String pathRaffleFile = userInteraction.checkingUserAnswerFromEmpty("Введите имя файла для сохранения результатов розыгрыша игрушек:");
        menuApp(pathForRaffleFile, pathRaffleFile);
    }

}
