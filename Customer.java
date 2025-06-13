package school;

public class Customer implements Runnable{
	
	private final TicketPool ticketPool;
	private final String name;
	
	// constructor
	public Customer(TicketPool ticketPool, String name) {
		this.ticketPool = ticketPool;
		this.name = name;
	}
	
	@Override
	public void run() {
		//reserve ticket
		System.out.println("reserving ticket");
		Ticket ticket = ticketPool.reserveTicket(this.name);
		
		if (ticket != null) { // results
            System.out.println("Ticket purchased! : " + name + " Ticket Number: " + ticket.getId() + " for " + ticket.getEvent());
        } else {
        	 System.out.println("Purchase Failed");
        }
		
	}
	
}
