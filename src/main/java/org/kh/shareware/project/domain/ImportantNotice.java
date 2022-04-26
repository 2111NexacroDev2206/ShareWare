package org.kh.shareware.project.domain;

public class ImportantNotice {
	private int inoticeNo;
	private int projectNo;
	private String memNum;
	private String inoticeWriter;
	private String inoitceTitle;
	private String inoticeContent;
	private String inoticeDate;
	private int inoticeCount;
	private String fileName;
	private String filePath;
	private String fileReName;
	
	public ImportantNotice() {
		
	}

	public ImportantNotice(int inoticeNo, int projectNo, String memNum, String inoticeWriter, String inoitceTitle,
			String inoticeContent, String inoticeDate, int inoticeCount, String fileName, String filePath,
			String fileReName) {
		super();
		this.inoticeNo = inoticeNo;
		this.projectNo = projectNo;
		this.memNum = memNum;
		this.inoticeWriter = inoticeWriter;
		this.inoitceTitle = inoitceTitle;
		this.inoticeContent = inoticeContent;
		this.inoticeDate = inoticeDate;
		this.inoticeCount = inoticeCount;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileReName = fileReName;
	}

	public int getInoticeNo() {
		return inoticeNo;
	}

	public void setInoticeNo(int inoticeNo) {
		this.inoticeNo = inoticeNo;
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

	public String getInoticeWriter() {
		return inoticeWriter;
	}

	public void setInoticeWriter(String inoticeWriter) {
		this.inoticeWriter = inoticeWriter;
	}

	public String getInoitceTitle() {
		return inoitceTitle;
	}

	public void setInoitceTitle(String inoitceTitle) {
		this.inoitceTitle = inoitceTitle;
	}

	public String getInoticeContent() {
		return inoticeContent;
	}

	public void setInoticeContent(String inoticeContent) {
		this.inoticeContent = inoticeContent;
	}

	public String getInoticeDate() {
		return inoticeDate;
	}

	public void setInoticeDate(String inoticeDate) {
		this.inoticeDate = inoticeDate;
	}

	public int getInoticeCount() {
		return inoticeCount;
	}

	public void setInoticeCount(int inoticeCount) {
		this.inoticeCount = inoticeCount;
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

	@Override
	public String toString() {
		return "ImportantNotice [inoticeNo=" + inoticeNo + ", projectNo=" + projectNo + ", memNum=" + memNum
				+ ", inoticeWriter=" + inoticeWriter + ", inoitceTitle=" + inoitceTitle + ", inoticeContent="
				+ inoticeContent + ", inoticeDate=" + inoticeDate + ", inoticeCount=" + inoticeCount + ", fileName="
				+ fileName + ", filePath=" + filePath + ", fileReName=" + fileReName + "]";
	}
	
	
}
