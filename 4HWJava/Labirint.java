import java.util.ArrayDeque;
import java.util.Deque;

// -1 Стены
// -2 Выход
public class Labirint {
    public static void main(String[] args) {
        printField(fieldBuilder());
        printField(searchWay(fieldBuilder(), new Point(4,5,1)));
        printField(searchWay(fieldBuilder(), new Point(1,1,1)));
    }
    
    public static int[][] searchWay(int[][] field, Point startPosition) {
        int[][] result = field.clone();
        Deque<Point> buffer = new ArrayDeque<Point>();
        Point currentPosition = new Point(startPosition.X, startPosition.Y, startPosition.number);
        buffer.add(currentPosition);
        result[currentPosition.Y][currentPosition.X] = 1;
        while (true) {
            if (result[currentPosition.Y - 1][currentPosition.X] == 0) {
                result[currentPosition.Y - 1][currentPosition.X] = currentPosition.number + 1;
                buffer.addLast(new Point(currentPosition.X, currentPosition.Y - 1, currentPosition.number + 1));
            } else if (result[currentPosition.Y][currentPosition.X + 1] == 0) {
                result[currentPosition.Y][currentPosition.X + 1] = currentPosition.number + 1;
                buffer.addLast(new Point(currentPosition.X + 1, currentPosition.Y, currentPosition.number + 1));
            } else if (result[currentPosition.Y + 1][currentPosition.X] == 0) {
                result[currentPosition.Y + 1][currentPosition.X] = currentPosition.number + 1;
                buffer.addLast(new Point(currentPosition.X, currentPosition.Y + 1, currentPosition.number + 1));
            } else if (result[currentPosition.Y][currentPosition.X - 1] == 0) {
                result[currentPosition.Y][currentPosition.X - 1] = currentPosition.number + 1;
                buffer.addLast(new Point(currentPosition.X - 1, currentPosition.Y, currentPosition.number + 1));
            } else {
                if (buffer.peek() != null) {
                    currentPosition = buffer.pop();
                } else {
                    break;
                }
            }            
        }
        return result;
    }

    public static void printField(int[][] field) {
        for (int[] points : field) {
            for (int point : points) {
                StringBuilder line = new StringBuilder();
                line.append(("" + point).length() > 1 ? " " + point : "  " + point);
                System.out.print(line);
            }
            System.out.println("");
        }
        System.out.println();
    }   

    public static int[][] fieldBuilder() {
        int[][] field = {
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 
            {-1,  0,  0,  0, -1,  0, -1,  0, -2, -1},
            {-1,  0, -1,  0,  0,  0, -1,  0,  0, -1},
            {-1,  0, -1,  0, -1,  0,  0,  0,  0, -1},
            {-1,  0, -1,  0, -1, -1,  0,  0,  0, -1},
            {-1,  0, -1,  0,  0, -1,  0, -1,  0, -1},
            {-1,  0, -1,  0,  0, -1,  0, -1,  0, -1},
            {-1,  0, -1, -1, -1, -1,  0, -1,  0, -1},
            {-1, -2,  0,  0,  0,  0,  0, -1,  0, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
        };
        return field;
    }
}

class Point {
    int X;
    int Y;
    int number;
    public Point(int x, int y, int number) {
        X = x;
        Y = y;
        this.number = number;
    }     
}
