package base;

public class Main {

    public static void main(String[] args) {

        int linearTerm = fibonacciLinear(7, 0, 1);
        System.out.println("Linear Term: " + linearTerm);

        int headTerm = fibonacciHead(7);
        System.out.println("Head End Term: " + headTerm);

        int tailTerm = fibonacciTail(7);
        System.out.println("Tail End Term: " + tailTerm);
    }

    // Linear recursion
    public static int fibonacciLinear (int term, int x, int y) {
        if (term == 0) {
            return x;
        }
        else if (term == 1) {
            return y;
        }
        else
            return fibonacciLinear(term - 1, y, x + y);
    }

    // Head end recursion
    public static int fibonacciHead (int term) {
        if (term > 1) {
            return fibonacciHead(term - 1) + fibonacciHead(term - 2);
        }
        else if (term == 1) {
            return term;
        }
        else {
            return 0;
        }
    }

    // Tail End recursion
    public static int fibonacciTail (int term) {
        if (term == 0 ) {
            return term;
        }
        else if (term == 1) {
            return term;
        }
        else
            return fibonacciTail(term - 1) + fibonacciTail(term - 2);
    }

}
