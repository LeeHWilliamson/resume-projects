import java.util.Comparator;
import java.util.Random;

public class HeapDemo {
    // Comparator that compares integers
    // Necessary because heap has comparator as parameter
    // Static because implemented in main
    static class NaturalIntegerOrder implements Comparator<Integer> {
        public int compare(Integer x, Integer y) {
            return x.compareTo(y);
        }
    }

    // Demonstration of heap with Integers
    public static void main(String[] args) {
        NaturalIntegerOrder comparator = new NaturalIntegerOrder();
        Heap<Integer> numberHeap = new Heap<Integer>(comparator);
        // add random Ints heap
        for (int i = 0; i < 20; i++) {
            int num = new Random().nextInt(100);
            System.out.print(num + " ");
            numberHeap.add(num);
        }
        System.out.println();
        // remove values from heap to see that they are removed in proper order
        for (Integer num = numberHeap.remove(); num != null; num = numberHeap.remove()) {
            System.out.print(num + " ");
        }
    }
}