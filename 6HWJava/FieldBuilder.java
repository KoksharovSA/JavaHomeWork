import java.util.Random;

public class FieldBuilder {
    int[][] field;
    /**
     * Лабиринт по умолчанию
     */
    public FieldBuilder() {
        this.field = new int[][]{
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 
            {-1,  0,  0,  0, -1,  0, -1,  0,  0, -1},
            {-1,  0, -1,  0,  0,  0, -1,  0,  0, -1},
            {-1,  0, -1,  0, -1,  0,  0,  0,  0, -1},
            {-1,  0, -1,  0, -1, -1,  0,  0,  0, -1},
            {-1,  0, -1,  0,  0, -1,  0, -1,  0, -1},
            {-1,  0, -1,  0,  0, -1,  0, -1,  0, -1},
            {-1,  0, -1, -1, -1, -1,  0, -1,  0, -1},
            {-1,  0,  0,  0,  0,  0,  0, -1,  0, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
        };
    }
    /**
     * 
     * @param field Поле со стенами
     */
    public FieldBuilder(int[][] field) {
        this.field = field;
    }
    /**
     * Рандомно расставляет стены
     * @param x Размер поля по X
     * @param y Размер поля по Y
     * @param numberWalls Количество точек стен
     */
    public FieldBuilder(int x, int y, int numberWalls) {
        int[][] temp = new int[x][y];
        for (int i = 0; i < x; i++) {
            temp[0][i] = -1;
            temp[x-1][i] = -1;
            temp[i][0] = -1;
            temp[i][y-1] = -1;
            for (int j = 1; j < y-1; j++) {
                if (i != 0 && i != x-1)  {
                    temp[i][j] = 0;
                }
            }
        }
        for (int k = 0; k <= numberWalls; k++) {
            temp[new Random().nextInt(1,x)][new Random().nextInt(1,y)] = -1;
        }
        this.field = temp;
    }
}
