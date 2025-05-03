import java.util.Scanner;

public class Motorcycle extends Vehical {

        private String engineType;
        private Boolean hasSideCar;

        public Motorcycle(){
            super();
            this.engineType = "N/A";
            this.hasSideCar = false;
        }

        public Motorcycle(String name, double price, String numberPlate, String engineType, boolean hasSideCar){
            super(name, price, numberPlate);
            this.engineType = engineType;
            this.hasSideCar = hasSideCar;
        }

        public String getEngineType() {
            return engineType;
        }
        
        public void setEngineType(String engineType) {
            this.engineType = engineType;
        }

        public Boolean getHasSideCar() {
            return hasSideCar;
        }
        
        public void setHasSideCar(Boolean hasSideCar) {
            this.hasSideCar = hasSideCar;
        }

        public void displayNetPrice(){
            double tax = calculateSalesTax();
            double netPrice = getPrice() + tax;
            System.out.println("Net price: " + netPrice);

        }

        public void displayDetails(){
            super.displayDetails();
            System.out.println("Engine Type: " + getEngineType());
            System.out.println("Has sidecar: " + getHasSideCar());
        }

        public void editDetails(){
            super.editDetails();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter new engine type: ");
            String newEngineType = scanner.nextLine();
            this.setEngineType(newEngineType);

            System.out.println("Enter if there is still side car: ");
            boolean newHasSideCar = scanner.nextBoolean();
            this.setHasSideCar(newHasSideCar);
        }
}