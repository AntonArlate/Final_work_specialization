package AnimalClasses;

import java.time.LocalDate;

public class PackAnimal extends Animal{

    public PackAnimal(String owner_name, String breed, String name, LocalDate brithDate, int id) {
        super(owner_name, breed, name, brithDate, id);
        this.typeAnimal = "pack animal";
    }
}
