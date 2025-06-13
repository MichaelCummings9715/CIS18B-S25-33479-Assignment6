package school;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TicketTest {

	public static void main(String[] args) {
		
		// set test parameters
		int totalTickets = 5;
	    int totalCustomers = 10;
	    
	    // create shared ticket pool
	    TicketPool ticketPool = new TicketPool(totalTickets);
	    
	    // thread loop
	    try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
	    	
	    	for (int i = 1; i <= totalCustomers; i++) {
                Customer customer = new Customer(ticketPool, "Customer " + i);
                
                // submit thread creation to executor for virtual thread
                executor.submit(customer);
                
	    	}
	    	
	    }
	    
	}

}
