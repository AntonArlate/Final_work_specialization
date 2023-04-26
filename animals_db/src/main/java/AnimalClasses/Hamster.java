package AnimalClasses;

import java.util.Date;

public class Hamster extends Pet{

    public Hamster(String owner_name, String breed, String name, Date brithDate, int id) {
        super(owner_name, breed, name, brithDate, id);
        this.kind = "hamster";
    }
}
