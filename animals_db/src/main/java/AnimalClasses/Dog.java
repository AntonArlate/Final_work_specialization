package AnimalClasses;

import java.util.Date;

public class Dog extends Pet{

    public Dog(String owner_name, String breed, String name, Date brithDate) {
        super(owner_name, breed, name, brithDate);
        this.kind = "dog";
    }
}
