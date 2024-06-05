import java.util.Scanner;

public interface AnimalRegistryInterface {
    void addNewAnimal(Scanner scanner);
    void showAnimalCommands(Scanner scanner);
    void trainNewCommand(Scanner scanner);
    void listAnimalsByBirthDate();
    void showAnimalCount();
}
