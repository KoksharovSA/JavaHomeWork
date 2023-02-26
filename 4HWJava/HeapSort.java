import java.util.Arrays;

public class HeapSort {
   public static void heapSort(int[] myArray, int length) {
      int temp;
      int size = length-1;
      for (int i=(length / 2); i >= 0; i--) {
         heapify(myArray, i, size);
      };
      for(int i=size; i>=0; i--) {
         temp = myArray[0];
         myArray[0] = myArray[size];
         myArray[size] = temp;
         size--;
         heapify(myArray, 0, size);
      }
      System.out.println(Arrays.toString(myArray));
   }

   private static void heapify(int [] myArray, int i, int heapSize) {
      int a = 2*i;
      int b = 2*i+1;
      int maxElement;
      if (a <= heapSize && myArray[a] > myArray[i]) {
         maxElement = a;
      } else {
         maxElement = i;
      }
      if (b <= heapSize && myArray[b] > myArray[maxElement]) {
         maxElement = b;
      }
      if (maxElement != i) {
         int temp = myArray[i];
         myArray[i] = myArray[maxElement];
         myArray[maxElement] = temp;
         heapify(myArray, maxElement, heapSize);
      }
   }
}
