package com.javatpoint.mypackage;  
  
import javax.persistence.*;  
  
@Entity  
@DiscriminatorValue("currentaccount")  
public class Current_Account extends Account{  
      
@Column(name="draft")    
private float draft;

public float getDraft() {
	return draft;
}

public void setDraft(float draft) {
	this.draft = draft;
}  
}  