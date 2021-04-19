package base;

public class Plant {

        boolean isPlant;
        boolean needsWatering;
        String plantFamily;
        String name;

        public Plant(boolean needsWatering, String plantFamily, String name) {
            System.out.println("The Plant Constructor Ran.");
            this.isPlant = true;
            this.needsWatering = needsWatering;
            this.plantFamily = plantFamily;
            this.name = name;
        }
        public void wateringInstructions () {
            if (this.needsWatering == true) {
                System.out.println("The " + this.name + " needs water to survive.");
            }
            else {
                System.out.println("The " + this.name + " does not need to be watered.");
            }
        }
        public void sunlightRequirements () {
            System.out.println("All plants need sunlight!");
        }
}
