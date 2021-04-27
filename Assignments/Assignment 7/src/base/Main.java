package base;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {0, 3, 2, 4, 1, 5};

        // Printing unsorted list
        for (int index = 0; index < numbers.length; index++) {
            System.out.print(numbers[index]);
        }

        // Sorting list
        bubbleSort(numbers);
        System.out.println("");

        // Printing sorted list
        for (int index = 0; index < numbers.length; index++) {
            System.out.print(numbers[index]);
        }
    }

    // Bubble Sort method
    public static void bubbleSort(int[] list) {
        for (int index = 0; index < list.length - 1; index = index + 1) {
            for (int i = 0; i < list.length - index - 1; i = i + 1){
                int left = list[i];
                int right = list[i + 1];

                if (left > right) {
                    list[i] = right;
                    list[i + 1] = left;
                }
            }
        }
    }
}
