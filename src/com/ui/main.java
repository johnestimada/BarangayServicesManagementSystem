import com.barangay.models.Resident;
import com.barangay.models.DocumentRequest;
import com.barangay.models.ClearanceRequest;
import com.barangay.services.ResidentService;
import com.barangay.services.RequestDispatcherService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResidentService residentService = new ResidentService();
        RequestDispatcherService dispatcher = new RequestDispatcherService();

        MenuNavigator.showMainMenu();
        int choice = sc.nextInt(); 

         switch (choice) {
            case 1 -> {
                Resident r = new Resident("Juan", 25);
                residentService.registerResident(r);
                System.out.println("Registered: " + r);
            }
            case 2 -> {
                DocumentRequest d = new DocumentRequest();
                dispatcher.addRequest(d);
                d.process();
                System.out.println("Document status: " + d.getStatus());
            }
            case 3 -> {
                ClearanceRequest c = new ClearanceRequest();
                dispatcher.addRequest(c);
                c.process();
                System.out.println("Clearance status: " + c.getStatus());
            }
            default -> System.out.println("Invalid choice");
        }
    
    }
}