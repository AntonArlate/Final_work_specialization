package AnimalClasses;

import java.util.Date;

public class PackAnimal extends Animal{

    public PackAnimal(String owner_name, String breed, String name, Date brithDate, int id) {
        super(owner_name, breed, name, brithDate, id);
        this.typeAnimal = "pack animal";
    }
}
