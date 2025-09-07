package basics.o15.enumy.metodyabstr;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("Toyota", CarEnum.ACCELERATE_QUICKLY);

        System.out.println(car1 + " " + car1.getCarEnum().accelerate());
        car1.setCarEnum(CarEnum.ACCELERATE_SLOWLY);
        System.out.println(car1 + " " + car1.getCarEnum().accelerate());
    }
}
