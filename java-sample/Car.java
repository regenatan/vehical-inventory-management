import java.util.Scanner;

public class Car extends Vehical {
    
    private int doors;
    private String powerType;

    public Car (){
        super();
        this.doors = 0;
        this.powerType = "N/A";
    }

    public Car(String name, double price, String numberPlate, int doors, String powerType){
        super (name, price, numberPlate);
        this.doors = doors;
        this.powerType = powerType;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public String getPowerType() {
        return powerType;
    }

    public void setPowerType(String powerType) throws IllegalArgumentException {
        if (powerType != null && !powerType.isEmpty()){
        this.powerType = powerType; }
        else {throw new IllegalArgumentException("Power type must not be left blank.");};
    }

    public void displayNetPrice(){
        double tax = calculateSalesTax();
        double netPrice = getPrice() + tax;
        System.out.println("net price: " + netPrice);
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Number of doors: " + getDoors());
        System.out.println("Power Type: " + getPowerType());
    }

    @Override
    public void editDetails(){
        super.editDetails();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter new number of doors: ");
        int newDoors = scanner.nextInt();
        scanner.nextLine();
        this.setDoors(newDoors);

        System.out.println("Enter new power type: ");
        String newPowerType = scanner.nextLine();
        this.setPowerType(newPowerType);
    }

    
}
