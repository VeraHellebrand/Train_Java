package Train;

import java.sql.Array;
import java.util.ArrayList;

public class NightWagon extends PersonalWagon {
    private Bed[] beds;
    private int numberOfBeds;

    public NightWagon(int numberOfChair, int numberOfBeds) {
        super(numberOfChair);
        this.numberOfBeds = numberOfBeds;
        beds = new Bed[numberOfBeds];
        for (int i = 0; i < numberOfBeds; i++) {
            beds[i] = new Bed(i+1);
        }
    }

    public Bed[] getBeds() {
        return beds;
    }

    public void setBeds(Bed[] beds) {
        this.beds = beds;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nSeznam postelí:\n");
        for (Bed bed : beds) {
            sb.append(bed.toString());
        }
        return "Spací vagón: " + sb +
                super.toString();
    }
}
