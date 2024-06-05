import java.util.Date;

abstract public class Pet extends Animal {
    public Pet(String name, Date birthDate) {
        super(name, birthDate);
    }
}

class Dog extends Pet {
    public Dog(String name, Date birthDate) {
        super(name, birthDate);
    }
}

class Cat extends Pet {
    public Cat(String name, Date birthDate) {
        super(name, birthDate);
    }
}

class Hamster extends Pet {
    public Hamster(String name, Date birthDate) {
        super(name, birthDate);
    }
}

