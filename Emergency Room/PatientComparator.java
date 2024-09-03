import java.util.Comparator;

public class PatientComparator implements Comparator<Patient> {
    // Compare assigns priority between 2 patients, any time
    // patients are compared (i.e. when patients are sifted up or down)
    public int compare(Patient x, Patient y) {
        // HIGHER severity means patients should be closer to top of list (have lower
        // value)
        int ret = 0;
        // patient x has lower severity than patient y, thus patient x
        // is given higher value of ret, moving them to a lower priority on the list
        if (x.getSeverity().compareTo(y.getSeverity()) < 0) {
            ret = 1;
        }
        // patient x has higher severity than patient y, they are given a lower
        // value of ret, moving them towards top of list
        else if (x.getSeverity().compareTo(y.getSeverity()) > 0)
            ret = -1;
        // ret will remain at 0 if severity between patients is equal
        if (ret == 0) {
            // patient x was born before patient y and so is older
            // Assign patient x lower value for ret, moving them towards
            // top of list relative to younger patients with same severity
            if (x.getDOB().isBefore(y.getDOB()))
                ret = -1;
            else if (x.getDOB().isAfter(y.getDOB()))
                ret = 1;
            else
                ret = 0;
        }
        // ret will = 0 for patients with same birth date and injury severity
        // so we compare their arrival time
        if (ret == 0) {
            // similar to above comparison, patient x arrived before patient y
            // we give them lower value of ret to reflect higher priority
            if (x.getArrivalTime().isBefore(y.getArrivalTime()))
                ret = -1;
            else if (x.getArrivalTime().isAfter(y.getArrivalTime()))
                ret = 1;
        }
        return ret;
    }
}
