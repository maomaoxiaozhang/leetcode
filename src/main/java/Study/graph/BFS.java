package Study.graph;

import util.Graph;

import java.util.LinkedList;

/**
 * Created by lenovo on 2017/11/29.
 * bfs每次遍历找出所有非自身的邻接点加入队列即可
 */
public class BFS {
    public static void main(String[] args) {
        Graph graph = new Graph();
        int size = graph.size;
        int[][] connection = graph.connection;
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] flag = new boolean[size];
        queue.add(0);
        bfs(queue, size, connection, flag);
    }

    public static void bfs(LinkedList<Integer> queue, int size, int[][] connection, boolean[] flag) {
        while (!queue.isEmpty()) {
            int current = queue.pollFirst();
            flag[current] = true;
            System.out.println("当前访问节点：" +current);
            for (int i = 0; i < size; i++) {
                if (i != current && connection[current][i] == 1 && !flag[i]) {
                    queue.offerLast(i);
                    flag[i] = true;
                }
            }
        }
    }
}
