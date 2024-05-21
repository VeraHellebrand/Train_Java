package Train;

public class EconomyWagon extends PersonalWagon{
    public EconomyWagon(int numberOfChair) {
        super(numberOfChair);
    }

    @Override
    public String toString() {
        return "Economy vagón\n " + super.toString();
    }
}
