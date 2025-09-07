package basics.o11.oop.przyklady.asocjacja.z.atrybutem;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private String name;
    private List<CarRepair> repairs = new ArrayList<>();

    public Garage(String name) {
        this.name = name;
    }

    public void addRepair(CarRepair carRepair){
        if (!repairs.contains(carRepair)){
            repairs.add(carRepair);
        }
    }

    public void showRepairs(){
        for (CarRepair repair: repairs) {
            System.out.println(repair);
        }
    }

    public String getName() {
        return name;
    }

    public List<CarRepair> getRepairs() {
        return repairs;
    }

}
