package AnimalClasses;

import java.util.Date;

public class Pet extends Animal{

    public Pet(String owner_name, String breed, String name, Date brithDate) {
        super(owner_name, breed, name, brithDate);
        this.typeAnimal = "pet";
    }
}