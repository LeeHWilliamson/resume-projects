import java.util.ArrayList;
import java.util.Comparator;

public class Heap<T> {
    private final ArrayList<T> heapArray;
    private final Comparator<T> compar;

    public Heap(Comparator<T> comparator) {
        // references need to be immutable and thus are never changed outside of
        // constructor
        compar = comparator;
        heapArray = new ArrayList<T>();
    }

    public boolean add(T value) {
        // add element
        heapArray.add(value);

        // sift value to proper index
        siftUp();
        return true;

    }

    private void siftUp() {
        int p = heapArray.size() - 1; // p is the index we sift up from

        while (p != 0) {
            int parent = (p - 1) / 2; // number of nodes doubles w/ each level
            if (compar.compare(heapArray.get(p), heapArray.get(parent)) >= 0) {
                // p is in acceptable position
                break;
            } else {
                // swap with parent
                T temp = heapArray.get(parent);
                heapArray.set(parent, heapArray.get(p));
                heapArray.set(p, temp);

                // move to next comparison
                p = parent;
            }
        }
    }

    public T remove() {
        if (heapArray.size() == 0) {
            return null;
        } else {
            // save value to be returned
            T value = heapArray.get(0);

            // to maintain structure of heap, we must move the most
            // recently added element to the root
            int lastPos = heapArray.size() - 1;
            heapArray.set(0, heapArray.get(lastPos));

            // Now remove last leaf
            heapArray.remove(heapArray.size() - 1);
            siftDown(); // private method to move root to proper index in heap
            return value;
        }
    }

    private void siftDown() {
        int p = 0; // position of root

        int size = heapArray.size();
        while (2 * p + 1 < size) {
            int leftChildPos = 2 * p + 1;
            int rightChildPos = leftChildPos + 1;
            int minChildPos = leftChildPos;

            // Check to see if there is right child
            if (rightChildPos < size) {
                // see which child is smaller
                if (compar.compare(heapArray.get(rightChildPos), heapArray.get(leftChildPos)) < 0) {
                    minChildPos = rightChildPos;
                }
            }
            // If less than children, we do not need to swap
            // Otherwise swap node with smaller child
            if (compar.compare(heapArray.get(p), heapArray.get(minChildPos)) <= 0) {
                break;
            } else {
                // swap
                T temp = heapArray.get(p);
                heapArray.set(p, heapArray.get(minChildPos));
                heapArray.set(minChildPos, temp);
            }
            // do again from child position
            p = minChildPos;

        }
    }
}