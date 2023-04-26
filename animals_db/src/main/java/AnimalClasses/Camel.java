package AnimalClasses;

import java.util.Date;

public class Camel extends PackAnimal{

    public Camel(String owner_name, String breed, String name, Date brithDate) {
        super(owner_name, breed, name, brithDate);
        this.kind = "camel";
    }
}
