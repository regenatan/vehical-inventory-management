import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Vehical> vehicalList = new ArrayList<>();
    private static List<Insurance> insuranceList = new ArrayList<>();
    private static Scanner scanner;

    public static void main(String[] args) {

      scanner = new Scanner(System.in);

      do {
        int choice = displayMenu();
        if (choice == 1) {
          addNewVehicle();
        } else if (choice == 2){
          displayVehicals();
        }
        else if (choice == 3){
            addInsurance();
        }
        else if (choice ==4){
          displayInsurances();
        }
        else if (choice == 5){
          break;
        } else {System.out.println("Invalid choice.");}
     } while (true);
   }

     
       private static int displayMenu() {
         int choice = 0;
     
         while (true) {
           System.out.println("Menu:");
           System.out.println("1. Add a vehical");
           System.out.println("2. List all vehicals");
           System.out.println("3. Add a insurance");
           System.out.println("4. List all insurances");
           System.out.println("5. Exit");
           System.out.print("Enter your choice: ");
           choice = scanner.nextInt();
           scanner.nextLine();
           if (choice >= 1 && choice <=5) {
               break;
             }    
           }
         return choice;
        }

        public static void addInsurance(){
          System.out.println("Enter insurance type:");
          String type = scanner.nextLine();
          System.out.println("Enter insurance cost:");
          double cost = scanner.nextDouble();
          scanner.nextLine();

          Insurance newInsurance = new Insurance(type, cost);
          insuranceList.add(newInsurance);

          System.out.println("Insurance added successfully!");
        }

        public static void displayInsurances(){
          System.out.println("Insurance list:");
          for(Insurance insurance : insuranceList){
            System.out.println("Type: " + insurance.getType());
            System.out.println("Cost: $" + insurance.getCost());
            System.out.println(("Sales tax: $" + insurance.calculateSalesTax()));
            System.out.println("---------------------------");

          }
        }

        private static void displayTaxableItems() {
          ArrayList<ITaxable> taxableItems = new ArrayList<>();
        

          for (Vehical vehical : vehicalList) {
            taxableItems.add(vehical);
          }

          for (Insurance insurance : insuranceList) {
            taxableItems.add(insurance);
          }

          System.out.println("Taxable Items:");
          for (ITaxable item : taxableItems) {   
            System.out.println("Sales Tax: $" + item.calculateSalesTax());
            System.out.println("----------------------");
          }
        }
        

         private static void addNewVehicle() {

            System.out.print("Enter vehical name: ");
            String name = scanner.nextLine();
            System.out.print("Enter vehical price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // consume the newline character in the buffer
            System.out.print("Enter number plate:");
            String numberPlate = scanner.nextLine();

            while (true){
              System.out.println("Please select vehical type:");
              System.out.println("Enter 1 for Cars");
              System.out.println("Enter 2 for Motorcycles");
              int choice = scanner.nextInt();
              scanner.nextLine();

              if (choice == 1){
                System.out.println("Please enter the number of doors the car has:");
                int doors = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Please enter the car's power type: (hybrid, electric, fuel)");
                String powerType = scanner.nextLine();

                Car car= new Car(name, price, numberPlate, doors, powerType);
                vehicalList.add(car);
                System.out.println("Car added to the vehical list!");
                break;
              }

              else if (choice == 2){
                System.out.println("Please enter the engine type:");
                String engineType = scanner.nextLine();
                System.out.println("Please enter if there is sidecar (true/false):");
                boolean hasSideCar = scanner.nextBoolean();

                Motorcycle motorcycle = new Motorcycle(name, price, numberPlate, engineType, hasSideCar);
                vehicalList.add(motorcycle);
                System.out.println("Motorcycle added to vehical list!");
                break;

              } else {System.out.println("Invalid choice. Please try again.");};

            }
          
         }

        
         private static void displayVehicals(){
          for (int i = 0; i < vehicalList.size(); i ++){
            Vehical v = vehicalList.get(i);
            System.out.println("Vehical #" + i);
            v.displayDetails();
            System.out.println();
          }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose an option:");
            System.out.println("1. Exit.");
            System.out.println("2. Edit a vehical.");
            System.out.println("3. Delete a vehical.");
            int option = scanner.nextInt();
            scanner.nextLine();

            if(option == 2){
              System.out.println("Enter index of vehical to edit:");
              int index = scanner.nextInt();
              if (index >= 0 && index < vehicalList.size()){
                Vehical vehicalToEdit = vehicalList.get(index);
                editVehical(vehicalToEdit);
              } else {
                System.out.println("Invalid index");
              }
            } else if (option == 3){
              System.out.println("Enter the index you want to delete.");
              int index = scanner.nextInt();
              if (index >= 0 && index < vehicalList.size()){
                vehicalList.remove(index);
                System.out.println("Vehical deleted.");
              } 
              else if (option == 1) {
                return;} 
                
                else {System.out.println("Invalid index.");}
            } 
         }

         public static void editVehical (Vehical v){
          v.editDetails();
         }

}