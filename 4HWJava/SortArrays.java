import java.util.Scanner;

public class SortArrays {
    public static void main(String args[]) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = inputScanner.nextInt();
        System.out.println("Введите элементы массива: ");
        int[] myArray = new int[size];
        for(int i=0; i<size; i++) {
            myArray[i] = inputScanner.nextInt();
        }
        HeapSort.heapSort(myArray, size);
        inputScanner.close();
    } 
}
