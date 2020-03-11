/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapespeare.shakespeare;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;
import shapespeare.shakespeare.sorters.HeapSort;
import shapespeare.shakespeare.sorters.InsertionSort;
import shapespeare.shakespeare.sorters.MergeSort;
import shapespeare.shakespeare.sorters.SelectionSort;
import shapespeare.shakespeare.sorters.SortingUtils;
import shapespeare.shakespeare.sorters.TrieSort;

/**
 *
 * @author rasmus
 */
public class Shakespeare {

    public static String[] fileToArray(String path, String delimiter) throws IOException {
        return Files.lines(Paths.get(path))
                .flatMap(line -> Stream.of(line.split(delimiter)))
                .map(data -> data.replace("-", " "))
                .map(data -> data.replaceAll("[^A-Za-z]", ""))
                .filter(data -> !data.isEmpty())
                .map(data -> data.toLowerCase())
                .toArray(String[]::new);
    }

    public static void main(String[] args) throws IOException, Exception {

        SortingUtils[] sorters = {
            new SelectionSort<>(),
            new InsertionSort<>(),
            new HeapSort<>(),
            new MergeSort<>(),
            new TrieSort()
        };

        for (SortingUtils sorter : sorters) {
            String sorterName = sorter.getClass().getSimpleName();
            System.out.println("----------" + sorterName + "----------");

            String[] spData = fileToArray("shakespeare-complete-works.txt", " ");
            
            if (sorterName.equals("SelectionSort") || sorterName.equals("InsertionSort")) {
                
                int DesiredLength = 50_000;
                
                spData = Arrays.copyOfRange(spData, 0, DesiredLength);
            }

            System.out.println("Length of spData: " + spData.length);
            Stopwatch sw = new Stopwatch();
            sorter.sort(spData);
            double stop = sw.elapsedTime();
            System.out.println("Duration in milis: " + stop);
        }
    }
}