package org.kh.shareware.mail.domain;

public class MailFile {
	private int mailFileNo;
	private int mailNo;
	private String mailFileName;
	private String mailFileRename;
	private String mailFilePath;
	private String memNum;
	
	public MailFile() {}

	public MailFile(int mailFileNo, int mailNo, String mailFileName, String mailFileRename, String mailFilePath,
			String memNum) {
		super();
		this.mailFileNo = mailFileNo;
		this.mailNo = mailNo;
		this.mailFileName = mailFileName;
		this.mailFileRename = mailFileRename;
		this.mailFilePath = mailFilePath;
		this.memNum = memNum;
	}

	public int getMailFileNo() {
		return mailFileNo;
	}

	public void setMailFileNo(int mailFileNo) {
		this.mailFileNo = mailFileNo;
	}

	public int getMailNo() {
		return mailNo;
	}

	public void setMailNo(int mailNo) {
		this.mailNo = mailNo;
	}

	public String getMailFileName() {
		return mailFileName;
	}

	public void setMailFileName(String mailFileName) {
		this.mailFileName = mailFileName;
	}

	public String getMailFileRename() {
		return mailFileRename;
	}

	public void setMailFileRename(String mailFileRename) {
		this.mailFileRename = mailFileRename;
	}

	public String getMailFilePath() {
		return mailFilePath;
	}

	public void setMailFilePath(String mailFilePath) {
		this.mailFilePath = mailFilePath;
	}

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}

	@Override
	public String toString() {
		return "MailFile [mailFileNo=" + mailFileNo + ", mailNo=" + mailNo + ", mailFileName=" + mailFileName
				+ ", mailFileRename=" + mailFileRename + ", mailFilePath=" + mailFilePath + ", memNum=" + memNum + "]";
	}
	
	
	}
	

