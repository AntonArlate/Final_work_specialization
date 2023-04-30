package AnimalClasses;

import java.time.LocalDate;

public class Camel extends PackAnimal{

    public Camel(String owner_name, String breed, String name, LocalDate brithDate, int id) {
        super(owner_name, breed, name, brithDate, id);
        this.kind = "camel";
    }
}
