package AnimalClasses;

import java.time.LocalDate;

public class Pet extends Animal{

    public Pet(String owner_name, String breed, String name, LocalDate brithDate, int id) {
        super(owner_name, breed, name, brithDate, id);
        this.typeAnimal = "pet";
    }
}
