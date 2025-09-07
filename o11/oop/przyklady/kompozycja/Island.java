package basics.o11.oop.przyklady.kompozycja;

public class Island {
    private String name;
    private String area;
    private Pool pool;

    public Island(String name, Pool pool, String area) {
        this.name = name;
        this.pool = pool;
        this.area = area;

        pool.addPoolToIsland(this);
    }

    @Override
    public String toString() {
        return "Island{" +
                "name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", pool=" + pool +
                '}';
    }
}
