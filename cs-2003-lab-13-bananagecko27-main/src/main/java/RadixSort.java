package main.java;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/** Implementation of least-significant digit radix sort with multiple queues. */
public class RadixSort {

  /**
   * Sorts the input array in-place using the radix sort algorithm. Array should be sorted
   * from least to greatest.
   * @param arr the array of integers to be sorted
   * @param k the maximum number of digits in any of the inputs
   */
  public static void sort(Integer[] arr, int k) {
    // TODO: implement sort(Integer[], int)
    LeastSignificantDigitRadixSort(arr,10, k);
    //throw new UnsupportedOperationException("sort(Integer[], int) not yet implemented");
  }

 public static void LeastSignificantDigitRadixSort(Integer[] arr, int n, int k){
  BasicQueue[] num = new BasicQueue[10];

  for (int queueNum = 0; queueNum < 10; queueNum++) {
        num[queueNum] = new BasicQueue<Integer>();
    }  
  
  for(int j=1; j<k; j++){ 
    for(int i=0; i<arr.length; i++){
        int d = getKthDigit(arr[i], j , n);
        num[d].enqueue(arr[i]);
    }
    int w =0;
    for(int m =0; m<10; m++){
      while(!num[m].isEmpty()){
          arr[w] = (Integer) num[m].dequeue();
          w++;
        }
    } 
  } 
}

  /**
   * Find the kth digit of a input num writen in base numbase
   * @param num is the number whose kth digit is being retrieved
   * @param k is the position of the digit we want to know (from the right)
   * @param numbase is the base used for the input num (e.g., base 10).
   */
  public static int getKthDigit(int num, int k, int numbase) {
    return (num / (int) Math.pow(numbase, k)) % numbase;
  }

  public static void main(String[] argv) {
    ArrayList<Integer> list = new ArrayList<>();
    try {
      Scanner scan = new Scanner(new File("lab13.txt"));
      while (scan.hasNextInt()) {
        list.add(scan.nextInt());
      }
      scan.close();
    } catch (IOException e) {
      System.err.println(e);
      System.exit(1);
    }
    Integer[] arr = list.toArray(Integer[]::new);
    sort(arr, 5);
    System.out.println(Arrays.toString(arr));
  }
}
