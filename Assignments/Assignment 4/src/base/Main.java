package base;

public class Main {

    public static void main(String[] args) {
	int[] array = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	System.out.println(summation(array));
    }

    static int summation(int[] array) {
    int total = 0;
    for (int number: array) {
        total += number;
    }

    return total;
    }
}
