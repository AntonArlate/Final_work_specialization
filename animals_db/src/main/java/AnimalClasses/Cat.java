package AnimalClasses;

import java.time.LocalDate;

public class Cat extends Pet{

    public Cat(String owner_name, String breed, String name, LocalDate brithDate, int id) {
        super(owner_name, breed, name, brithDate, id);
        this.kind = "cat";
    }
}
