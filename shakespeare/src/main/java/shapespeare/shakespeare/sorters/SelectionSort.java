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
public class SelectionSort<T extends Comparable<T>> extends SortingUtils<T>{

    @Override
    public void sort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[k].compareTo(arr[min]) < 0) {
                    min = k;
                }
            }
            swap(arr, i, min);
        }
    }
}
