package org.kh.shareware.report.domain;

import java.sql.Clob;

public class Week {
	private int wrNo;
	private String memNum;
	private String wrTitle;
	private String wrWriter;
	private String wrDate;
	private String wrContent;
	private String fileName;
	private String filePath;
	private String fileReName;
	
	public Week() {}

	public Week(int wrNo, String memNum, String wrTitle, String wrWriter, String wrDate, String wrContent,
			String fileName, String filePath, String fileReName) {
		super();
		this.wrNo = wrNo;
		this.memNum = memNum;
		this.wrTitle = wrTitle;
		this.wrWriter = wrWriter;
		this.wrDate = wrDate;
		this.wrContent = wrContent;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileReName = fileReName;
	}

	public int getWrNo() {
		return wrNo;
	}

	public void setWrNo(int wrNo) {
		this.wrNo = wrNo;
	}

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}

	public String getWrTitle() {
		return wrTitle;
	}

	public void setWrTitle(String wrTitle) {
		this.wrTitle = wrTitle;
	}

	public String getWrWriter() {
		return wrWriter;
	}

	public void setWrWriter(String wrWriter) {
		this.wrWriter = wrWriter;
	}

	public String getWrDate() {
		return wrDate;
	}

	public void setWrDate(String wrDate) {
		this.wrDate = wrDate;
	}

	public String getWrContent() {
		return wrContent;
	}

	public void setWrContent(String wrContent) {
		this.wrContent = wrContent;
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
		return "Week [wrNo=" + wrNo + ", memNum=" + memNum + ", wrTitle=" + wrTitle + ", wrWriter=" + wrWriter
				+ ", wrDate=" + wrDate + ", wrContent=" + wrContent + ", fileName=" + fileName + ", filePath="
				+ filePath + ", fileReName=" + fileReName + "]";
	}

	

	
}
