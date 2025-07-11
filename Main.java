package bookshop;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Online Book Shop");
		System.out.println("Login as:\n1. Admin\n2. Customer"); 
		int choice = sc.nextInt();

		if (choice == 1) {
		        Admin admin = new Admin();
		        admin.login();
		        
		        while (true) {
	                System.out.println("\n--- Admin Menu ---");
	                System.out.println("1. View all books");
	                System.out.println("2. Add a book");
	                System.out.println("3. Remove a book");
	                System.out.println("4. Exit");
	                System.out.print("Enter your choice: ");
	                int adminChoice = sc.nextInt();

	                switch (adminChoice) {
	                    case 1:
	                        admin.viewBooks();
	                        break;

	                    case 2:
	                        System.out.print("Enter book title: ");
	                        sc.nextLine(); // consume newline
	                        String title = sc.nextLine();

	                        System.out.print("Enter author name: ");
	                        String author = sc.nextLine();

	                        System.out.print("Enter price: ");
	                        double price = sc.nextDouble();

	                        System.out.print("Enter quantity: ");
	                        int quantity = sc.nextInt();

	                        Book newBook = new Book(0, title, author, price, quantity);
	                        admin.addBook(newBook);
	                        break;

	                    case 3:
	                        System.out.print("Enter book ID to remove: ");
	                        int removeId = sc.nextInt();
	                        admin.removeBook(removeId);
	                        break;

	                    case 4:
	                        System.out.println("Exiting admin menu.");
	                        return;

	                    default:
	                        System.out.println("Invalid choice.");
	                }
	            }
		    } else if (choice == 2) {
		        Customer customer = new Customer();
		        customer.login();
		       
		        while (true) {
	                System.out.println("\n--- Customer Menu ---");
	                System.out.println("1. View available books");
	                System.out.println("2. Buy a book");
	                System.out.println("3. Exit");
	                System.out.print("Enter your choice: ");
	                int custChoice = sc.nextInt();

	                switch (custChoice) {
	                    case 1:
	                        customer.viewBooks();
	                        break;

	                    case 2:
	                        System.out.print("Enter book ID to buy: ");
	                        int bookId = sc.nextInt();

	                        System.out.print("Enter quantity: ");
	                        int qty = sc.nextInt();

	                        OrderThread thread = new OrderThread(customer, bookId, qty);
	                        thread.start();
	                        try {
	                            thread.join(); // wait for thread to complete
	                        } catch (InterruptedException e) {
	                            e.printStackTrace();
	                        }
	                        break;

	                    case 3:
	                        System.out.println("Exiting customer menu.");
	                        return;

	                    default:
	                        System.out.println("Invalid choice.");
	                }
	            }
		    } else {
		        System.out.println("Invalid login type.");
		    }

		    sc.close();
		}


	}


