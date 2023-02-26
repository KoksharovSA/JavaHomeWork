public class Labirint {
    public static void main(String[] args) {
        OutputField.printFieldInConsol(WorkingWithField.searchWay(
            new FieldBuilder(10, 10, 20).field, new Point(4,5,1), 
            new Point(8,5,-2)));
        OutputField.printFieldInConsol(WorkingWithField.searchWay(
            new FieldBuilder().field, new Point(1,1,1), new Point(5,5,-2)));
    }
    
}