package org.kh.shareware.fileBoard.domain;

import java.sql.Date;

import org.kh.shareware.member.domain.Member;

public class FileBoard {
private int fileBoardNo;
private String memberNum;
private Date fileBoardDate;
private String fileBoardTitle;
private String fileBoaedContent;
private int fileBoardView;
private String fileName;
private String fileRename;
private String filePath;
private String fileDelete;

private Member member;

public Member getMember() {
	return member;
}

public void setMember(Member member) {
	this.member = member;
}

public FileBoard() {}

public FileBoard(int fileBoardNo, String memberNum, Date fileBoardDate, String fileBoardTitle, String fileBoaedContent,
		int fileBoardView, String fileName, String fileRename, String filePath, String fileDelete) {
	super();
	this.fileBoardNo = fileBoardNo;
	this.memberNum = memberNum;
	this.fileBoardDate = fileBoardDate;
	this.fileBoardTitle = fileBoardTitle;
	this.fileBoaedContent = fileBoaedContent;
	this.fileBoardView = fileBoardView;
	this.fileName = fileName;
	this.fileRename = fileRename;
	this.filePath = filePath;
	this.fileDelete = fileDelete;
}

public int getFileBoardNo() {
	return fileBoardNo;
}

public void setFileBoardNo(int fileBoardNo) {
	this.fileBoardNo = fileBoardNo;
}

public String getMemberNum() {
	return memberNum;
}

public void setMemberNum(String memberNum) {
	this.memberNum = memberNum;
}

public Date getFileBoardDate() {
	return fileBoardDate;
}

public void setFileBoardDate(Date fileBoardDate) {
	this.fileBoardDate = fileBoardDate;
}

public String getFileBoardTitle() {
	return fileBoardTitle;
}

public void setFileBoardTitle(String fileBoardTitle) {
	this.fileBoardTitle = fileBoardTitle;
}

public String getFileBoaedContent() {
	return fileBoaedContent;
}

public void setFileBoaedContent(String fileBoaedContent) {
	this.fileBoaedContent = fileBoaedContent;
}

public int getFileBoardView() {
	return fileBoardView;
}

public void setFileBoardView(int fileBoardView) {
	this.fileBoardView = fileBoardView;
}

public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}

public String getFileRename() {
	return fileRename;
}

public void setFileRename(String fileRename) {
	this.fileRename = fileRename;
}

public String getFilePath() {
	return filePath;
}

public void setFilePath(String filePath) {
	this.filePath = filePath;
}

public String getFileDelete() {
	return fileDelete;
}

public void setFileDelete(String fileDelete) {
	this.fileDelete = fileDelete;
}

@Override
public String toString() {
	return "FileBoard [fileBoardNo=" + fileBoardNo + ", memberNum=" + memberNum + ", fileBoardDate=" + fileBoardDate
			+ ", fileBoardTitle=" + fileBoardTitle + ", fileBoaedContent=" + fileBoaedContent + ", fileBoardView="
			+ fileBoardView + ", fileName=" + fileName + ", fileRename=" + fileRename + ", filePath=" + filePath
			+ ", fileDelete=" + fileDelete + "]";
}


}
