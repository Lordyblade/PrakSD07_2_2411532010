package pekan7;

public class TugasSorting {

    static void insertionSort(char[] arr, int n) {
        int start = arr.length - n;
        for (int i = start + 1; i < arr.length; i++) {
            char key = arr[i];
            int j = i - 1;
            while (j >= start && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        char[] alfabet = {
            'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q',
            'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g',
            'f', 'e', 'd', 'c', 'b', 'a'
        };

        insertionSort(alfabet, 10);

        for (int i = 0; i < alfabet.length; i++) {
            System.out.print(alfabet[i]);
            if (i < alfabet.length - 1) {
                System.out.print("-");
            }
        }
    }
}
