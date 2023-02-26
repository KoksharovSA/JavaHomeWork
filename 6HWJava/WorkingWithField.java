import java.util.ArrayDeque;
import java.util.Deque;

public class WorkingWithField {
    
    
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
}
