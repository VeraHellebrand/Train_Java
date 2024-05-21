package Train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Jana", "Nováková", 1985, 12, 1, Person.Job.STEWARD);
        Person person2 = new Person("Jan", "Dlouhý", 1985, 2, 26, Person.Job.ENGINE_DRIVER);
        System.out.println(person1);
        System.out.println(person2);
        Engine engine1 = new Engine(Engine.TypeEngine.DIESEL);
        System.out.println();

        // LOKOMOTIVY
        Locomotive locomotive1 = new Locomotive(person1, new Engine(Engine.TypeEngine.STEAM));
        System.out.println("Není strojvůdce: " + locomotive1);
        locomotive1.setDriver(person2);
        System.out.println("Je strojvůdce: " + locomotive1);

        Locomotive locomotive2 = new Locomotive(new Person("Jakub", "Krátký", 1972, 8, 12, Person.Job.ENGINE_DRIVER), engine1);
        System.out.println(locomotive2);
        Locomotive locomotive3 = new Locomotive(person2, new Engine(Engine.TypeEngine.ELECTRIC));

        System.out.println();
        // VAGONY
        EconomyWagon e1 = new EconomyWagon(20);
        BusinessWagon b1 = new BusinessWagon(10, person2);
        b1.setSteward(person1);
        NightWagon n1 = new NightWagon(8, 8);
        Hooper h1 = new Hooper(500);
        Hooper h2 = new Hooper(750);
        Hooper h3 = new Hooper(600);
        Hooper h4 = new Hooper(450);
        Hooper h5 = new Hooper(650);
        Hooper h6 = new Hooper(1000);

        // VLAK PRIPOJENI A ODPOJENI VAGONU
        System.out.println("PARNI");
        List<Wagon> list1 = new ArrayList<>(Arrays.asList(e1, b1, n1, h1, h2, h3));
        Train trainSteam = new Train(locomotive1, list1);
        h3.connectWagon(trainSteam);
        h1.disconnectWagon(trainSteam);
        h4.connectWagon(trainSteam);
        System.out.println(trainSteam);
        System.out.println();
        System.out.println("DIESEL");
        Train trainDiesel = new Train(locomotive2, new ArrayList<>(Arrays.asList(h1, h2, h3, h4, h5, h6)));
        System.out.println(trainDiesel);

        // TESTOVÁNÍ REZERVACE
        System.out.println();
        System.out.println("Rezervace sedadel ve vlaku s parní lokomotivou:");
        trainSteam.reserveChair(0, 0);
        trainSteam.reserveChair(0, 1);
        trainSteam.reserveChair(0, 21);
        trainSteam.reserveChair(0, 2);
        trainSteam.reserveChair(1, 8);
        trainSteam.reserveChair(1, 11);
        trainSteam.reserveChair(0, 1);
        trainSteam.reserveChair(4, 2);

        System.out.println();
        trainSteam.listReservedChairs();
        System.out.println();
        System.out.println("Seznam rezervovaných sedadel ve vlaku:");
        trainSteam.printTrainInfo();
    }
}
