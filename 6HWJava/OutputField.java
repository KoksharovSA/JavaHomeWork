public class OutputField { 
    /**
     * 
     * @param field Поле где -1 это стены; -2 это выходы; 0 это пустота
     */
    public static void printFieldInConsol(int[][] field) {
        for (int[] points : field) {
            for (int point : points) {
                StringBuilder line = new StringBuilder();
                if (point == -1) {
                    line.append("███");
                } else if (point == -2) {
                    line.append("░░░");
                } else if (point == 0) {
                    line.append("   ");
                } else {
                    line.append(("" + point).length() > 1 ? " " + point : "  " + point);
                }
                System.out.print(line);
            }
            System.out.println("");
        }
        System.out.println();
    } 
}
