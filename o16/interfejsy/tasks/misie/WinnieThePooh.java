package basics.o16.interfejsy.tasks.misie;

public class WinnieThePooh implements FatBear{

    private String name;

    public WinnieThePooh(String name) {
        this.name = name;
    }

    @Override
    public void sayHi() {
        System.out.println(name + " say's hi!");
    }

    @Override
    public void eatHoney() {
        System.out.println(name + " eats honey!");
    }

    @Override
    public void eatMore() {
        System.out.println("Give more food!");
    }
}
