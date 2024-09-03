import java.util.Comparator;
import java.time.LocalTime;

public class EmergencyRoom {
    private final Heap<Patient> patientHeap;

    // patients will be stored in heap, create instance of heap
    // on construction
    public EmergencyRoom(Comparator<Patient> patientCompare) {
        patientHeap = new Heap<Patient>(patientCompare);
    }

    // Set patient fields and add to heap
    public void checkIn(Patient patient, Severity severity) {
        patient.setArrivalTime(LocalTime.now());
        patient.setSeverity(severity);
        patientHeap.add(patient);
    }

    // Admit patient based on priority, they are removed from the waiting list
    // (heap)
    public Patient admit() {
        return patientHeap.remove();
    }
}
