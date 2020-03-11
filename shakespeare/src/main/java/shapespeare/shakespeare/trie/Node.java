/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapespeare.shakespeare.trie;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rasmus
 */
public class Node {

    private Node[] children;
    private List<Integer> indices;

    Node() {
        children = new Node[26];
        indices = new ArrayList<>(0);
    }

    Node getChild(char index) {
        if (index < 'a' || index > 'z') {
            return null;
        }

        return children[index - 'a'];
    }

    void addChild(char index) {
        if (index < 'a' || index > 'z') {
            return;
        }

        Node node = new Node();
        children[index - 'a'] = node;
    }

    List<Integer> getIndices() {
        return indices;
    }

    void addIndex(int index) {
        indices.add(index);
    }
}
