package Train;

public class Locomotive {
    private static int nextId = 1;
    private int id;
    private Person driver;
    private Engine engineType;

    public Locomotive(Person driver, Engine engineType) {
        this.id = nextId++;
        this.engineType = engineType;
        try {
            if (!driver.getJob().equals(Person.Job.ENGINE_DRIVER)) {
                throw new IllegalArgumentException("Pouze strojvůdcům je povoleno řídit lokomotivy.");
            }
            this.driver = driver;
        } catch (IllegalArgumentException e) {
            System.out.println("Chyba: " + e.getMessage());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getDriver() {
        return driver;
    }
    public Engine getEngineType() {
        return engineType;
    }
    public void setDriver(Person driver) {
        if (driver.getJob().equals(Person.Job.ENGINE_DRIVER)) {
            this.driver = driver;
        } else {
            System.out.println("Pouze strojvůdcům je povoleno řídit vlak.");
        }
    }
    public void setEngineType(Engine engineType) {
        this.engineType = engineType;
    }

    @Override
    public String toString() {
        return "Lokomotiva id " + id +
                "\n"  + driver +
                "\n" + engineType ;
    }
}
