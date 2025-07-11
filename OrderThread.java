package bookshop;

public class OrderThread extends Thread
{
	 private Customer customer; private int bookId; private int quantity;

	 public OrderThread(Customer customer, int bookId, int quantity) {
	     this.customer = customer;
	     this.bookId = bookId;
	     this.quantity = quantity;
	 }

	 public void run() {
	     synchronized (this) {
	         customer.placeOrder(bookId, quantity);
	     }
	 }

}
