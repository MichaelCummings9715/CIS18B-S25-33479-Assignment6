package school;

public class TicketPool {
	
	private int availableTickets;

    public TicketPool(int totalTickets) {
        this.availableTickets = totalTickets;
    }
    
    public synchronized Ticket reserveTicket(String customerName) {
    	
    	// loop to re-check the condition
    	while (availableTickets <= 0) {
    		System.out.println("No tickets available... waiting.");
    		try {
    			wait(); // release, sleep thread
    		} catch (InterruptedException e) {
    			System.out.println("interrupted");
    			Thread.currentThread().interrupt();
                return null;
    		}
    	}
    	
    	// decrease available tickets if ticket is taken
        availableTickets--;
        System.out.println("Tickets reserved!");
        return new Ticket(availableTickets + 1, "MainEvent");
        
    }

}
