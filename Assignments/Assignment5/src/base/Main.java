package base;

public class Main {
    /**
     * In our Assignment here we're running a little lemonade stand and we also sell pretzels. We need to keep track of
     * our inventory as well as the money that we're making throughout the day. I have code in the wet code section that
     * keeps track of all of this poorly. Come up with a better way to manage our system. There's not just one way to do
     * this so get creative and most importantly remember to stay DRY!
     *
     * We're gonna look at the first hour where we have 15 customers!
     *
     * We're responsible for keeping track of the number of pretzels and lemonades sold as well as the cash on hand and
     * in the tip jar! To keep things easy I won't make you make change! At the end of the day tips are split among the
     * employees! That means DON'T add it to the cash at the end of the day or during a transaction
     *
     * At the end we're going to print out our inventory left and how much we made in case for the day! Print out the
     * tips too!
     *
     * Remember to use functions, variables, and whatever else would make this easier to maintain!
     *
     * Pretzels are $2 for 1
     * Lemonade is $8 for 1
     */
    static int lemonades_available = 43;
    static int pretzels_available = 60;
    static double cash = 1500.0;
    static double tips = 0.0;

    static int pretzelPrice = 2;
    static int lemonadePrice = 8;

    public static void customer (int pretzelsOrdered, int lemonadesOrdered, int tipPaid) {

        pretzels_available = pretzels_available - pretzelsOrdered;
        int pretzelCost = pretzelsOrdered * pretzelPrice;
        cash = cash + pretzelCost;

        lemonades_available = lemonades_available - lemonadesOrdered;
        int lemonadeCost = lemonadesOrdered * lemonadePrice;
        cash = cash + lemonadeCost;

        tips = tips + tipPaid;

    }


    public static void main(String[] args) {
        //	Replace this with your dry inventory function!
        dry_inventory();
        // next
    }

    static void dry_inventory() {

        // Customer 1
        customer(4, 1, 4);

        //Customer 2
        customer(2, 3, 0);

        //Customer 3
        customer(3, 0, 0);

        //Customer 4
        customer(1, 2, 0);

        //Customer 5
        customer(0, 6, 10);

        //Customer 6
        customer(0, 4, 5);

        //Customer 7
        customer(2, 0, 0);

        //Customer 8
        customer(10, 8, 10);

        //Customer 9
        customer(6, 0, 0);

        //Customer 10
        customer(0, 1, 0);

        //Customer 11
        customer(1, 0, 0);

        //Customer 12
        customer(0, 7, 4);

        //Customer 13
        customer(2, 0, 0);

        //Customer 14
        customer(6, 3, 0);

        //Customer 15
        customer(9, 2, 3);

        System.out.println("Results for the hour!");
        System.out.println("Lemonades Inventory: " + lemonades_available);
        System.out.println("Pretzels Inventory: " + pretzels_available);
        System.out.println("Cash: " + cash);
        System.out.println("Tips: " + tips);


    }

    static void wet_inventory() {
        /**
         * We have 10 customers in the first hour! This is what they bought! When running this with your dry code you
         * don't want to run this function because then the numbers in the end will be wrong!
         */
        //Customer 1
        pretzels_available -= 4;
        cash += 8;
        lemonades_available -= 1;
        cash += 8;
        tips += 4;

        //Customer 2
        pretzels_available -= 2;
        cash += 4;
        lemonades_available -= 3;
        cash += 24;

        //Customer 3
        pretzels_available -= 3;
        cash += 6;

        //Customer 4
        pretzels_available -= 1;
        cash += 2;
        lemonades_available -= 2;
        cash += 16;

        //Customer 5
        lemonades_available -= 6;
        cash += 48;
        tips += 10;

        //Customer 6
        lemonades_available -= 4;
        cash += 32;
        tips += 5;

        //Customer 7
        pretzels_available -= 2;
        cash += 4;

        //Customer 8
        pretzels_available -= 10;
        cash += 20;
        lemonades_available -= 8;
        cash += 64;
        tips += 10;

        //Customer 9
        pretzels_available -= 6;
        cash += 12;

        //Customer 10
        lemonades_available -= 1;
        cash += 8;

        //Customer 11
        pretzels_available -= 1;
        cash += 2;

        //Customer 12
        lemonades_available -= 7;
        cash += 56;
        tips += 4;

        //Customer 13
        pretzels_available -= 2;
        cash += 4;

        //Customer 14
        pretzels_available -= 6;
        cash += 12;
        lemonades_available -= 3;
        cash += 24;

        //Customer 15
        pretzels_available -= 9;
        cash += 18;
        lemonades_available -= 2;
        cash += 16;
        tips += 3;
        customer(9, 2, 3);

        System.out.println("Results for the hour!");
        System.out.println("Lemonades Inventory: " + lemonades_available);
        System.out.println("Pretzels Inventory: " + pretzels_available);
        System.out.println("Cash: " + cash);
        System.out.println("Tips: " + tips);
    }
}
