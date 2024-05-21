package Train;

public class Chair { ;
    private int chairNumber;
    private boolean nearWindow;
    private boolean reserved;

    public Chair(int chairNumber) {
        this.chairNumber = chairNumber;
        if (chairNumber % 2 == 0){
            nearWindow = false;
        } else {
            nearWindow = true;
        }
        reserved = false;
    }

    public int getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(int chairNumber) {
        this.chairNumber = chairNumber;
    }

    public boolean isNearWindow() {
        return nearWindow;
    }

    public void setNearWindow(boolean nearWindow) {
        this.nearWindow = nearWindow;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "Židle: " +
                "číslo " + String.format("%02d", chairNumber) +
                "\t\t u okna? " + nearWindow +
                "\t reservovaná? " + reserved +
                '\n';
    }
}
