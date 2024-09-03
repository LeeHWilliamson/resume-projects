import java.time.LocalDate;
import java.time.LocalTime;

public class Patient {
    // Immutable fields
    private final String name;
    private final LocalDate DOB;
    // Mutable fields
    private Severity severity;
    private LocalTime arrivalTime;

    // constructor will set immutable fields (name and DOB)
    public Patient(String name, LocalDate DOB) {
        this.name = name;
        this.DOB = DOB;
    }

    // Name should never be changed after object is instantiated
    // So we should not include a set function, only a get function
    public String getName() {
        return name;
    }

    // same goes for date of birth
    public LocalDate getDOB() {
        return DOB;
    }

    // This field is set at check in, thus we
    // should include a method to set it
    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Severity getSeverity() {
        return severity;
    }

    // This field is set at check in, thus we
    // should include a method to set it
    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    // toString method
    public String toString() {
        return "Patient name: " + name + "\nDOB: " + DOB + "\nSeverity: " + severity + "\nArrival time: "
                + arrivalTime + " ";
    }
}
