package AnimalClasses;

import java.util.Date;

public class Asse extends PackAnimal{

    public Asse(String owner_name, String breed, String name, Date brithDate) {
        super(owner_name, breed, name, brithDate);
        this.kind = "asse";
    }
}
