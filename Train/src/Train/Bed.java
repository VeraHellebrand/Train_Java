package Train;

public class Bed { ;
    private int number;
    private boolean reserved;

    public Bed(int number) {
        this.number = number;
        reserved = false;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
    @Override
    public String toString() {
        return "Postel: " +
                "číslo " + String.format("%02d", number) +
                "\t reservovaná? " + reserved +
                '\n';
    }
}
