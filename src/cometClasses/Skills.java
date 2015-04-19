package cometClasses;

import java.util.ArrayList;


public class Skills
{
	private String skillName;
	private int yearsOfExp;
	private int proficiency; //proficiency is the rating out of 5



	public void addNewSkill()
	{
		return;
	}
	
	public boolean removeSkill()
	{
		return true;
	}

	public String getSkillName() 
	{
		return skillName;
	}

	public void setSkillName(String skillName) 
	{
		this.skillName = skillName;
	}

	public int getYearsOfExp()
	{
		return yearsOfExp;
	}

	public void setYearsOfExp(int yearsOfExp) 
	{
		this.yearsOfExp = yearsOfExp;
	}

	public int getProficiency() 
	{
		return proficiency;
	}

	public void setProficiency(int proficiency) 
	{
		this.proficiency = proficiency;
	}
}
