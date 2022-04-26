package org.kh.shareware.project.domain;

public class WorkPGS {
	private int projectNo;
	private String memNum;
	private String projectWriter;
	private int wpRate;
	
	public WorkPGS() {}

	public WorkPGS(int projectNo, String memNum, String projectWriter, int wpRate) {
		super();
		this.projectNo = projectNo;
		this.memNum = memNum;
		this.projectWriter = projectWriter;
		this.wpRate = wpRate;
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

	public String getProjectWriter() {
		return projectWriter;
	}

	public void setProjectWriter(String projectWriter) {
		this.projectWriter = projectWriter;
	}

	public int getWpRate() {
		return wpRate;
	}

	public void setWpRate(int wpRate) {
		this.wpRate = wpRate;
	}

	@Override
	public String toString() {
		return "WorkPGS [projectNo=" + projectNo + ", memNum=" + memNum + ", projectWriter=" + projectWriter
				+ ", wpRate=" + wpRate + "]";
	}

	
	
}
