package bookshop;

public abstract class User 
{
	protected String name; 
	protected String email;
	protected int userId;

	public abstract void login();
	public abstract void viewBooks();
}
