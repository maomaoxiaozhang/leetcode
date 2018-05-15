package Study.graph;

import util.Graph;

/**
 * Created by lenovo on 2017/11/29.
 * 图可能不是完全连通的，需要对所有节点进行dfs
 * dfs类似前序输出，节点没有左右孩子的概念，只有邻接点，需要额外的flag标记节点是否访问过
 */
public class DFS {
    public static void main(String[] args) {
        Graph graph = new Graph();
        int size = graph.size;
        int[][] connection = graph.connection;
        boolean[] flag = new boolean[size];
        for (int i = 0; i < size; i++)
            dfs(size, connection, flag, i);
    }

    public static void dfs(int size, int[][] connection, boolean[] flag, int v) {
        if (!flag[v]) {
            flag[v] = true;
            System.out.println("当前访问节点：" + v);
            while (true) {
                int next = adj(size, connection, flag, v);
                if (next == -1)
                    break;
                dfs(size, connection, flag, next);
            }
        }
    }

    public static int adj(int size, int[][] connection, boolean[] flag, int x) {
        for (int i = 0; i < size; i++) {
            if (connection[x][i] == 1 && !flag[i])
                return i;
        }
        return -1;
    }
}
