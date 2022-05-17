package org.kh.shareware.project.domain;

public class Work {
	private int workNo;
	private int projectNo;
	private String memNum;
	private String workWriter;
	private String workTitle;
	private String workContent;
	private String workDate;
	private int workCount;
	private String fileName;
	private String filePath;
	private String fileReName;
	private String status;
	
	public Work() {}

	public int getWorkNo() {
		return workNo;
	}

	public void setWorkNo(int workNo) {
		this.workNo = workNo;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}

	public String getWorkWriter() {
		return workWriter;
	}

	public void setWorkWriter(String workWriter) {
		this.workWriter = workWriter;
	}

	public String getWorkTitle() {
		return workTitle;
	}

	public void setWorkTitle(String workTitle) {
		this.workTitle = workTitle;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public int getWorkCount() {
		return workCount;
	}

	public void setWorkCount(int workCount) {
		this.workCount = workCount;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileReName() {
		return fileReName;
	}

	public void setFileReName(String fileReName) {
		this.fileReName = fileReName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Work [workNo=" + workNo + ", projectNo=" + projectNo + ", memNum=" + memNum + ", workWriter="
				+ workWriter + ", workTitle=" + workTitle + ", workContent=" + workContent + ", workDate=" + workDate
				+ ", workCount=" + workCount + ", fileName=" + fileName + ", filePath=" + filePath + ", fileReName="
				+ fileReName + ", status=" + status + "]";
	}
	
}
