package by.tc.nb.bean;

import by.tc.nb.bean.entity.Note;

import java.util.List;

public class Response {
	private boolean errorStatus;
	private String errorMessage;
	
	private String resultMessage;

	public boolean isErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(boolean errorStatus) {
		this.errorStatus = errorStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

//	public void setAllBook(List<Note> allBook) {
//	}
	
	

}
