public class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    // Default Constructor
    public Automobile() {
        try {
            this.make = "Unknown";
            this.model = "Unknown";
            this.color = "Unknown";
            this.year = 0;
            this.mileage = 0;
        } catch (Exception e) {
            System.out.println("Failure: " + e.getMessage());
        }
    }

    // Parameterized Constructor
    public Automobile(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
        } catch (Exception e) {
            System.out.println("Failure: " + e.getMessage());
        }
    }

    // Add a new vehicle
    public String addNewVehicle(String make, String model, String color, int year, int mileage) {
        try {
            if (make == null || model == null || color == null || year < 1900 || mileage < 0) {
                throw new IllegalArgumentException("Invalid vehicle data");
            }
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Vehicle successfully added to inventory.";
        } catch (Exception e) {
            return "Failed to add vehicle: " + e.getMessage();
        }
    }

    // List vehicle information (returns String array)
    public String[] listVehicleInformation() {
        try {
            String[] info = new String[5];
            info[0] = "Make: " + this.make;
            info[1] = "Model: " + this.model;
            info[2] = "Color: " + this.color;
            info[3] = "Year: " + this.year;
            info[4] = "Mileage: " + this.mileage + " miles";
            return info;
        } catch (Exception e) {
            return new String[]{"Error retrieving vehicle information."};
        }
    }

    // Remove vehicle
    public String removeVehicle() {
        try {
            this.make = "Unknown";
            this.model = "Unknown";
            this.color = "Unknown";
            this.year = 0;
            this.mileage = 0;
            return "Vehicle successfully removed.";
        } catch (Exception e) {
            return "Failed to remove vehicle: " + e.getMessage();
        }
    }

    // Update vehicle attributes
    public String updateVehicleAttributes(String newMake, String newModel, String newColor, int newYear, int newMileage) {
        try {
            if (newMake == null || newModel == null || newColor == null || newYear < 1900 || newMileage < 0) {
                throw new IllegalArgumentException("Invalid update data");
            }
            this.make = newMake;
            this.model = newModel;
            this.color = newColor;
            this.year = newYear;
            this.mileage = newMileage;
            return "Vehicle attributes successfully updated.";
        } catch (Exception e) {
            return "Failed to update vehicle: " + e.getMessage();
        }
    }
}