/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapespeare.shakespeare.sorters;

/**
 *
 * @author rasmus
 * @param <T>
 */
public class HeapSort<T extends Comparable<T>> extends SortingUtils<T>{
    
    @Override
    public void sort(T[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private void heapify(T[] arr, int k, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < k && arr[left].compareTo(arr[largest]) > 0) {
            largest = left;
        }

        if (right < k && arr[right].compareTo(arr[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, k, largest);
        }
    }
    
}
