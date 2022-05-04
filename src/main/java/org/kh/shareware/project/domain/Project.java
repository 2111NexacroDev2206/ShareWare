package org.kh.shareware.project.domain;

public class Project {
	 private int projectNo;
	 private String projectTitle;
	 private String projectMade;
	 private String pStartDate;
	 private String pEndDate;
	 private String pStatus;
	 private String projectContent;
	 
	 public Project() {
		 
	 }

	public Project(int projectNo, String projectTitle, String projectMade, String pStartDate, String pEndDate,
			String pStatus, String projectContent) {
		super();
		this.projectNo = projectNo;
		this.projectTitle = projectTitle;
		this.projectMade = projectMade;
		this.pStartDate = pStartDate;
		this.pEndDate = pEndDate;
		this.pStatus = pStatus;
		this.projectContent = projectContent;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectMade() {
		return projectMade;
	}

	public void setProjectMade(String projectMade) {
		this.projectMade = projectMade;
	}

	public String getpStartDate() {
		return pStartDate;
	}

	public void setpStartDate(String pStartDate) {
		this.pStartDate = pStartDate;
	}

	public String getpEndDate() {
		return pEndDate;
	}

	public void setpEndDate(String pEndDate) {
		this.pEndDate = pEndDate;
	}

	public String getpStatus() {
		return pStatus;
	}

	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}

	public String getProjectContent() {
		return projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}

	@Override
	public String toString() {
		return "Project [projectNo=" + projectNo + ", projectTitle=" + projectTitle + ", projectMade=" + projectMade
				+ ", pStartDate=" + pStartDate + ", pEndDate=" + pEndDate + ", pStatus=" + pStatus + ", projectContent="
				+ projectContent + "]";
	}

	

	 
}
