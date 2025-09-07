package basics.o16.interfejsy.tasks.oven;

public class Oven implements Bake{

    private String time;
    private int temperature;

    @Override
    public void bakeCake(String time, Integer temperature) {
        this.time = time;
        this.temperature = temperature;
        startBaking("Cake");
    }

    @Override
    public void bakeBread(String time, Integer temperature) {
        this.time = time;
        this.temperature = temperature;
        startBaking("Bread");
    }

    @Override
    public void bakeChicken(String time, Integer temperature) {
        this.time = time;
        this.temperature = temperature;
        startBaking("Chicken");
    }

    @Override
    public void bakeBeef(String time, Integer temperature) {
        this.time = time;
        this.temperature = temperature;
        startBaking("Beef");
    }

    public void startBaking(String text){
        System.out.println("Pieczesz " + text + " przez " + time + " min" + " w " + temperature + " stopniach");
    }
}
