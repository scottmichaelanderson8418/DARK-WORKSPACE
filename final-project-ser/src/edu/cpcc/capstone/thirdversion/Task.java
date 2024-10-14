package edu.cpcc.capstone.thirdversion;

import java.io.Serializable;

// NOTE: added this extension to be able to serialize the Task to a file.
public class Task implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String text;
	private Boolean complete;
	
	// Default constructor...
	public Task() {
		this.setText("NONE");
		this.setComplete(false);
	}
	
	// Custom constructor...
	public Task (String text) {
		this.setText(text);
		this.setComplete(false);
	}
		
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public Boolean getComplete() {
		return complete;
	}
	public void setComplete(Boolean complete) {
		this.complete = complete;
	}
	
	@Override
	public String toString() {
		// FIXME: try using a String Builder instead of doing string concatenation...and then display to System out..
		return this.getText() +  " " + (getComplete() ? Constants.COMPLETE : "");		
	}
	
	

}
