
package com.doublechaintech.shipping.shippingaddress;
import com.doublechaintech.shipping.CommonTokens;
import java.util.Map;
public class ShippingAddressTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="shippingAddress";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected ShippingAddressTokens(){
		//ensure not initialized outside the class
	}
	
	public ShippingAddressTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ShippingAddressTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ShippingAddressTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ShippingAddressTokens start(){
		return new ShippingAddressTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ShippingAddressTokens allTokens(){
		
		return start()
			.withProfile();
	
	}
	public static ShippingAddressTokens withoutListsTokens(){
		
		return start()
			.withProfile();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	protected static final String PROFILE = "profile";
	public String getProfile(){
		return PROFILE;
	}
	public ShippingAddressTokens withProfile(){		
		addSimpleOptions(PROFILE);
		return this;
	}
	
	
	
	public  ShippingAddressTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

