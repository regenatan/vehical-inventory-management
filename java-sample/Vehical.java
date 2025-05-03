import java.util.Scanner;

public class Vehical implements ITaxable{
    
    private String name;
    private double price;
    private String numberPlate;

    public Vehical(){
        this.name = "N/A";
        this.price = 0.0;
        this.numberPlate = "N/A";
    }

    public Vehical(String name, double price, String numberPlate){
        this.name = name;
        this.price = price;
        this.numberPlate = numberPlate;
    }

    public void setName (String name) throws IllegalArgumentException {
        if (name != null && !name.isEmpty()){
            this.name = name;
        } else { throw new IllegalArgumentException("Invalid name. Do not leave blank.");}
    }

    public void setPrice(double price) throws IllegalArgumentException {
        if (price >= 0) {
          this.price = price;
        } else {
          throw new IllegalArgumentException("Invalid price. Please provide a non-negative value.");
        }
      }

     public void setNumberPlate(String numberPlate) throws IllegalArgumentException {
        if (numberPlate != null && !numberPlate.isEmpty()) {
            this.numberPlate = numberPlate;
        } else {
            throw new IllegalArgumentException("Invalid number plate. Do not leave blank.");
        }
     }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    
    public double calculateSalesTax(){
        double taxPercentage = 0.1;
        return getPrice()*taxPercentage;
    }

    public void displayDetails(){
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Number Plate: " + getNumberPlate());

    }

    public void editDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new name:");
        String newName = scanner.nextLine();
        this.setName(newName);

        System.out.println("Enter new price: $");
        double newPrice = scanner.nextInt();
        scanner.nextLine();
        this.setName(newName);

        System.out.println("Enter new number plate:");
        String newNumberPlate = scanner.nextLine();
        this.setNumberPlate(newNumberPlate);
    }


}
