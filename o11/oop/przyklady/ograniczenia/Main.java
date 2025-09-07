package basics.o11.oop.przyklady.ograniczenia;

public class Main {
    public static void main(String[] args) {

        // klasa Doctor, name, lastName, salary, pesel
        // pesel ma byc unikalny, pensja max 20k, walidacje np przez ekstensje

        // PrivateContract, pole name, lista Doctorow, mozna dodac Doctora jesli nie ma on juz jakiegos kontraktu
        // PublicContract, pole int id, lista doctorow, tez walidacja ze mozna tu dodac doctora tylko jesli nie ma on juz jakiegos kontraktu


        Doctor doctor1 = new Doctor(123, 100, "T", "T");
        Doctor doctor2 = new Doctor(1233, 3000, "T", "T");

        PrivateContract privateContract = new PrivateContract("Test1");
        PublicContract publicContract = new PublicContract("Test1");

        privateContract.addDoctor(doctor1);
//        publicContract.addDoctor(doctor1);

    }
}
