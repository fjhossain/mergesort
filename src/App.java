import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import Sort.Sort;

public class App {
    public static void printArray(int [] array) {
        for (int a : array){
            System.out.print(a + " ");
        }
        System.out.println();
    }
         public static int[] createRandomArray(int arrayLength){
            int [] array = new int[arrayLength];
            Random random = new Random();
            for (int i = 0; i < arrayLength; i ++){
                array[i] = random.nextInt(100);
            } return array;
         }

         public static boolean isSorted(int[] array){
            for (int i = 0; i < array.length - 1; i ++){
                if (array[i] > array[i+1]){
                    return false;
                }
            } return true;
         }
    public static void main(String[] args) throws Exception {
        long startTime;
        Scanner scanner = new Scanner(System.in);

        while(true){
        System.out.println("What is the length of random integer array? enter: ");
        int arrayLength = scanner.nextInt();
        startTime = System.currentTimeMillis();
        int[] array = createRandomArray(arrayLength);
        System.out.printf("time to create an integer array of length %d is %.2f s\n", arrayLength, (System.currentTimeMillis() - startTime) / 1000.0);
        
        int [] sortedArray = Sort.mergeSort(array);
        System.out.printf("mergesort an integer array of length %d is %.2f s\n", arrayLength, (System.currentTimeMillis() - startTime) / 1000.0);
        
        System.out.println("the sorted array is in correct order: " + isSorted(sortedArray));
        startTime = System.currentTimeMillis();
        Sort.bubbleSort(array);
        System.out.printf("bubblesort an integer array of length %d is %.2f s\n", arrayLength, (System.currentTimeMillis() - startTime) / 1000.0);
        System.out.println("mergesort and bubblesort generates same result: " + Arrays.equals(sortedArray, array));
         System.out.println("\n" + "continue? please enter yes or no:");
         String yesno = scanner.next();
         if (yesno.equals("no")) break;
          
       } scanner.close();
       System.out.println("goodbye");
       
     }

    }


