package cometClasses;

public class Project
{
	private int projectID;
	private String projectTitle;
	private String projectDescription;
	private String progLanguage; // programming language
	private String databaseUsed;
	private String projectDomain;
	private int teamSize;
	
	public void addNewProject()
	{
		return;
	}
	
	public boolean removeProject()
	{
		return true;
	}
	
	public boolean modifyProjectDetails()
	{
		return true;
	}

	public int getProjectID()
	{
		return projectID;
	}

	public void setProjectID(int projectID)
	{
		this.projectID = projectID;
	}

	public String getProjectTitle()
	{
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) 
	{
		this.projectTitle = projectTitle;
	}

	public String getProjectDescription() 
	{
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) 
	{
		this.projectDescription = projectDescription;
	}

	public String getProgLanguage() 
	{
		return progLanguage;
	}

	public void setProgLanguage(String progLanguage) 
	{
		this.progLanguage = progLanguage;
	}

	public String getDatabaseUsed() 
	{
		return databaseUsed;
	}

	public void setDatabaseUsed(String databaseUsed) 
	{
		this.databaseUsed = databaseUsed;
	}

	public String getProjectDomain() 
	{
		return projectDomain;
	}

	public void setProjectDomain(String projectDomain)
	{
		this.projectDomain = projectDomain;
	}

	public int getTeamSize() 
	{
		return teamSize;
	}

	public void setTeamSize(int teamSize) 
	{
		this.teamSize = teamSize;
	}
}
