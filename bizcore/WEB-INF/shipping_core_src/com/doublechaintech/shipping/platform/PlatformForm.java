package com.doublechaintech.shipping.platform;
import com.doublechaintech.shipping.BaseForm;
import com.doublechaintech.shipping.genericform.GenericForm;
import com.doublechaintech.shipping.formfield.FormField;
import com.doublechaintech.shipping.formaction.FormAction;
import com.doublechaintech.shipping.formmessage.FormMessage;
import com.doublechaintech.shipping.formfieldmessage.FormFieldMessage;



public class PlatformForm extends BaseForm {
	
	
	public PlatformForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PlatformForm platformIdField(String parameterName, String initValue){
		FormField field = idFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public PlatformForm platformIdField(){
		return platformIdField("platformId","");
	}


	public PlatformForm nameField(String parameterName, String initValue){
		FormField field = nameFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PlatformForm nameField(){
		return nameField("name","");
	}


	public PlatformForm introductionField(String parameterName, String initValue){
		FormField field = introductionFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm introductionField(String initValue){
		return introductionField("introduction",initValue);
	}
	public PlatformForm introductionField(){
		return introductionField("introduction","");
	}


	public PlatformForm currentVersionField(String parameterName, String initValue){
		FormField field = currentVersionFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm currentVersionField(String initValue){
		return currentVersionField("currentVersion",initValue);
	}
	public PlatformForm currentVersionField(){
		return currentVersionField("currentVersion","");
	}

	
	

	



	public PlatformForm profileIdFieldForProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm profileIdFieldForProfile(String initValue){
		return profileIdFieldForProfile("profileId",initValue);
	}
	public PlatformForm profileIdFieldForProfile(){
		return profileIdFieldForProfile("profileId","");
	}


	public PlatformForm nameFieldForProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForProfile(String initValue){
		return nameFieldForProfile("name",initValue);
	}
	public PlatformForm nameFieldForProfile(){
		return nameFieldForProfile("name","");
	}


	public PlatformForm lastUpdateTimeFieldForProfile(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateTimeFieldForProfile(String initValue){
		return lastUpdateTimeFieldForProfile("lastUpdateTime",initValue);
	}
	public PlatformForm lastUpdateTimeFieldForProfile(){
		return lastUpdateTimeFieldForProfile("lastUpdateTime","");
	}


	public PlatformForm platformIdFieldForProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForProfile(String initValue){
		return platformIdFieldForProfile("platformId",initValue);
	}
	public PlatformForm platformIdFieldForProfile(){
		return platformIdFieldForProfile("platformId","");
	}

	



	public PlatformForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


