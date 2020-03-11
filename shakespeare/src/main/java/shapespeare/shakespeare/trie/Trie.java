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
public class Trie {

    private List<String> trieList = new ArrayList<>();

    private Node rootNode;

    public Trie() {
        rootNode = null;
    }

    public void insert(String key, int index) {
        if (rootNode == null) {
            rootNode = new Node();
        }

        Node currentNode = rootNode;

        for (int i = 0; i < key.length(); i++) {
            char keyChar = key.charAt(i);

            if (currentNode.getChild(keyChar) == null) {
                currentNode.addChild(keyChar);
            }

            currentNode = currentNode.getChild(keyChar);
        }

        currentNode.addIndex(index);
    }

    public void traversePreorder(String[] array) {
        traversePreorder(rootNode, array);
    }

    private void traversePreorder(Node node, String[] array) {
        if (node == null) {
            return;
        }

        if (node.getIndices().size() > 0) {
            for (int index : node.getIndices()) {
                trieList.add(array[index]);
            }
        }

        for (char index = 'a'; index <= 'z'; index++) {
            traversePreorder(node.getChild(index), array);
        }
    }

    public String[] getTrieArr() {
        return trieList.toArray(new String[trieList.size()]);
    }
}
