
package com.doublechaintech.shipping.profile;
import com.doublechaintech.shipping.CommonTokens;
import java.util.Map;
public class ProfileTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="profile";
	
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
	protected ProfileTokens(){
		//ensure not initialized outside the class
	}
	
	public ProfileTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ProfileTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ProfileTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ProfileTokens start(){
		return new ProfileTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ProfileTokens allTokens(){
		
		return start()
			.withPlatform()
			.withShippingAddressList();
	
	}
	public static ProfileTokens withoutListsTokens(){
		
		return start()
			.withPlatform();
	
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

	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public ProfileTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String SHIPPING_ADDRESS_LIST = "shippingAddressList";
	public String getShippingAddressList(){
		return SHIPPING_ADDRESS_LIST;
	}
	public ProfileTokens withShippingAddressList(){		
		addSimpleOptions(SHIPPING_ADDRESS_LIST);
		return this;
	}
	public ProfileTokens analyzeShippingAddressList(){		
		addSimpleOptions(SHIPPING_ADDRESS_LIST+".anaylze");
		return this;
	}
	public boolean analyzeShippingAddressListEnabled(){		
		
		return checkOptions(this.options(), SHIPPING_ADDRESS_LIST+".anaylze");
	}
	public ProfileTokens extractMoreFromShippingAddressList(String idsSeperatedWithComma){		
		addSimpleOptions(SHIPPING_ADDRESS_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int shippingAddressListSortCounter = 0;
	public ProfileTokens sortShippingAddressListWith(String field, String descOrAsc){		
		addSortMoreOptions(SHIPPING_ADDRESS_LIST,shippingAddressListSortCounter++, field, descOrAsc);
		return this;
	}
	private int shippingAddressListSearchCounter = 0;
	public ProfileTokens searchShippingAddressListWith(String field, String verb, String value){		
		addSearchMoreOptions(SHIPPING_ADDRESS_LIST,shippingAddressListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProfileTokens searchAllTextOfShippingAddressList(String verb, String value){	
		String field = "id|name|cardNumber|addressLine1|addressLine2|addressLine3|city|state|zipCode";
		addSearchMoreOptions(SHIPPING_ADDRESS_LIST,shippingAddressListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProfileTokens rowsPerPageOfShippingAddressList(int rowsPerPage){		
		addSimpleOptions(SHIPPING_ADDRESS_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProfileTokens currentPageNumberOfShippingAddressList(int currentPageNumber){		
		addSimpleOptions(SHIPPING_ADDRESS_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProfileTokens retainColumnsOfShippingAddressList(String[] columns){		
		addSimpleOptions(SHIPPING_ADDRESS_LIST+"RetainColumns",columns);
		return this;
	}
	public ProfileTokens excludeColumnsOfShippingAddressList(String[] columns){		
		addSimpleOptions(SHIPPING_ADDRESS_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ProfileTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfShippingAddressList(verb, value);	
		return this;
	}
}

