package net.serenity.bdd.junit.cucumber.model;

public class LoginData {

	public String getStrUserName() {
		return strUserName;
	}

	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}

	public String getStrPassword() {
		return strPassword;
	}

	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}

	@Override
	public String toString() {
		return "LoginData{" +
				"strUserName='" + strUserName + '\'' +
				", strPassword='" + strPassword + '\'' +
				'}';
	}

	public void setAll(String strUserName, String strPassword){
		this.strUserName=strUserName;
		this.strPassword=strPassword;
	}

	private String strUserName;
	private String strPassword;
}
