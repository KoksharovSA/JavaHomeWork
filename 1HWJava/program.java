//Написать программу вычисления n-ого треугольного числа

public class program {
    public static void main(String[] args) { 
        System.out.println(triangularNumber(7));
        printChristmasTree(7);
    }

    //Вычисление n-ого трецгольного числа
    public static int triangularNumber(int n) {
        return (n*(n+1))/2;
    }

    //Рисуем ёлку
    public static void printChristmasTree(int height) {
        for (int i = 1; i <= height; i++) {
            String level = "";
            for (int j = 0; j < (triangularNumber(height)-triangularNumber(i))/2; j++) {
                if(i == 1){}
                level += "  ";
            }
            if (triangularNumber(i) % 2 != 0 && triangularNumber(height) % 2 == 0) {
                level += " ";
            } else if (triangularNumber(i) % 2 == 0 && triangularNumber(height) % 2 != 0) {
                level += " ";
            }
            for (int k = 0; k < triangularNumber(i); k++) {
                level += "* ";
            }
            System.out.println(level);
        }
    }   
}