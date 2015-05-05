public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    class Point{
       int height;
       int level;
       int x, y;
       Point(int height, int level, int x, int y) {
           this.height = height;
           this.level = level;
           this.x = x;
           this.y = y;
       }
    }

    public int trapRainWater(int[][] heights) {
        // write your code here
        // modified dijkstra algorithm
        // level: level of water each cell can hold
        // height: height of cell
        // initialization: border elements: height = level, inner: level = MAX
        // minheap to store border cells. Then update level of inner cells
        // by this logic: update_level = Math.max(cell_height, Math.min(neighout_level, old_level))
        // time complexity: O(n^2*logN) // maintains min heap property
        int row = heights.length;
        if (row == 0) {
            return 0;
        }
        int col = heights[0].length;
        Point[][] points = new Point[row][col];
        PriorityQueue<Point> minHeap = new PriorityQueue<Point>(10, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                return a.level - b.level;
            }
        });

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                    // border
                    Point p = new Point(heights[i][j], heights[i][j], i, j);
                    points[i][j] = p;
                    minHeap.add(p);
                } else {
                    Point p = new Point(heights[i][j], Integer.MAX_VALUE, i, j);
                    points[i][j] = p;
                }
            }
        }

        while (!minHeap.isEmpty()) {
            Point p = minHeap.poll();
            List<Point> neighbours = getNeighbours(points, p);
            for (Point nei : neighbours) {
                int oldLevel = nei.level;
                int update = Math.max(nei.height, Math.min(p.level, nei.level));
                if (oldLevel != update) {
                    nei.level = update;
                    minHeap.add(nei);
                }
            }
        }

        int sum = 0;
        // parse the points again
        for (int i = 1; i < row -1; i++) {
            for (int j = 1; j < col - 1; j++) {
                Point p = points[i][j];
                sum += (p.level - p.height);
            }
        }

        return sum;
    }

    public List<Point> getNeighbours(Point[][] points, Point p) {
        List<Point> res = new ArrayList<Point>();
        int x = p.x;
        int y = p.y;
        if (x != 0) {
            res.add(points[x - 1][y]);
        }
        if (x != points.length - 1) {
            res.add(points[x + 1][y]);
        }
        if (y != 0) {
            res.add(points[x][y - 1]);
        }
        if (y != points[0].length - 1) {
            res.add(points[x][y + 1]);
        }

        return res;
    }
};

