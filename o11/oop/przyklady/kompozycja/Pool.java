package basics.o11.oop.przyklady.kompozycja;

import java.util.ArrayList;
import java.util.List;

public class Pool {
    private String name;
    private String area;
    private List<Island> listOfIsland = new ArrayList<>();

    public Pool(String area, String name) {
        this.area = area;
        this.name = name;
    }

    public void addPoolToIsland(Island island){
        listOfIsland.add(island);
    }

    @Override
    public String toString() {
        return "Pool{" +
                "name='" + name + '\'' +
                ", area='" + area + '\'' +
                +
                '}';
    }

    public List<Island> getListOfIsland() {
        return listOfIsland;
    }
}
