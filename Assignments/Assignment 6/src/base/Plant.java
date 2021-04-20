package base;

// Class
public class Plant {

        boolean isPlant;
        boolean needsWatering;
        String plantFamily;
        String name;
        boolean needsSunlight;

        // Constructor
        public Plant(boolean needsWatering, String plantFamily, String name, boolean needsSunlight) {
            this.isPlant = true;
            this.needsWatering = needsWatering;
            this.plantFamily = plantFamily;
            this.name = name;
            this.needsSunlight = needsSunlight;
        }

        // Method
        public void wateringInstructions () {
            if (this.needsWatering == true) {
                System.out.println("The " + this.name + " needs more water.");
            }
            else {
                System.out.println("The " + this.name + " has gotten enough water.");
            }
        }

        // Method
        public void sunlightRequirements () {
            if (this.needsSunlight == true) {
                System.out.println("The " + this.name + " needs more sunlight.");
            }
            else {
                System.out.println("The " + this.name + " has gotten enough sunlight.");
            }
        }
}
