import java.util.Scanner;

public class GarageBillingApp {

    public static void main(String[] args) {
        GarageService garageService = new GarageService();
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------Shivam Car Service Centre-----------------------------------");

        while (true) {
            System.out.println("1.Add Customer..");
            System.out.println("2.Create invoice");
            System.out.println("3.Exit");

            System.out.println("Enter Your Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter Customer Name: ");
                    String name = sc.next();
                    System.out.println("Enter Phone Number: ");
                    String phone = sc.next();
                    System.out.println("Enter car Number: ");
                    String carNum = sc.next();
                    System.out.println("Enter car model");
                    String model = sc.next();
                    garageService.addCustomer(name,phone,carNum,model);
                    break;

                case 2:
                    System.out.println("Enter car Number");
                    String carNo = sc.next();
                    garageService.createInvoice(carNo);
                    break;

                case 3:
                    System.out.println("Exiting .......Thank You");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice..Try Again");
            }
        }
    }
}