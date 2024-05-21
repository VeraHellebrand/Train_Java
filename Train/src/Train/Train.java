package Train;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private Locomotive locomotive;
    private List<Wagon> wagons;
    private List<Integer> reservedChairs;

    public Train() {
        this.wagons = new ArrayList<>();
        this.reservedChairs = new ArrayList<>();
    }

    public Train(Locomotive locomotive) {
        this();
        this.locomotive = locomotive;
    }

    public Train(Locomotive locomotive, List<Wagon> wagons) {
        this(locomotive);
        setWagons(wagons);
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(List<Wagon> wagons) {
        for (Wagon wagon : wagons) {
            connectWagon(wagon);
        }
    }

    //PRIPOJENI VAGONU
    public void connectWagon(Wagon wagon) {
        Engine.TypeEngine eT = this.locomotive.getEngineType().getType();
        if (eT == Engine.TypeEngine.STEAM && this.wagons.size() >= 5) {
            System.out.println("Parní lokomotiva nemůže připojit více než 5 vagónů.");
        } else {
            this.wagons.add(wagon);
            System.out.println("Vagón připojen.");
        }
    }

    //ODPOJENI VAGONU
    public void disconnectWagon(Wagon wagon) {
        if (this.wagons.contains(wagon)) {
            this.wagons.remove(wagon);
            System.out.println("Vagón odpojen.");
        } else {
            System.out.println("Vagón není připojen k vlaku.");
        }
    }

    // REZERVACE
    public void reserveChair(int wagonNumber, int chairNumber) {
        // Zkontrolovat, zda existuje vagon s daným indexem
        if (wagonNumber >= 0 && wagonNumber < wagons.size()) {
            // Zkontrolovat, zda je vagon osobní
            Wagon wagon = wagons.get(wagonNumber);
            if (wagon instanceof PersonalWagon) {
                PersonalWagon personalWagon = (PersonalWagon) wagon;
                // Zkontrolovat, zda sedadlo existuje a není již rezervované
                if (chairNumber > 0 && chairNumber <= personalWagon.getNumberOfChairs()) {
                    Chair chair = personalWagon.getSits().get(chairNumber - 1);
                    if (!chair.isReserved()) {
                        chair.setReserved(true);
                        reservedChairs.add(chairNumber);
                        System.out.println("Sedadlo " + chairNumber + " ve vagonu č. " + wagonNumber + " bylo úspěšně rezervováno.");
                    } else {
                        System.out.println("Chyba: Sedadlo je již rezervované.");
                    }
                } else {
                    System.out.println("Chyba: Sedadlo neexistuje.");
                }
            } else {
                System.out.println("Chyba: Vagon není osobní, nelze rezervovat sedadlo.");
            }
        } else {
            System.out.println("Chyba: Vagon s daným indexem neexistuje.");
        }
    }

    //List rezervovných sedadel
    public void listReservedChairs() {
        System.out.println("Seznam rezervovaných sedadel:");
        for (int i = 0; i < reservedChairs.size(); i++) {
            int chairNumber = reservedChairs.get(i);
            // Najdi vagon, ve kterém je rezervované sedadlo
            int wagonIndex = findWagonIndexByChairNumber(chairNumber);
            // Pokud bylo nalezeno
            if (wagonIndex != -1) {
                System.out.println("Sedadlo č. " + chairNumber + " ve vagonu č. " + (wagonIndex + 1));
            }
        }
    }
    // Metoda pro nalezení indexu vagonu podle čísla sedadla
    private int findWagonIndexByChairNumber(int chairNumber) {
        for (int i = 0; i < wagons.size(); i++) {
            Wagon wagon = wagons.get(i);
            if (wagon instanceof PersonalWagon personalWagon) {
                if (personalWagon.getSits().stream().anyMatch(chair -> chair.getChairNumber() == chairNumber)) {
                    return i;
                }
            }
        }
        return -1; // Pokud není vagon se sedadlem číslo `chairNumber` nalezen
    }
    //Informace o vlaku, důležité pro reyervaci
    public void printTrainInfo() {
        int totalWagons = wagons.size();
        int totalChairs = 0;
        int reservedChairs = 0;

        System.out.println("Informace o vlaku:");
        System.out.println("Počet vagonů: " + totalWagons);
        for (Wagon wagon : wagons) {
            int wagonChairs = 0;
            int wagonReserved = 0;
            if (wagon instanceof PersonalWagon personalWagon) {
                wagonChairs = personalWagon.getNumberOfChairs();
                totalChairs += wagonChairs;

                for (Chair chair : personalWagon.getSits()) {
                    if (chair.isReserved()) {
                        reservedChairs++;
                        wagonReserved++;
                    }
                }
            }
            System.out.println("- Vagon č. " + (wagons.indexOf(wagon) + 1) + " má " + wagonChairs + " sedadel, z toho " + wagonReserved + " rezervovaných.");
        }
        int freeChairs = totalChairs - reservedChairs;
        System.out.println("Celkový počet sedadel ve vlaku: " + totalChairs);
        System.out.println("Celkový počet rezervovaných sedadel: " + reservedChairs);
        System.out.println("Celkový počet volných sedadel: " + freeChairs);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vagóny:\n");
        for (Wagon wagon : wagons) {
            sb.append(wagon).append("\n");
        }
        return "Vlak " +
                locomotive +
                sb;
    }
}
