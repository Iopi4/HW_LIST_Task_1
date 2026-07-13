/**
 * В задании 1 (обязательное) введено улучшение для безопасности ввода данных.
 * Добавлены отработка некорректного ввода данных пользователем.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Заменен тип переменной на List (было ArrayList)
        List<String> todoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить дело");
            System.out.println("2. Показать дела");
            System.out.println("3. Удалить дело по номеру");
            System.out.println("4. Удалить дело по названию");

            boolean correctInput = false; //переменная для определения корректности ввода
            int operation = -1;

            //Добавим отдельный цикл для проверки корректности ввода
            while (!correctInput){
                System.out.print("Ваш выбор: ");
                String input = scanner.nextLine();
                try {
                    operation = Integer.parseInt(input);
                    correctInput = true;
                } catch (NumberFormatException e){
                    System.out.println("Ошибка. Введите корректный номер операции");
                }
            }

            if (operation == 0) {
                break;
            }

            switch (operation){
                case 1:
                    System.out.println();
                    System.out.print("Введите название задачи: ");
                    String task = scanner.nextLine();
                    //проверим на совпадение дела
                    if (todoList.contains(task)){
                        System.out.println("Уже существует!");
                    } else {
                        todoList.add(task);
                        System.out.println("Добавлено!");
                    }
                    todoListsPrint(todoList);
                    break;

                case 2:
                    todoListsPrint(todoList);
                    break;

                case 3:
                    System.out.println();
                    System.out.print("Введите номер для удаления: ");
                    String number = scanner.nextLine();
                    int delete = -1; //переменная для присвоения номера дела
                    //проверим на совпадение номера дела
                    try {
                        delete  = Integer.parseInt(number);
                        if (delete < 1 || delete > todoList.size()){
                            System.out.println("Ошибка. Такого номера нет");
                        } else {
                            todoList.remove(delete - 1);
                            System.out.println("Удалено!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка. Надо ввести число");
                    };

                    todoListsPrint(todoList);
                    break;

                case 4:
                    System.out.println();
                    System.out.print("Введите название задачи для удаления: ");
                    String name = scanner.nextLine();
                    //Создадим переменную booleen для отслеживания удалено дело или нет
                    boolean removed =  todoList.remove(name);
                    if (removed){
                        System.out.println("Удалено!");
                    } else {
                        System.out.println("Ошибка. Такой задачи нет");
                    }
                    todoListsPrint(todoList);
                    break;

                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println();
    }

    //Создадим отдельный метод для вызова списка дел через цикл for each
    public static void todoListsPrint(List<String> arrayList){
        System.out.println("Ваш список дел:");
        //Имя переменной заменено на listsPrint (было s),
        for (String listsPrint: arrayList){
            System.out.println(arrayList.indexOf(listsPrint) + 1 + ". " + listsPrint);
        }
        System.out.println();
    }
}