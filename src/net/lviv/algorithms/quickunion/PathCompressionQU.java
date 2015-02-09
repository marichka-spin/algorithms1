package net.lviv.algorithms.quickunion;

public class PathCompressionQU {

    private int[] id;

    public PathCompressionQU(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            System.out.printf("id[%d] = %d\n", i, i);
        }
    }

    private int root(int i) {
        System.out.println("Calculating root:");
        while (i != id[i]) {
            id[i] = id[id[i]]; ///!!!!!!!!!!
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
        id[i] = j;
        System.out.println("Union: ");
        System.out.printf("id[i] = j : id[%d] = %d\n", i, j);
    }

    public static void main(String[] args) {
        PathCompressionQU pathCompressionQU = new PathCompressionQU(12);
        pathCompressionQU.union(5, 8);
        pathCompressionQU.union(9, 1);
        pathCompressionQU.union(7, 10);
        pathCompressionQU.union(3, 6);
        pathCompressionQU.union(6, 9);
        System.out.println("Connected 5 and 9 " + pathCompressionQU.connected(5, 9));
    }
    
}
