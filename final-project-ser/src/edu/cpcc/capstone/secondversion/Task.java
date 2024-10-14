package edu.cpcc.capstone.secondversion;

public class Task {
	
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
