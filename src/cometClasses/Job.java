package cometClasses;

public class Job {

	private int job_id;
	private String title;
	private String description;
	private String visa_category;
	private String job_type;
	private String joining_requirement;
	private String pre_requsite;
	private int author_id;
	private String link;

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getVisa_category() {
		return visa_category;
	}

	public void setVisa_category(String visa_category) {
		this.visa_category = visa_category;
	}

	public String getJob_type() {
		return job_type;
	}

	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}

	public String getJoining_requirement() {
		return joining_requirement;
	}
	
	public void setJoining_requirement(String joining_requirement) {
		this.joining_requirement = joining_requirement;
	}

	public String getPre_requsite() {
		return pre_requsite;
	}

	public void setPre_requsite(String pre_requsite) {
		this.pre_requsite = pre_requsite;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
