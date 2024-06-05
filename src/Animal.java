import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Базовый класс Животные
abstract class Animal {
    protected String name;
    protected Date birthDate;
    protected List<String> commands;
    private static int animalCount = 0;

    /**
     * Конструктор для создания нового животного.
     *
     * @param name      Имя животного.
     * @param birthDate Дата рождения животного.
     */
    public Animal(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
        animalCount++;
    }

    /**
     * Получает имя животного.
     *
     * @return Имя животного.
     */
    public String getName() {
        return name;
    }

    /**
     * Получает дату рождения животного.
     *
     * @return Дата рождения животного.
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Получает список команд, которые знает животное.
     *
     * @return Список команд животного.
     */
    public List<String> getCommands() {
        return commands;
    }

    /**
     * Добавляет команду в список команд, которые знает животное.
     *
     * @param command Команда для добавления.
     */
    public void addCommand(String command) {
        commands.add(command);
    }

    /**
     * Получает количество созданных объектов животных.
     *
     * @return Количество животных.
     */
    public static int getAnimalCount() {
        return animalCount;
    }
}


