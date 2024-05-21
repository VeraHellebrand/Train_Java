package Train;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private static int nextId = 1;
    private final int id;
    private String firstName;
    private String lastName;
    private final LocalDate dateOfBirth;
    private Job job;

    public enum Job {
        STEWARD("Stevard"),
        ENGINE_DRIVER("Strojvedoucí");

        private final String displayName;

        Job(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public Person(String firstName, String lastName, int year, int month, int day, Job job) {
        this.id = nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = LocalDate.of(year, month, day);
        this.job = job;
    }

    // Metody pro získání údajů o osobě
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Job getJob() {
        return job;
    }


    // Metoda pro výpočet věku z datumu narození
    public int calculateAge() {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - dateOfBirth.getYear();

        if (today.getMonthValue() < dateOfBirth.getMonthValue() ||
                (today.getMonthValue() == dateOfBirth.getMonthValue() && today.getDayOfMonth() < dateOfBirth.getDayOfMonth())) {
            age--;
        }
        return age;
    }

    // Přepsaná metoda toString pro výpis informací o osobě
    @Override
    public String toString() {
        return  (job==null? "" : job.displayName)+
                " ID = " + id +
                ", jméno = " + firstName +
                ", příjmení = " + lastName +
                ", věk = " + calculateAge() +
                ", zaměstnání = " + (job==null? "nevyplněno" : job.displayName);
    }
}
