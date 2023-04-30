package AnimalClasses;

import java.time.LocalDate;

public class Hamster extends Pet{

    public Hamster(String owner_name, String breed, String name, LocalDate brithDate, int id) {
        super(owner_name, breed, name, brithDate, id);
        this.kind = "hamster";
    }
}
