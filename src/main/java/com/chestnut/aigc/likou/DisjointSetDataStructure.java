package com.chestnut.aigc.likou;

public class DisjointSetDataStructure {
    private static final int N = 0;
    private static int[] unionFindSets;

    public void init() {
        unionFindSets = new int[N];
    }

    //查询带路径压缩
    public int fund(int x) {
        if (unionFindSets[x] == x) {
            return x;
        }
        unionFindSets[x] = fund(unionFindSets[x]);
        return unionFindSets[x];
    }

    public void join(int x, int y) {
        int a = fund(x);
        int b = fund(y);
        if (a == b) {
            return;
        }
        unionFindSets[a] = b;
    }

    public boolean isUnion(int x, int y) {
        return fund(x) == fund(y);
    }

}
