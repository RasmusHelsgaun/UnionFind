/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cphbusiness.arraysorter;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author rasmus
 * @param <T>
 */
public class ArraySorter<T extends Comparable<T>>{
    
    private T[] items;
    private boolean sortedAscending = true;
    private int size;

    public ArraySorter(T[] items, int size) {
        this.items = items;
        this.size = size;
    }

    public void enqueue(T item) {
        resizeArray(1);
        this.items[items.length - 1] = item;
        if (sortedAscending)
            sortAscending();
        else 
            sortDescending();
        size++;
    }

    public T dequeue() {
        T item = this.items[0];
        this.items[0] = null;
        resizeArray(-1);
        if (sortedAscending)
            sortAscending();
        else 
            sortDescending();
        size--;
        return item;
    }

    public void sortAscending() {
        sort((a, b) -> a.compareTo(b));
        sortedAscending = true;
    }

    public void sortDescending() {
        sort((a, b) -> b.compareTo(a));
        sortedAscending = false;
    }

    public void sort(Comparator<T> comparator) {
        HeapSort hs = new HeapSort();
        hs.sort(this.items, comparator);
    }
    
    public void resizeArray(int resizeAmount) {
        T[] resizedArray = (T[]) new Comparable[this.items.length + resizeAmount];
        
        int iterator = resizeAmount < 0 ? 1 : 0;

        for (int i = iterator; i < this.items.length; i++) {
            resizedArray[i - iterator] = this.items[i];
        }
        
        this.items = resizedArray;
    }

    public int getSize() {
        return size;
    }

    public T[] getItems() {
        return items;
    }
    
    public static void main(String[] args) {
        String[] elements = new String[0];
        
        ArraySorter<String> as = new ArraySorter<>(elements, elements.length);
        
        as.enqueue("Bodil");
        as.enqueue("Dorit");
        as.enqueue("Camilla");
        as.enqueue("Amanda");
        
        //The Queue is automatically sorted ascending, but can be sorted desc/asc by using the respective sort function.

        System.out.println("----------Ascending----------");
        System.out.println("Queue status:" + Arrays.toString(as.getItems()));
        
        System.out.println("Dequeued: " + as.dequeue());
        System.out.println("Queue status: " + Arrays.toString(as.getItems()));
        
        System.out.println("Enqueued: Elisa");
        as.enqueue("Elisa");
        System.out.println("Queue status: " + Arrays.toString(as.getItems()));
        
        
        System.out.println("\r----------Descending---------");
        
        as.sortDescending();
        
        System.out.println("Queue status:" + Arrays.toString(as.getItems()));
        
        System.out.println("Dequeued: " + as.dequeue());
        System.out.println("Queue status: " + Arrays.toString(as.getItems()));
        
        System.out.println("Enqueued: Frederikke");
        as.enqueue("Frederikke");
        System.out.println("Queue status: " + Arrays.toString(as.getItems()));
    }
}
