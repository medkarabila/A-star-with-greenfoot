public class Point {
 public int row;
 public int col;

 public Point() {row = col = 0;
 }

 public Point( int _row, int _col) {
 row = _row;
 col = _col;
 }
 public boolean equals(Point p) {
 return (p.row == row) && (p.col == col);
 }
}