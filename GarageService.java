import java.util.*;

public class GarageService {
    private Map<String,Customer> customerMap;
    private List<Service> avaibleService;

    public GarageService() {
        this.customerMap = new HashMap<>(); //Just initializing Empty Map.
        this.avaibleService = new ArrayList<>(); //Just initializing the available services list
        loadService();
    }

    public void loadService(){

        avaibleService.add(new Service("Car Washing",500));
        avaibleService.add(new Service("Oil Change",700));
        avaibleService.add(new Service("Wheel Allignment",300));
        avaibleService.add(new Service("Tyre replacement",3000));
        avaibleService.add(new Service("Punture ",100));
    }

    public void addCustomer(String name,String phone,String carNumber,String model){
        Car car = new Car(carNumber,model);
        Customer customer = new Customer(name,phone,car);
        customerMap.put(carNumber,customer);
        System.out.println("Customer Added Successfully!!!");
    }


    public void createInvoice(String carNumber){
        if(!customerMap.containsKey(carNumber)){
            System.out.println("No customer found.with car Number"+carNumber);
            return;
        }

        Scanner sc = new Scanner(System.in);
        Customer customer = customerMap.get(carNumber);
        Invoice invoice = new Invoice(customer); //IMPORTANT STEP REVISE THIS


        System.out.println("Available Services");
        for (int i = 0; i < avaibleService.size(); i++){
            System.out.println((i+1)+". "+avaibleService.get(i).getServiceName()+"- $"
                    +avaibleService.get(i).getPrice());
        }
        while (true)
        {
            System.out.println("Enter service number to add or 0 -> finish");
            int choice = sc.nextInt();

            if(choice == 0) break;

            if(choice > 0 && choice <= avaibleService.size()){

            invoice.addService(avaibleService.get(choice - 1));
                System.out.println("Service Done");
            }
            else{
                System.out.println("Invalid Choice..");
            }
        }
        invoice.printInvoice();
    }
}
