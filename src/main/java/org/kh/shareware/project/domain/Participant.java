package org.kh.shareware.project.domain;

public class Participant {
	private String memNo;
	private int projectNo;
	
	public Participant() {
		
	}

	public Participant(String memNo, int projectNo) {
		super();
		this.memNo = memNo;
		this.projectNo = projectNo;
	}

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	@Override
	public String toString() {
		return "Participant [memNo=" + memNo + ", projectNo=" + projectNo + "]";
	}

	
}
