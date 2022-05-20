package org.kh.shareware.project.domain;

public class Project {
	 private int projectNo;
	 private String projectTitle;
	 private String projectMade;
	 private String projectMadeName;
	 private String pStartDate;
	 private String pEndDate;
	 private String pStatus;
	 private String projectContent;
	 
	 public Project() {
		 
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

	public String getProjectMadeName() {
		return projectMadeName;
	}

	public void setProjectMadeName(String projectMadeName) {
		this.projectMadeName = projectMadeName;
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
				+ ", projectMadeName=" + projectMadeName + ", pStartDate=" + pStartDate + ", pEndDate=" + pEndDate
				+ ", pStatus=" + pStatus + ", projectContent=" + projectContent + "]";
	}
	 
}
