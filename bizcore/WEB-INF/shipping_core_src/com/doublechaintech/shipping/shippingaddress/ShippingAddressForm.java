package com.doublechaintech.shipping.shippingaddress;
import com.doublechaintech.shipping.BaseForm;
import com.doublechaintech.shipping.genericform.GenericForm;
import com.doublechaintech.shipping.formfield.FormField;
import com.doublechaintech.shipping.formaction.FormAction;
import com.doublechaintech.shipping.formmessage.FormMessage;
import com.doublechaintech.shipping.formfieldmessage.FormFieldMessage;



public class ShippingAddressForm extends BaseForm {
	
	
	public ShippingAddressForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ShippingAddressForm shippingAddressIdField(String parameterName, String initValue){
		FormField field = idFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingAddressForm shippingAddressIdField(String initValue){
		return shippingAddressIdField("shippingAddressId",initValue);
	}
	public ShippingAddressForm shippingAddressIdField(){
		return shippingAddressIdField("shippingAddressId","");
	}


	public ShippingAddressForm nameField(String parameterName, String initValue){
		FormField field = nameFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingAddressForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ShippingAddressForm nameField(){
		return nameField("name","");
	}


	public ShippingAddressForm cardNumberField(String parameterName, String initValue){
		FormField field = cardNumberFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingAddressForm cardNumberField(String initValue){
		return cardNumberField("cardNumber",initValue);
	}
	public ShippingAddressForm cardNumberField(){
		return cardNumberField("cardNumber","");
	}


	public ShippingAddressForm addressLine1Field(String parameterName, String initValue){
		FormField field = addressLine1FromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingAddressForm addressLine1Field(String initValue){
		return addressLine1Field("addressLine1",initValue);
	}
	public ShippingAddressForm addressLine1Field(){
		return addressLine1Field("addressLine1","");
	}


	public ShippingAddressForm addressLine2Field(String parameterName, String initValue){
		FormField field = addressLine2FromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingAddressForm addressLine2Field(String initValue){
		return addressLine2Field("addressLine2",initValue);
	}
	public ShippingAddressForm addressLine2Field(){
		return addressLine2Field("addressLine2","");
	}


	public ShippingAddressForm addressLine3Field(String parameterName, String initValue){
		FormField field = addressLine3FromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingAddressForm addressLine3Field(String initValue){
		return addressLine3Field("addressLine3",initValue);
	}
	public ShippingAddressForm addressLine3Field(){
		return addressLine3Field("addressLine3","");
	}


	public ShippingAddressForm cityField(String parameterName, String initValue){
		FormField field = cityFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingAddressForm cityField(String initValue){
		return cityField("city",initValue);
	}
	public ShippingAddressForm cityField(){
		return cityField("city","");
	}


	public ShippingAddressForm stateField(String parameterName, String initValue){
		FormField field = stateFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingAddressForm stateField(String initValue){
		return stateField("state",initValue);
	}
	public ShippingAddressForm stateField(){
		return stateField("state","");
	}


	public ShippingAddressForm zipCodeField(String parameterName, String initValue){
		FormField field = zipCodeFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingAddressForm zipCodeField(String initValue){
		return zipCodeField("zipCode",initValue);
	}
	public ShippingAddressForm zipCodeField(){
		return zipCodeField("zipCode","");
	}


	public ShippingAddressForm profileIdField(String parameterName, String initValue){
		FormField field = profileIdFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingAddressForm profileIdField(String initValue){
		return profileIdField("profileId",initValue);
	}
	public ShippingAddressForm profileIdField(){
		return profileIdField("profileId","");
	}

	
	


	public ShippingAddressForm profileIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingAddressForm profileIdFieldOfProfile(String initValue){
		return profileIdFieldOfProfile("profileId",initValue);
	}
	public ShippingAddressForm profileIdFieldOfProfile(){
		return profileIdFieldOfProfile("profileId","");
	}


	public ShippingAddressForm nameFieldOfProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingAddressForm nameFieldOfProfile(String initValue){
		return nameFieldOfProfile("name",initValue);
	}
	public ShippingAddressForm nameFieldOfProfile(){
		return nameFieldOfProfile("name","");
	}


	public ShippingAddressForm lastUpdateTimeFieldOfProfile(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingAddressForm lastUpdateTimeFieldOfProfile(String initValue){
		return lastUpdateTimeFieldOfProfile("lastUpdateTime",initValue);
	}
	public ShippingAddressForm lastUpdateTimeFieldOfProfile(){
		return lastUpdateTimeFieldOfProfile("lastUpdateTime","");
	}


	public ShippingAddressForm platformIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingAddressForm platformIdFieldOfProfile(String initValue){
		return platformIdFieldOfProfile("platformId",initValue);
	}
	public ShippingAddressForm platformIdFieldOfProfile(){
		return platformIdFieldOfProfile("platformId","");
	}

	


	

	
 	public ShippingAddressForm transferToAnotherProfileAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProfile/shippingAddressId/");
		this.addFormAction(action);
		return this;
	}

 

	public ShippingAddressForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


