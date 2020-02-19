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
public class QuickUnion implements UnionFind {

    private int[] pointSets;
    private int count;

    public QuickUnion(int n) {
        this.count = n;
        this.pointSets = new int[n];
        for (int i = 0; i < n; i++) {
            pointSets[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        pointSets[i] = j;
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
            res += pointSets[i]+ ", ";
        }
        return res;
    }
    
    public static void main(String[] args) {
        QuickUnion qu = new QuickUnion(10);
        
        System.out.println(qu.toString());
        System.out.println("4 is connected to 8: " + qu.connected(4, 8));
        System.out.println("Count: " + qu.count());
        
        qu.union(4, 8);
        
        System.out.println(qu.toString());
        System.out.println("4 is connected to 8: " + qu.connected(4, 8));
        System.out.println("Count: " + qu.count());
    }

}
