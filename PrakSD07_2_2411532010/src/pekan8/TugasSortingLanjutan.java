// Nama: Ibrahim Mousa Dhani
// NIM : 2411532010

package pekan8;

import java.util.Arrays;

public class TugasSortingLanjutan {

	 public static void selectionSortDescending(int[] arr) {
	        int n = arr.length;
	        for (int i = 0; i < n - 1; i++) {
	           
	            int max_idx = i;
	            for (int j = i + 1; j < n; j++) {
	              
	                if (arr[j] > arr[max_idx]) {
	                    max_idx = j; }
	                } 
	            int temp = arr[max_idx];
	            arr[max_idx] = arr[i];
	            arr[i] = temp;

	            System.out.println("Langkah " + (i + 1) + ": " + Arrays.toString(arr));
	        }
	    }
    public static void main(String[] args) {
      
        int[] data = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};

        System.out.println("Deret awal: " + Arrays.toString(data));
        System.out.println("Algoritma: Selection Sort\n");
       
        selectionSortDescending(data);

        System.out.println("\nHasil: " + Arrays.toString(data));
    }
}