package basics.o11.oop.przyklady.dziedziczenie.wieloaspektowe;

public class Lorry extends Vehicle{

    private int capacity;

    public Lorry(String model, String brand, String typeOfDpf, int productionYear, int capacity) {
        super(model, brand, typeOfDpf, productionYear);
        this.capacity = capacity;
    }

    public Lorry(String model, String brand, int productionYear, int octaneNumber, int capacity) {
        super(model, brand, productionYear, octaneNumber);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        if (getTypeOfDpf() == null) {
            return "Lorry has petrol engine";
        } else {
            return "Lorry has diesel engine";
        }
    }

}
