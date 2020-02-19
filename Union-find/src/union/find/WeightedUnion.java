/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package union.find;

/**
 *
 * @author rasmus
 */
public class WeightedUnion implements UnionFind {
    
    private int[] pointSets;
    private int[] setCounter;
    private int count;

    public WeightedUnion(int n) {
        this.count = n;
        this.pointSets = new int[n];
        this.setCounter = new int[n];
        
        for (int i = 0; i < n; i++) {
            pointSets[i] = i;
            setCounter[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        
        if (setCounter[i] < setCounter[j]) {
            pointSets[i] = j;
            setCounter[j] += setCounter[i];
        } else {
            pointSets[j] = i;
            setCounter[i] += setCounter[j];
        }
        
        
        count--;
    }

    @Override
    public int find(int p) {
        while (p != pointSets[p]) {
            p = pointSets[p];
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
    
    @Override
    public String toString() {
        String res = "pointSets: ";
        for (int i = 0; i < pointSets.length; i++) {
            res += pointSets[i] + ", ";
        }
        res += "setCounter: ";
        for (int i = 0; i < setCounter.length; i++) {
            res += setCounter[i] + ", ";
        }
        return res;
    }
    
    
    
    public static void main(String[] args) {
        WeightedUnion wu = new WeightedUnion(10);
        
        System.out.println(wu.toString());
        System.out.println("4 is connected to 8: " + wu.connected(4, 8));
        System.out.println("Count: " + wu.count());
        
        wu.union(8, 4);
        
        System.out.println(wu.toString());
        System.out.println("4 is connected to 8: " + wu.connected(4, 8));
        System.out.println("Count: " + wu.count());
        
        wu.union(8, 5);
        
        System.out.println(wu.toString());
        System.out.println("5 is connected to 8: " + wu.connected(4, 8));
        System.out.println("Count: " + wu.count());
    }
}
