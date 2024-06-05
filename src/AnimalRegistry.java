import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Класс для ведения реестра животных, реализующий интерфейс AnimalRegistryInterface.
 */

public class AnimalRegistry implements AnimalRegistryInterface{
    private static List<Animal> animalRegistry = new ArrayList<>();

    @Override
    public void addNewAnimal(Scanner scanner) {
        System.out.println("Выберите тип животного:");
        System.out.println("1. Собака");
        System.out.println("2. Кошка");
        System.out.println("3. Хомяк");
        System.out.println("4. Лошадь");
        System.out.println("5. Верблюд");
        System.out.println("6. Осел");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (dd-MM-yyyy): ");
        String birthDateStr = scanner.nextLine();
        Date birthDate;
        try {
            birthDate = new SimpleDateFormat("dd-MM-yyyy").parse(birthDateStr);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты.");
            return;
        }

        Animal animal;
        switch (choice) {
            case 1:
                animal = new Dog(name, birthDate);
                break;
            case 2:
                animal = new Cat(name, birthDate);
                break;
            case 3:
                animal = new Hamster(name, birthDate);
                break;
            case 4:
                animal = new Horse(name, birthDate);
                break;
            case 5:
                animal = new Camel(name, birthDate);
                break;
            case 6:
                animal = new Donkey(name, birthDate);
                break;
            default:
                System.out.println("Неверный выбор.");
                return;
        }
        animalRegistry.add(animal);
        System.out.println("Животное добавлено в реестр.");
    }

    @Override
    public void showAnimalCommands(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        Animal animal = findAnimalByName(name);
        if (animal != null) {
            System.out.println("Команды, которые может выполнять " + animal.getName() + ":");
            for (String command : animal.getCommands()) {
                System.out.println("- " + command);
            }
        } else {
            System.out.println("Животное не найдено.");
        }
    }

    @Override
    public void trainNewCommand(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        Animal animal = findAnimalByName(name);
        if (animal != null) {
            System.out.print("Введите новую команду для " + animal.getName() + ": ");
            String command = scanner.nextLine();
            animal.addCommand(command);
            System.out.println("Команда добавлена.");
        } else {
            System.out.println("Животное не найдено.");
        }
    }

    @Override
    public void listAnimalsByBirthDate() {
        Collections.sort(animalRegistry, new Comparator<Animal>() {
            @Override
            public int compare(Animal a1, Animal a2) {
                return a1.getBirthDate().compareTo(a2.getBirthDate());
            }
        });

        System.out.println("Список животных по дате рождения:");
        for (Animal animal : animalRegistry) {
            System.out.println(animal.getName() + " - " + new SimpleDateFormat("dd-MM-yyyy").format(animal.getBirthDate()));
        }
    }

    @Override
    public void showAnimalCount() {
        System.out.println("Общее количество животных: " + Animal.getAnimalCount());
    }

    /**
     * Ищет животное в реестре по имени.
     *
     * @param name Имя животного для поиска.
     * @return Найденное животное или null, если животное не найдено.
     */
    private static Animal findAnimalByName(String name) {
        for (Animal animal : animalRegistry) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }
}

