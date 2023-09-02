import java.util.Arrays;
import java.util.List;

public class UserInterface {

    static UserInteraction userInteraction = new UserInteraction();


    private static void menuApp(String pathForRaffleFile, String pathRaffleFile) {
        ToyService toyService = new ToyService();
        String answer;
        String[] correctAnswer = {"1", "2", "3", "4", "да", "нет"};
        do {
            System.out.println("""
                    Здравствуйте, Вас приветствует программа для розыгрыша игрушек.
                    Данная программа имеет следующий функционал:
                    1. Добавление игрушки в меню розыгрыша;
                    2. Розыгрыш игрушек;
                    Результаты розыгрыша можно вывести на экран и сохранить в текстовом файле.
                    =================================
                    Введите 1 для добавления игрушки в список для розыгрыша;
                    Введите 2 для проведения розыгрыша всех игрушек;
                    Введите 3 для розыгрыша одной игрушки из списка
                    Введите 4 для выхода из программы.
                    =================================""");
            answer = userInteraction.checkingUserAnswerFromEmpty("Введите номер меню:");
            if (!Arrays.asList(correctAnswer).contains(answer)) {
                answer = userInteraction.checkingUserAnswerFromEmpty("Некорректный ввод. Введите номер меню:");
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
                    toyService.raffleAllToys(toysForRaffle, pathRaffleFile);
                }
                do {
                    answer = userInteraction.checkingUserAnswerFromEmpty("Вывести результаты розыгрыша в консоль? Да/Нет");
                    if (!Arrays.asList(correctAnswer).contains(answer)) {
                        answer = userInteraction.checkingUserAnswerFromEmpty("Некорректный ввод. Введите Да или Нет");
                    }
                    if (answer.equalsIgnoreCase("да")) {
                        System.out.println("""
                                =====================================
                                Результаты розыгрыша:""");
                        toyService.showToys(FileIO.readFile(pathRaffleFile));
                    } else if (answer.equalsIgnoreCase("нет")) {
                        break;
                    }
                } while (!answer.equalsIgnoreCase("да") && !answer.equalsIgnoreCase("нет"));

            }
            if (answer.equals("3")) {
                List<Toy> toysForRaffle = FileIO.readFile(pathForRaffleFile);
                toyService.printRaffleToy(toysForRaffle);
            }
        } while (!answer.equals("4"));
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
