package bookshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin extends User
{
	public void login() { System.out.println("Admin logged in."); }

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

	public void addBook(Book book) {
	    try (Connection con = DatabaseConnection.getConnection()) {
	        PreparedStatement pst = con.prepareStatement("INSERT INTO books (title, author, price, quantity) VALUES (?, ?, ?, ?)");
	        pst.setString(1, book.getTitle());
	        pst.setString(2, book.getAuthor());
	        pst.setDouble(3, book.getPrice());
	        pst.setInt(4, book.getQuantity());
	        pst.executeUpdate();
	        System.out.println("Book added successfully.");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void removeBook(int bookId) {
	    try (Connection con = DatabaseConnection.getConnection()) {
	        PreparedStatement pst = con.prepareStatement("DELETE FROM books WHERE id = ?");
	        pst.setInt(1, bookId);
	        pst.executeUpdate();
	        System.out.println("Book removed successfully.");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
