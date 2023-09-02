import java.util.List;
import java.util.Scanner;

public class UserInterface {

    static UserInteraction userInteraction = new UserInteraction();


    private static void menuApp(String pathForRaffleFile, String pathRaffleFile) {
        ToyService toyService = new ToyService();
//        Scanner scanner = new Scanner(System.in);
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
                    =================================""");
            answer = userInteraction.checkingUserAnswerFromEmpty("Введите номер меню");
            if (!answer.equals("1") && !answer.equals("2") && !answer.equals("3")) {
                System.out.println("Введен некорректный номер меню! Попробуйте еще раз");
                answer = userInteraction.checkingUserAnswerFromEmpty("Введите номер меню");
            }
            if (answer.equals("1")) {
                toyService.toyService(pathForRaffleFile);
            }
            if (answer.equals("2")) {
                List<Toy> toysForRaffle = FileIO.readFile(pathForRaffleFile);
                if (toysForRaffle.isEmpty()) {
                    System.out.println("""
                            Список игрушек для розыгрыша пуст. Внесите хотя бы одну игрушку.
                            ===================================================""");
                    toyService.toyService(pathForRaffleFile);
                } else {
                    toyService.raffle(toysForRaffle, pathRaffleFile);
                }
                do {
                    answer = userInteraction.checkingUserAnswerFromEmpty("Вывести результаты розыгрыша в консоль? Да/Нет");
                    if (answer.equalsIgnoreCase("да")) {
                        System.out.println("""
                                =====================================
                                Результаты розыгрыша:""");
                        toyService.showToys(FileIO.readFile(pathRaffleFile));
                    } else if (answer.equalsIgnoreCase("нет")) {
                        break;
                    } else {
                        System.out.println("Некорректный ввод. Попробуйте ещё раз.");
                    }
                } while (!answer.equalsIgnoreCase("да") && !answer.equalsIgnoreCase("нет"));

            }
        } while (!answer.equals("3"));
        System.out.println("Спасибо за использование нашей программы. До свидания.");
        System.exit(0);
    }

    public static void runApp() {
        /*String pathForRaffleFile = userInteraction.checkingUserAnswerFromEmpty("Введите имя файла для сохранения списка игрушек:");
        String pathRaffleFile = userInteraction.checkingUserAnswerFromEmpty("Введите имя файла для сохранения результатов розыгрыша игрушек:");*/
        String pathForRaffleFile = "inputToys.txt";
        String pathRaffleFile = "resultRaffle.txt";
        menuApp(pathForRaffleFile, pathRaffleFile);
    }

}
