package model;

import java.util.ArrayList;

public class Heap<K extends Comparable<K>, T> implements IPriorityQueue<K, T> {

    private ArrayList<HeapNode<K, T>> list;

    private int heapSize;

    public void heapifyMax(int from) {
        int left = getLeft(from);
        int right = getRigth(from);
        int maxValue = from;

        if (left < heapSize) {
            if (list.get(left).getKey().compareTo(list.get(from).getKey()) > 0)
                maxValue = left;
        }

        if (right < heapSize) {
            if (list.get(right).getKey().compareTo(list.get(maxValue).getKey()) > 0)
                maxValue = right;
        }

        if (maxValue != from) {
            HeapNode<K, T> temporal = list.get(from);
            list.set(from, list.get(maxValue));
            list.set(maxValue, temporal);
            heapifyMax(maxValue);
        }
    }

    public void makeHeap() {
        this.heapSize = list.size();
        for (int i = (list.size() / 2) - 1; i >= 0; i--) {
            heapifyMax(i);
        }
    }

    /**
     * It´s worth to say when the heapsort is applied, the list attribute is not a
     * heap anymore, thus,
     * the heapSize is changed to 0.
     */
    public void sortedByHeap() {
        makeHeap();
        for (int i = list.size() - 1; i >= 1; i--) {
            HeapNode<K, T> temporal = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temporal);
            heapSize -= 1;
            heapifyMax(0);
        }

    }

    public int getFather(int position) {
        position += 1;
        if (position == 0)
            return 0;
        else
            return position / 2 - 1;
    }

    public int getLeft(int position) {
        position += 1;
        return position * 2 - 1;
    }

    public int getRigth(int position) {
        position += 1;
        return position * 2;
    }

    @Override
    public K heapExtractMax() {
        if (heapSize < 0)
            return null;
        K max = list.get(0).getKey();
        list.set(0, list.get(heapSize - 1));
        heapSize--;
        heapifyMax(0);
        return max;
    }

    @Override
    public K getmaX() {
        return list.get(0).getKey();
    }

    @Override
    public String incrementKey(int position, K key) {
        if (key.compareTo(list.get(position).getKey()) < 0) {
            return "Not incrementing priority";
        }
        list.get(position).setKey(key);

        while (position > 0 && list.get(getFather(position)).getKey().compareTo(list.get(position).getKey()) < 0) {

            HeapNode<K, T> temporal = list.get(getFather(position));
            list.set(getFather(position), list.get(position));
            list.set(position, temporal);
            position = getFather(position);
        }
        return "Increment done";
    }

    @Override
    public void insertElement(K key, T value) {
        heapSize++;
        list.add(new HeapNode<>(key, value));
        int position = heapSize - 1;

        while (position > 0 && list.get(getFather(position)).getKey().compareTo(list.get(position).getKey()) < 0) {

            HeapNode<K, T> temporal = list.get(getFather(position));
            list.set(getFather(position), list.get(position));
            list.set(position, temporal);
            position = getFather(position);
        }
    }

    public Heap() {
        list = new ArrayList<>();
        heapSize = 0;
    }

    public ArrayList<HeapNode<K, T>> getList() {
        return list;
    }

    public void setList(ArrayList<HeapNode<K, T>> list) {
        this.list = list;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    public void delete(T value) {
        int position = 0;
        for (int i = 0; i < heapSize; i++) {
            if (list.get(i).getValue().equals(value)) {
                position = i;
                break;
            }
        }
        list.set(position, list.get(heapSize - 1));
        heapSize--;
        heapifyMax(position);
    }
}
