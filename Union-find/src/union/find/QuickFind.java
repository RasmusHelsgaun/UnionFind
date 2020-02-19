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
public class QuickFind implements UnionFind {

    private int[] pointSets;
    private int count;

    public QuickFind(int n) {
        this.count = n;
        this.pointSets = new int[n];
        for (int i = 0; i < n; i++) {
            pointSets[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int setOfp = pointSets[p];
        int setOfq = pointSets[q];

        for (int i = 0; i < count; i++) {
            if (pointSets[i] == setOfp) {
                pointSets[i] = setOfq;
            }
        }
        count--;
    }

    @Override
    public int find(int p) {
        return pointSets[p];
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
            res += pointSets[i]+ ", ";
        }
        return res;
    }

    public static void main(String[] args) {
        QuickFind qf = new QuickFind(10);
        
        System.out.println("Count: " + qf.count());
        System.out.println("4 is connected to 8: " + qf.connected(4, 8));
        System.out.println(qf.toString());
        
        qf.union(4, 8);
        
        System.out.println("Count: " + qf.count());
        System.out.println("4 is connected to 8: " + qf.connected(4, 8));
        System.out.println(qf.toString());
    }
    
}
