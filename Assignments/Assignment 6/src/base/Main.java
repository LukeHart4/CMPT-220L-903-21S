package base;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Plant cactus = new Plant(true, "succulent", "cactus");
        cactus.wateringInstructions();
        cactus.sunlightRequirements();
    }
}
