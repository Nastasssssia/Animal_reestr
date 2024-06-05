import java.util.Scanner;

/**
 * Интерфейс для реестра животных, определяющий методы для управления и
 * отображения информации о животных.
 */
public interface AnimalRegistryInterface {
    /**
     * Добавляет новое животное в реестр.
     *
     * @param scanner Объект Scanner для ввода данных.
     */
    void addNewAnimal(Scanner scanner);

    /**
     * Отображает команды, которые знает конкретное животное.
     */
    void showAnimalCommands(Scanner scanner);

    /**
     * Обучает новое животное новой команде.
     */
    void trainNewCommand(Scanner scanner);

    /**
     * Отображает список всех животных, отсортированных по дате рождения.
     */
    void listAnimalsByBirthDate();

    /**
     * Отображает количество животных в реестре.
     */
    void showAnimalCount();
}
