package AnimalClasses;

import java.time.LocalDate;

public class Dog extends Pet{

    public Dog(String owner_name, String breed, String name, LocalDate brithDate, int id) {
        super(owner_name, breed, name, brithDate, id);
        this.kind = "dog";
    }
}
