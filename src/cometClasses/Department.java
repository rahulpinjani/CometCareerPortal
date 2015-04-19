package cometClasses;


public class Department implements JobService
{
	private int departmentID;
	private String departmentName;
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void reviewProfile()
	{
		return;
	}
	
	public void reviewJobPost()
	{
		return;
	}

	@Override
	public void postJob()
	{
		return;
	}

	@Override
	public void searchProfile()
	{
		return;
	}

	public int getDepartmentID() 
	{
		return departmentID;
	}

	public void setDepartmentID(int departmentID) 
	{
		this.departmentID = departmentID;
	}

	public String getDepartmentName()
	{
		return departmentName;
	}

	public void setDepartmentName(String departmentName)
	{
		this.departmentName = departmentName;
	}
}
