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
    
    }
}