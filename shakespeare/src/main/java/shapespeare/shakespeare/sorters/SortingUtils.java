/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapespeare.shakespeare.sorters;

/**
 *
 * @author rasmus
 */
public abstract class SortingUtils<T> {
    
    public abstract void sort(T[] arr);

    protected void swap(T[] arr, int i, int min) {
        T temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }
}
