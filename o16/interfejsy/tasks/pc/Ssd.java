package basics.o16.interfejsy.tasks.pc;

public class Ssd implements HardDrive{
    @Override
    public void readData() {
        System.out.println("Read data from SSD drive");
    }
}
