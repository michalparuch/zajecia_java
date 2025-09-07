package basics.o16.interfejsy.tasks.misie;

public class Main {
    public static void main(String[] args) {

        //Stwórz hierarchie dziedziczenia interfejsów. Interfejs Mis i Zjadacz Miodku niech maja jakieś metody, moze pole.
        //Interfejs GrubyMis dziedziczy po tych dwóch
        //interfejsach, a klasa KubusPuchatek implementuje interfejs GrubyMisio :) przetestujemy działanie metod w mainie

        // stworz kilka instancji obiektow Misia przypisujac ja do obiektow tworzonych z roznych implementowanych interfejsow, po czym sprobuj wywolac z nich dostepne metody

        // np GrubyMisio gruby = new Misio();

        WinnieThePooh winnieThePooh = new WinnieThePooh("Kubus Puchatek");

        winnieThePooh.eatHoney();
        winnieThePooh.sayHi();
        winnieThePooh.eatMore();
        winnieThePooh.roar();

        Bear bear = winnieThePooh;
        bear.sayHi();
        bear.roar();

        FatBear fatBear = winnieThePooh;
        fatBear.eatMore();
        fatBear.roar();
        fatBear.sayHi();
        fatBear.eatHoney();

        HoneyEater honeyEater = winnieThePooh;
        honeyEater.eatHoney();
    }
}
