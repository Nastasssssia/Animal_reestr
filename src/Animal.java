import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Базовый класс Животные
abstract class Animal {
    protected String name;
    protected Date birthDate;
    protected List<String> commands;
    private static int animalCount = 0;

    public Animal(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
        animalCount++;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}


