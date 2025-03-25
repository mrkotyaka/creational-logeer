import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("Запускаем программу");
//        logger.log("Приветствуем пользователя");
//        System.out.println("Доброго дня, пользователь логгера!");

        Scanner scanner = new Scanner(System.in);

        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: "); // 7
        int listSize = scanner.nextInt();

        System.out.print("Введите верхнюю границу для значений: "); // 10
        int upBound = scanner.nextInt();

        logger.log("Создаём и наполняем список");

        Random random = new Random();
        StringBuilder sbString1 = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(upBound));
            sbString1.append(list.get(i)).append(" ");
        }
        System.out.println("Вот случайный список: " + sbString1); // 3 5 5 1 0 3 6

        logger.log("Просим пользователя ввести входные данные для фильтрации");

        System.out.print("Введите порог для фильтра: "); // 4
        int treshold = scanner.nextInt();
        Filter filter = new Filter(treshold);

        logger.log("Запускаем фильтрацию");

        List<Integer> filteredList = filter.filterOut(list);

        StringBuilder sbString2 = new StringBuilder();
        for (Integer integer : filteredList) {
            sbString2.append(integer).append(" ");
        }

        logger.log("Отфильтрованный список: " + sbString2); // 5 5 6
        logger.log("Завершаем программу");


    }

}


/*
[31.12.2019 15:38:22 1] Запускаем программу
[31.12.2019 15:38:22 2] Просим пользователя ввести входные данные для списка
Введите размер списка: 7
Введите верхнюю границу для значений: 10
[31.12.2019 15:38:23 3] Создаём и наполняем список
Вот случайный список: 3 5 5 1 0 3 6
[31.12.2019 15:38:23 4] Просим пользователя ввести входные данные для фильтрации
Введите порог для фильтра: 4
[31.12.2019 15:38:23 5] Запускаем фильтрацию
[31.12.2019 15:38:23 6] Элемент "3" не проходит
[31.12.2019 15:38:23 7] Элемент "5" проходит
[31.12.2019 15:38:23 8] Элемент "5" проходит
[31.12.2019 15:38:23 9] Элемент "1" не проходит
[31.12.2019 15:38:23 10] Элемент "0" не проходит
[31.12.2019 15:38:24 11] Элемент "3" не проходит
[31.12.2019 15:38:24 12] Элемент "6" проходит
[31.12.2019 15:38:24 13] Прошло фильтр 3 элемента из 7
[31.12.2019 15:38:24 14] Выводим результат на экран
Отфильтрованный список: 5 5 6
[31.12.2019 15:38:24 15] Завершаем программу
 */