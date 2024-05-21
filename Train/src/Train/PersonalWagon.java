package Train;

import java.util.ArrayList;
import java.util.List;

public abstract class PersonalWagon implements Wagon{
    private List<Chair> sits;
    private int numberOfChairs;

    public PersonalWagon(int numberOfChair) {
        this.numberOfChairs = numberOfChair;
        sits = new ArrayList<>();
        for (int i = 0; i < numberOfChair; i++) {
           sits.add(new Chair(i + 1));
        }
    }

    public List<Chair> getSits() {
        return sits;
    }

    public void setSits(List<Chair> sits) {
        this.sits = sits;
    }

    public int getNumberOfChairs() {
        return numberOfChairs;
    }

    public void setNumberOfChairs(int numberOfChairs) {
        this.numberOfChairs = numberOfChairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Seznam židlí:\n");
        for (Chair chair : sits) {
            sb.append(chair.toString());
        }
        return  "počet židlí " + numberOfChairs +
                "\n" + sb;

    }

    @Override
    public void connectWagon(Train train) {
        train.connectWagon(this);
    }

    @Override
    public void disconnectWagon(Train train) {
        train.disconnectWagon(this);
    }
}
