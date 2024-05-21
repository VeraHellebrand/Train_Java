package Train;

public class BusinessWagon extends PersonalWagon {
    private Person steward;

    public BusinessWagon(int numberOfChair, Person steward) {
        super(numberOfChair);
        try {
            if (!steward.getJob().equals(Person.Job.STEWARD)) {
                throw new IllegalArgumentException("Osoba není stevard.");
            }
            this.steward = steward;
        } catch (IllegalArgumentException e) {
            System.out.println("Chyba: " + e.getMessage());
        }
    }

    public Person getSteward() {
        return steward;
    }

    public void setSteward(Person steward) {
        if (steward.getJob().equals(Person.Job.STEWARD)) {
            this.steward = steward;
        } else {
            System.out.println("Osoba není stevard.");
        }
    }

    @Override
    public String toString() {
        return "Business vagón: " +
                steward +
                "\n" + super.toString();

    }
}
