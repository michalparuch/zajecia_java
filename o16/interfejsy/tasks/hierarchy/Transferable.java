package basics.o16.interfejsy.tasks.hierarchy;

public interface Transferable extends Depositable, Withdrawable {
    void transfer(Double amount, Depositable account);

}
