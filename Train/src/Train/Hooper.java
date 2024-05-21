package Train;

public class Hooper implements Wagon{
    private double loadingCapacity;

    public Hooper(double loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }

    public double getLoadingCapacity() {
        return loadingCapacity;
    }

    public void setLoadingCapacity(double loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }

    @Override
    public String toString() {
        return "Hooper: " +
                "kapacita = " + loadingCapacity +
                " tun";
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
