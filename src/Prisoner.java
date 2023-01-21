/** Prisoner.java
 * Stefan Perkovic January, 20 2023
 * A sublass of Person that represents a Prisoner and their common attributes
 */
public class Prisoner extends Person{

    private String crime;

    public Prisoner(String firstName, String lastName, String phoneNumber, String crime) {
        super(firstName, lastName, phoneNumber);
        this.crime = crime;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    @Override
    public String toString() {
        return super.toString() + " Crime: " + crime;
    }
}
