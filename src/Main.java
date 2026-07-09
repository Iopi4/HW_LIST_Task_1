import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> todoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить дело");
            System.out.println("2. Показать дела");
            System.out.println("3. Удалить дело по номеру");
            System.out.println("4. Удалить дело по названию");
            System.out.print("Ваш выбор: ");

            String input = scanner.nextLine();
            int operation  = Integer.parseInt(input);


            if (operation == 0){
                break;
            }

            switch (operation){
                case 1:
                    System.out.println();
                    System.out.print("Введите название задачи: ");
                    String task = scanner.nextLine();
                    todoList.add(task);
                    System.out.println("Добавлено!");
                    todoListsPrint(todoList);

                    break;
                case 2:
                    todoListsPrint(todoList);
                    break;

                case 3:
                    System.out.println();
                    System.out.print("Введите номер для удаления: ");
                    String number = scanner.nextLine();
                    int delete  = Integer.parseInt(number);
                    todoList.remove(delete - 1);
                    System.out.println("Удалено!");
                    todoListsPrint(todoList);
                    break;

                case 4:
                    System.out.println();
                    System.out.print("Введите название задачи для удаления: ");
                    String name = scanner.nextLine();
                    todoList.remove(name);
                    System.out.println("Удалено!");
                    todoListsPrint(todoList);
                    break;

                default:
                    System.out.println("Такой операции нет");
            }

        }
        System.out.println();
    }

    //Создадим отдельный метод для вызова списка дел через цикл for each
    public static void todoListsPrint(ArrayList<String> arrayList){
        System.out.println("Ваш список дел:");
        for (String s: arrayList){
            System.out.println(arrayList.indexOf(s) + 1 + ". " + s);
        }
        System.out.println();
    }
}