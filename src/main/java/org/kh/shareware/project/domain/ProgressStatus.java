package org.kh.shareware.project.domain;

public class ProgressStatus {
	private int pgsNo;
	private String projectNo;
	private String memNum;
	private String pgsWriter;
	private String pgsTitle;
	private String pgsContent;
	private String pgsDate;
	private String fileName;
	private String filePath;
	private String fileReName;
	private int pgsCount;
	
	public ProgressStatus() {}

	public ProgressStatus(int pgsNo, String projectNo, String memNum, String pgsWriter, String pgsTitle,
			String pgsContent, String pgsDate, String fileName, String filePath, String fileReName, int pgsCount) {
		super();
		this.pgsNo = pgsNo;
		this.projectNo = projectNo;
		this.memNum = memNum;
		this.pgsWriter = pgsWriter;
		this.pgsTitle = pgsTitle;
		this.pgsContent = pgsContent;
		this.pgsDate = pgsDate;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileReName = fileReName;
		this.pgsCount = pgsCount;
	}

	public int getPgsNo() {
		return pgsNo;
	}

	public void setPgsNo(int pgsNo) {
		this.pgsNo = pgsNo;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}

	public String getPgsWriter() {
		return pgsWriter;
	}

	public void setPgsWriter(String pgsWriter) {
		this.pgsWriter = pgsWriter;
	}

	public String getPgsTitle() {
		return pgsTitle;
	}

	public void setPgsTitle(String pgsTitle) {
		this.pgsTitle = pgsTitle;
	}

	public String getPgsContent() {
		return pgsContent;
	}

	public void setPgsContent(String pgsContent) {
		this.pgsContent = pgsContent;
	}

	public String getPgsDate() {
		return pgsDate;
	}

	public void setPgsDate(String pgsDate) {
		this.pgsDate = pgsDate;
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

	public int getPgsCount() {
		return pgsCount;
	}

	public void setPgsCount(int pgsCount) {
		this.pgsCount = pgsCount;
	}

	@Override
	public String toString() {
		return "ProgressStatus [pgsNo=" + pgsNo + ", projectNo=" + projectNo + ", memNum=" + memNum + ", pgsWriter="
				+ pgsWriter + ", pgsTitle=" + pgsTitle + ", pgsContent=" + pgsContent + ", pgsDate=" + pgsDate
				+ ", fileName=" + fileName + ", filePath=" + filePath + ", fileReName=" + fileReName + ", pgsCount="
				+ pgsCount + "]";
	}

	
	
}
