package AnimalClasses;

import java.time.LocalDate;

public class Asse extends PackAnimal{

    public Asse(String owner_name, String breed, String name, LocalDate brithDate, int id) {
        super(owner_name, breed, name, brithDate, id);
        this.kind = "asse";
    }
}
