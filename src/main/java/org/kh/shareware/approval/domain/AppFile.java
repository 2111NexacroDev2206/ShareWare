package org.kh.shareware.approval.domain;

public class AppFile {
	private int fileNo;
	private String docNo;
	private String fileName;
	private String fileReName;
	private String filePath;
	
	public AppFile() {}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileReName() {
		return fileReName;
	}

	public void setFileReName(String fileReName) {
		this.fileReName = fileReName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "AppFile [fileNo=" + fileNo + ", docNo=" + docNo + ", fileName=" + fileName + ", fileReName="
				+ fileReName + ", filePath=" + filePath + "]";
	}
	
}
