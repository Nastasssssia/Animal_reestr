//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AnimalRegistry registry = new AnimalRegistry();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Список команд животного");
            System.out.println("3. Обучение новым командам");
            System.out.println("4. Вывести список животных по дате рождения");
            System.out.println("5. Показать общее количество животных");
            System.out.println("6. Выход");
            System.out.print("Выберите пункт меню: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    registry.addNewAnimal(scanner);
                    break;
                case 2:
                    registry.showAnimalCommands(scanner);
                    break;
                case 3:
                    registry.trainNewCommand(scanner);
                    break;
                case 4:
                    registry.listAnimalsByBirthDate();
                    break;
                case 5:
                    registry.showAnimalCount();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
        scanner.close();
    }
}