package com.doublechaintech.shipping.profile;
import com.doublechaintech.shipping.BaseForm;
import com.doublechaintech.shipping.genericform.GenericForm;
import com.doublechaintech.shipping.formfield.FormField;
import com.doublechaintech.shipping.formaction.FormAction;
import com.doublechaintech.shipping.formmessage.FormMessage;
import com.doublechaintech.shipping.formfieldmessage.FormFieldMessage;



public class ProfileForm extends BaseForm {
	
	
	public ProfileForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ProfileForm profileIdField(String parameterName, String initValue){
		FormField field = idFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm profileIdField(String initValue){
		return profileIdField("profileId",initValue);
	}
	public ProfileForm profileIdField(){
		return profileIdField("profileId","");
	}


	public ProfileForm nameField(String parameterName, String initValue){
		FormField field = nameFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ProfileForm nameField(){
		return nameField("name","");
	}


	public ProfileForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public ProfileForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}


	public ProfileForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public ProfileForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public ProfileForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public ProfileForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public ProfileForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public ProfileForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public ProfileForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public ProfileForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public ProfileForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public ProfileForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	



	public ProfileForm shippingAddressIdFieldForShippingAddress(String parameterName, String initValue){
		FormField field =  idFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm shippingAddressIdFieldForShippingAddress(String initValue){
		return shippingAddressIdFieldForShippingAddress("shippingAddressId",initValue);
	}
	public ProfileForm shippingAddressIdFieldForShippingAddress(){
		return shippingAddressIdFieldForShippingAddress("shippingAddressId","");
	}


	public ProfileForm nameFieldForShippingAddress(String parameterName, String initValue){
		FormField field =  nameFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm nameFieldForShippingAddress(String initValue){
		return nameFieldForShippingAddress("name",initValue);
	}
	public ProfileForm nameFieldForShippingAddress(){
		return nameFieldForShippingAddress("name","");
	}


	public ProfileForm cardNumberFieldForShippingAddress(String parameterName, String initValue){
		FormField field =  cardNumberFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm cardNumberFieldForShippingAddress(String initValue){
		return cardNumberFieldForShippingAddress("cardNumber",initValue);
	}
	public ProfileForm cardNumberFieldForShippingAddress(){
		return cardNumberFieldForShippingAddress("cardNumber","");
	}


	public ProfileForm addressLine1FieldForShippingAddress(String parameterName, String initValue){
		FormField field =  addressLine1FromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm addressLine1FieldForShippingAddress(String initValue){
		return addressLine1FieldForShippingAddress("addressLine1",initValue);
	}
	public ProfileForm addressLine1FieldForShippingAddress(){
		return addressLine1FieldForShippingAddress("addressLine1","");
	}


	public ProfileForm addressLine2FieldForShippingAddress(String parameterName, String initValue){
		FormField field =  addressLine2FromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm addressLine2FieldForShippingAddress(String initValue){
		return addressLine2FieldForShippingAddress("addressLine2",initValue);
	}
	public ProfileForm addressLine2FieldForShippingAddress(){
		return addressLine2FieldForShippingAddress("addressLine2","");
	}


	public ProfileForm addressLine3FieldForShippingAddress(String parameterName, String initValue){
		FormField field =  addressLine3FromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm addressLine3FieldForShippingAddress(String initValue){
		return addressLine3FieldForShippingAddress("addressLine3",initValue);
	}
	public ProfileForm addressLine3FieldForShippingAddress(){
		return addressLine3FieldForShippingAddress("addressLine3","");
	}


	public ProfileForm cityFieldForShippingAddress(String parameterName, String initValue){
		FormField field =  cityFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm cityFieldForShippingAddress(String initValue){
		return cityFieldForShippingAddress("city",initValue);
	}
	public ProfileForm cityFieldForShippingAddress(){
		return cityFieldForShippingAddress("city","");
	}


	public ProfileForm stateFieldForShippingAddress(String parameterName, String initValue){
		FormField field =  stateFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm stateFieldForShippingAddress(String initValue){
		return stateFieldForShippingAddress("state",initValue);
	}
	public ProfileForm stateFieldForShippingAddress(){
		return stateFieldForShippingAddress("state","");
	}


	public ProfileForm zipCodeFieldForShippingAddress(String parameterName, String initValue){
		FormField field =  zipCodeFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm zipCodeFieldForShippingAddress(String initValue){
		return zipCodeFieldForShippingAddress("zipCode",initValue);
	}
	public ProfileForm zipCodeFieldForShippingAddress(){
		return zipCodeFieldForShippingAddress("zipCode","");
	}


	public ProfileForm profileIdFieldForShippingAddress(String parameterName, String initValue){
		FormField field =  profileIdFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm profileIdFieldForShippingAddress(String initValue){
		return profileIdFieldForShippingAddress("profileId",initValue);
	}
	public ProfileForm profileIdFieldForShippingAddress(){
		return profileIdFieldForShippingAddress("profileId","");
	}

	

	
 	public ProfileForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/profileId/");
		this.addFormAction(action);
		return this;
	}

 

	public ProfileForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


