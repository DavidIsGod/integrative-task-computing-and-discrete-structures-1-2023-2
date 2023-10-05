package model;
import java.util.ArrayList;
public class Heap<T> implements IPriorityQueue<T> {

    private ArrayList<T> heap;

    private int heapSize;

    public Heap() {
        heap = new ArrayList<>();
        heapSize = 0;
    }

    @Override


    public void insert(T value) {
      /*  heap.add(value);
        heapSize++;
        int index = heapSize - 1;
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (compareTo(heap.get(index), heap.get(parent)) > 0) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    */

        /*
        public T extractMax () {
        T max = heap.get(0);
        heap.set(0, heap.get(heapSize - 1));
        heap.remove(heapSize - 1);
        heapSize--;
        heapify(0);
        return max;
    }

     */

        /*
            public T max () {
                /* return heap.get(0);
                 */


            }



    @Override
    public T extractMax() {
        return null;
    }

    @Override
    public T max() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
