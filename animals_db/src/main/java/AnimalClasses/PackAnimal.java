package AnimalClasses;

import java.util.Date;

public class PackAnimal extends Animal{

    public PackAnimal(String owner_name, String breed, String name, Date brithDate) {
        super(owner_name, breed, name, brithDate);
        this.typeAnimal = "pack animal";
    }
}
