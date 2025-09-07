package basics.o16.interfejsy.tasks.pc;

public class Hdd implements HardDrive{
    @Override
    public void readData() {
        System.out.println("Read data from HDD drive");
    }
}
