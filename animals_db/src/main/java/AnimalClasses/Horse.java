package AnimalClasses;

import java.util.Date;

public class Horse extends PackAnimal{

    public Horse(String owner_name, String breed, String name, Date brithDate) {
        super(owner_name, breed, name, brithDate);
        this.kind = "horse";
    }
}