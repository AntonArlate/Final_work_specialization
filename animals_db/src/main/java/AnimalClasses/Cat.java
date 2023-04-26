package AnimalClasses;

import java.util.Date;

public class Cat extends Pet{

    public Cat(String owner_name, String breed, String name, Date brithDate) {
        super(owner_name, breed, name, brithDate);
        this.kind = "cat";
    }
}
