package AnimalClasses;

import java.util.Date;

public class Hamster extends Pet{

    public Hamster(String owner_name, String breed, String name, Date brithDate) {
        super(owner_name, breed, name, brithDate);
        this.kind = "hamster";
    }
}
