package org.kh.shareware.approval.domain;

public class AppForm {
	private int formNo;
	private String formName;
	private String formContent;
	
	public AppForm() {}
	
	public int getFormNo() {
		return formNo;
	}
	public void setFormNo(int formNo) {
		this.formNo = formNo;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getFormContent() {
		return formContent;
	}
	public void setFormContent(String formContent) {
		this.formContent = formContent;
	}
	
	@Override
	public String toString() {
		return "AppForm [formNo=" + formNo + ", formName=" + formName + ", formContent=" + formContent + "]";
	}
	
}
