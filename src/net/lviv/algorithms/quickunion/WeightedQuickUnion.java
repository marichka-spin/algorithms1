package net.lviv.algorithms.quickunion;

/*
In weighted quick union, we make the root of the smaller tree points to the root of the larger tree.
 */
public class WeightedQuickUnion {

    private int[] id;
    private int[] sz;

    public WeightedQuickUnion(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            System.out.printf("id[%d] = %d\n", i, i);
        }
    }

    private int root(int i) {
        System.out.println("Calculating root:");
        while (i != id[i]) {
            i = id[i];
            System.out.printf("%d = id[%d]\n", i, i);
        }
        System.out.println("Root: " + i);
        return i;
    }

    public boolean connected(int p, int q) {
        System.out.printf("Connected %d and %d : %b", p, q, root(p) == root(q));
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        System.out.printf("Root p - %d : %d\n", p, i);
        int j = root(q);
        System.out.printf("Root q - %d : %d\n", q, j);
        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    public static void main(String[] args) {
        WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(12);
        weightedQuickUnion.union(5, 8);
        weightedQuickUnion.union(9, 1);
        weightedQuickUnion.union(7, 10);
        weightedQuickUnion.union(3, 6);
        weightedQuickUnion.union(6, 9);
        System.out.println("Connected 5 and 9 " + weightedQuickUnion.connected(5, 9));
    }
}
