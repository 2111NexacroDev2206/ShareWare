package org.kh.shareware.project.domain;

public class Important {
	public int importantNo;
	public int projectNo;
	public String memNum;
	public String importantWriter;
	public String importantTitle;
	public String importantContent;
	public String importantDate;
	public int importantCount;
	public String fileName;
	public String filePath;
	public String fileReName;
	
	public Important() {}

	@Override
	public String toString() {
		return "Important [importantNo=" + importantNo + ", projectNo=" + projectNo + ", memNum=" + memNum
				+ ", importantWriter=" + importantWriter + ", importantTitle=" + importantTitle + ", importantContent="
				+ importantContent + ", importantDate=" + importantDate + ", importantCount=" + importantCount
				+ ", fileName=" + fileName + ", filePath=" + filePath + ", fileReName=" + fileReName + "]";
	}

	public int getImportantNo() {
		return importantNo;
	}

	public void setImportantNo(int importantNo) {
		this.importantNo = importantNo;
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

	public String getImportantWriter() {
		return importantWriter;
	}

	public void setImportantWriter(String importantWriter) {
		this.importantWriter = importantWriter;
	}

	public String getImportantTitle() {
		return importantTitle;
	}

	public void setImportantTitle(String importantTitle) {
		this.importantTitle = importantTitle;
	}

	public String getImportantContent() {
		return importantContent;
	}

	public void setImportantContent(String importantContent) {
		this.importantContent = importantContent;
	}

	public String getImportantDate() {
		return importantDate;
	}

	public void setImportantDate(String importantDate) {
		this.importantDate = importantDate;
	}

	public int getImportantCount() {
		return importantCount;
	}

	public void setImportantCount(int importantCount) {
		this.importantCount = importantCount;
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

	public Important(int importantNo, int projectNo, String memNum, String importantWriter, String importantTitle,
			String importantContent, String importantDate, int importantCount, String fileName, String filePath,
			String fileReName) {
		super();
		this.importantNo = importantNo;
		this.projectNo = projectNo;
		this.memNum = memNum;
		this.importantWriter = importantWriter;
		this.importantTitle = importantTitle;
		this.importantContent = importantContent;
		this.importantDate = importantDate;
		this.importantCount = importantCount;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileReName = fileReName;
	}
	
	
}
