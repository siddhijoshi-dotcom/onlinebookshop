package bookshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Customer extends User
{
	public void login() { System.out.println("Customer logged in."); }

	public void viewBooks() {
	    try (Connection con = DatabaseConnection.getConnection()) {
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM books");
	        while (rs.next()) {
	            System.out.println(rs.getInt("id") + ". " + rs.getString("title") + " - Rs. " + rs.getDouble("price"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void placeOrder(int bookId, int quantity) {
	    try (Connection con = DatabaseConnection.getConnection()) {
	        PreparedStatement pst = con.prepareStatement("UPDATE books SET quantity = quantity - ? WHERE id = ? AND quantity >= ?");
	        pst.setInt(1, quantity);
	        pst.setInt(2, bookId);
	        pst.setInt(3, quantity);
	        int rows = pst.executeUpdate();
	        if (rows > 0) {
	            System.out.println("Order placed successfully.");
	        } else {
	            System.out.println("Order failed: Not enough stock.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}
