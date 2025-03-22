import java.util.ArrayList;
import java.util.List;

public class Invoice
{
private Customer customer;
private Car car;

private List<Service> serviceList;
private double totalAmt;

    public Invoice(Customer name) {
        this.customer = name;
        this.serviceList = new ArrayList<>();
        this.totalAmt = 0;
    }

    public void addService(Service service){
        serviceList.add(service);
        totalAmt+=service.getPrice();
    }

    public void printInvoice(){
        System.out.println("----------------------------Invoice----------------------------");
        System.out.println("Name: "+customer.getName()+" | Phone: "+customer.getPhone());
        System.out.println("Car: "+ customer.getCar().getModel()+"| Car Number: "+customer.getCar().getCarNumber());

        System.out.println("Services");
        for (Service service:serviceList){
            System.out.println("# "+service.getServiceName()+" $"+service.getPrice());

        }
        System.out.println("Total Amount: $"+totalAmt);
        System.out.println("-------------THANK YOU--------------");
    }
}