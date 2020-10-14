import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * Created by Jacaranda Perez
 * Date: 2020-10-09
 * Project: GymProgram
 */

public class Client {
    private String name;
    private String personnumber;
    private LocalDate membership;

    public Client(String personnumber, String name, LocalDate membership){
        this.name = name;
        this.personnumber = personnumber;
        this.membership = membership;
    }

    public String getName(){
        return name;
    }

    public String getPersonnumber(){
        return personnumber;
    }

    public LocalDate getMembership(){
        return membership;
    }

    public boolean hasValidMembership(LocalDate date){
        LocalDate actualDate = LocalDate.now();
        long daysSinceMembership= ChronoUnit.DAYS.between(membership, actualDate);
        if(daysSinceMembership <= 365){
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(personnumber, client.personnumber) &&
                Objects.equals(membership, client.membership);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, personnumber, membership);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", personnumber='" + personnumber + '\'' +
                ", membership='" + membership + '\'' +
                '}';
    }
}
