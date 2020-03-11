/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapespeare.shakespeare.sorters;

import shapespeare.shakespeare.trie.Trie;

/**
 *
 * @author rasmus
 */
public class TrieSort extends SortingUtils<String> {
    
    @Override
    public void sort(String[] arr) {
        Trie trie = new Trie();

        for (int i = 0; i < arr.length; i++) {
            trie.insert(arr[i], i);
        }

        trie.traversePreorder(arr);
    }
}
