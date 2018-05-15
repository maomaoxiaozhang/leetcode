package util;

/**
 * Created by lenovo on 2017/11/29.
 */
public class Graph {
    public int size = 10;
    public int[][] connection = {{1, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                                 {1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                                 {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                                 {0, 1, 0, 1, 1, 1, 1, 0, 0, 0},
                                 {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                                 {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                                 {0, 0, 0, 1, 0, 1, 1, 0, 0, 0},
                                 {1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                 {0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                 {0, 0, 0, 0, 0, 0, 0, 1, 1, 1}};

    public Graph() {
    }

    public Graph(int size, int[][] connection) {
        this.size = size;
        this.connection = connection;
    }
}
