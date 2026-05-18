import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class AutomobileInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            Automobile car = new Automobile("Toyota", "Camry", "Blue", 2023, 15000);
            
            System.out.println("=== Initial Vehicle ===");
            printVehicleInfo(car.listVehicleInformation());

            System.out.println("\n" + car.removeVehicle());

            System.out.println("\n" + car.addNewVehicle("Honda", "Civic", "Red", 2022, 25000));
            printVehicleInfo(car.listVehicleInformation());

            System.out.println("\n" + car.updateVehicleAttributes("Honda", "Accord", "Black", 2024, 8000));
            printVehicleInfo(car.listVehicleInformation());

            System.out.print("\nWould you like to save this information to a file? (Y/N): ");
            String response = scanner.nextLine().trim().toUpperCase();

            if (response.equals("Y")) {
                saveToFile(car);
                System.out.println("Information saved to C:\\Temp\\Autos.txt");
            } else {
                System.out.println("File will not be printed.");
            }

        } catch (Exception e) {
            System.out.println("Program error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void printVehicleInfo(String[] info) {
        for (String line : info) {
            System.out.println(line);
        }
    }

    private static void saveToFile(Automobile car) {
        try (PrintWriter writer = new PrintWriter(new File("C:\\Temp\\Autos.txt"))) {
            String[] info = car.listVehicleInformation();
            for (String line : info) {
                writer.println(line);
            }
            writer.println("File saved on: " + new java.util.Date());
        } catch (Exception e) {
            System.out.println("Failed to save file: " + e.getMessage());
        }
    }
}