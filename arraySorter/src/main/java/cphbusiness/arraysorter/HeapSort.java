/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cphbusiness.arraysorter;

import java.util.Comparator;

/**
 *
 * @author rasmus
 * @param <T>
 */
public class HeapSort<T extends Comparable<T>> {
    
    public void sort(T[] arr, Comparator<T> comparator) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, comparator);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0, comparator);
        }
    }

    private void heapify(T[] items, int k, int i, Comparator<T> comparator) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < k && comparator.compare(items[left], items[largest]) > 0) {
            largest = left;
        }

        if (right < k && comparator.compare(items[right], items[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            swap(items, i, largest);
            heapify(items, k, largest, comparator);
        }
    }
    
    private void swap(T[] arr, int i, int min) {
        T temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }
}
