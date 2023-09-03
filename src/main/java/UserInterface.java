import java.util.Arrays;
import java.util.List;

public class UserInterface {

    static UserInteraction userInteraction = new UserInteraction();

    /**
     * Статический метод основного меню программы.
     * Выводит основное меню программы, в виде сообщения для пользователя. На основании ответа от пользователя
     * запускает выполнение функционала программы.
     * @param pathForRaffleFile - строковое значение месторасположения файла, в который будет производиться запись
     * @param pathRaffleFile - строковое значение месторасположения файла, из которого будет производиться чтение
     * */
    private static void menuApp(String pathForRaffleFile, String pathRaffleFile) {
        ToyService toyService = new ToyService();
        String answer;
        String[] correctAnswer = {"1", "2", "3", "4", "да", "нет"};
        do {
            System.out.println("""
                    Здравствуйте, Вас приветствует программа для розыгрыша игрушек.
                    Данная программа имеет следующий функционал:
                    1. Добавление игрушки в меню розыгрыша;
                    2. Розыгрыш всех игрушек;
                    3. Розыгрыш одной игрушки.
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

    /**
     * Статический метод запуска программы.
     * Запрашивает у пользователя месторасположение необходимых файлов для чтения и записи информации.
     * */
    public static void runApp() {
        String[] correctAnswer = {"да", "нет"};
        String pathForRaffleFile;
        String pathRaffleFile;
        String answer = userInteraction.checkingUserAnswerFromEmpty("""
                Вы хотите использовать файлы для чтения и записи по-умолчанию? Да/Нет:""");
        if (!Arrays.asList(correctAnswer).contains(answer)){
            answer = userInteraction.checkingUserAnswerFromEmpty("Некорректный ввод. Введите Да или Нет");
        }
        if (answer.equalsIgnoreCase("да")){
            pathForRaffleFile = "inputToys.txt";
            pathRaffleFile = "resultRaffle.txt";
        } else {
            pathForRaffleFile = userInteraction.checkingUserAnswerFromEmpty(
                    "Введите имя файла для сохранения списка игрушек:");
            pathRaffleFile = userInteraction.checkingUserAnswerFromEmpty(
                    "Введите имя файла для сохранения результатов розыгрыша игрушек:");

        }
        menuApp(pathForRaffleFile, pathRaffleFile);
    }

}
