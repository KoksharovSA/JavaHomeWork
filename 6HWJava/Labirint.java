public class Labirint {
    public static void main(String[] args) {
        int[][] field = {
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 
            {-1,  0,  0,  0, -1,  0, -1,  0, -2, -1},
            {-1,  0, -1,  0,  0,  0, -1,  0,  0, -1},
            {-1,  0, -1, -1,  0,  0,  0,  0,  0, -1},
            {-1,  0, -1,  0, -1, -1,  0,  0,  0, -1},
            {-1,  0, -1,  0,  0, -1,  0, -1,  0, -1},
            {-1,  0, -1,  0,  0, -1,  0, -1,  0, -1},
            {-1,  0, -1,  0, -1, -1,  0, -1,  0, -1},
            {-1, -2,  0,  0,  0,  0,  0, -1,  0, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
        };
        FieldBuilder fieldB = new FieldBuilder(field);
        OutputField.printFieldInConsol(fieldB.field);
        OutputField.printFieldInConsol(new FieldBuilder().field);
        OutputField.printFieldInConsol(WorkingWithField.searchWay(
            fieldB.field, new Point(4,5,1)));
        OutputField.printFieldInConsol(WorkingWithField.searchWay(
            new FieldBuilder().field, new Point(1,1,1)));
    }
    
}