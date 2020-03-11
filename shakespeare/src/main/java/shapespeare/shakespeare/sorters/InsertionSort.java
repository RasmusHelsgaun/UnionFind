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
public class InsertionSort<T extends Comparable<T>> extends SortingUtils<T> {
    
    @Override
    public void sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int k = i;
            while (k > 0 && arr[k - 1].compareTo(arr[k]) > 0) {
                swap(arr, k, k - 1);
                k = k - 1;
            }
        }
    }
}
