package org.kh.shareware.report.domain;

public class Daily {
	private int drNo;
	private String memNum;
	private String drTitle;
	private String drWriter;
	private String drDate;
	private String drContent;
	private String drCompletion;
	private String drNote;
	private String fileName;
	private String filePath;
	private String fileReName;
	
	public Daily() {}
	
	public int getDrNo() {
		return drNo;
	}
	public void setDrNo(int drNo) {
		this.drNo = drNo;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	public String getDrTitle() {
		return drTitle;
	}
	public void setDrTitle(String drTitle) {
		this.drTitle = drTitle;
	}
	public String getDrWriter() {
		return drWriter;
	}
	public void setDrWriter(String drWriter) {
		this.drWriter = drWriter;
	}
	public String getDrDate() {
		return drDate;
	}
	public void setDrDate(String drDate) {
		this.drDate = drDate;
	}
	public String getDrContent() {
		return drContent;
	}
	public void setDrContent(String drContent) {
		this.drContent = drContent;
	}
	public String getDrCompletion() {
		return drCompletion;
	}
	public void setDrCompletion(String drCompletion) {
		this.drCompletion = drCompletion;
	}
	public String getDrNote() {
		return drNote;
	}
	public void setDrNote(String drNote) {
		this.drNote = drNote;
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
		return "Daily [drNo=" + drNo + ", memNum=" + memNum + ", drTitle=" + drTitle + ", drWriter=" + drWriter
				+ ", drDate=" + drDate + ", drContent=" + drContent + ", drCompletion=" + drCompletion + ", drNote="
				+ drNote + ", fileName=" + fileName + ", filePath=" + filePath + ", fileReName=" + fileReName + "]";
	}
}
