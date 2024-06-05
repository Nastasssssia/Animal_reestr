import java.util.Date;

/**
 * Абстрактный класс для вьючных животных, наследующий класс Animal.
 */
abstract public class PackAnimal extends Animal{
    public PackAnimal(String name, Date birthDate) {
        super(name, birthDate);
    }
}

class Horse extends PackAnimal {
    public Horse(String name, Date birthDate) {
        super(name, birthDate);
    }
}

class Camel extends PackAnimal {
    public Camel(String name, Date birthDate) {
        super(name, birthDate);
    }
}

class Donkey extends PackAnimal {
    public Donkey(String name, Date birthDate) {
        super(name, birthDate);
    }
}
