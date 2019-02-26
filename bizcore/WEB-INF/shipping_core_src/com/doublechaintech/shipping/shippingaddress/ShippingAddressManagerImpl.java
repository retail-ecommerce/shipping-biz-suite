
package com.doublechaintech.shipping.shippingaddress;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.shipping.BaseEntity;


import com.doublechaintech.shipping.Message;
import com.doublechaintech.shipping.SmartList;
import com.doublechaintech.shipping.MultipleAccessKey;

import com.doublechaintech.shipping.ShippingUserContext;
//import com.doublechaintech.shipping.BaseManagerImpl;
import com.doublechaintech.shipping.ShippingCheckerManager;
import com.doublechaintech.shipping.CustomShippingCheckerManager;

import com.doublechaintech.shipping.profile.Profile;

import com.doublechaintech.shipping.profile.CandidateProfile;







public class ShippingAddressManagerImpl extends CustomShippingCheckerManager implements ShippingAddressManager {
	
	private static final String SERVICE_TYPE = "ShippingAddress";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ShippingAddressManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ShippingAddressManagerException(message);

	}
	
	

 	protected ShippingAddress saveShippingAddress(ShippingUserContext userContext, ShippingAddress shippingAddress, String [] tokensExpr) throws Exception{	
 		//return getShippingAddressDAO().save(shippingAddress, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveShippingAddress(userContext, shippingAddress, tokens);
 	}
 	
 	protected ShippingAddress saveShippingAddressDetail(ShippingUserContext userContext, ShippingAddress shippingAddress) throws Exception{	

 		
 		return saveShippingAddress(userContext, shippingAddress, allTokens());
 	}
 	
 	public ShippingAddress loadShippingAddress(ShippingUserContext userContext, String shippingAddressId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfShippingAddress(shippingAddressId);
		userContext.getChecker().throwExceptionIfHasErrors( ShippingAddressManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ShippingAddress shippingAddress = loadShippingAddress( userContext, shippingAddressId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,shippingAddress, tokens);
 	}
 	
 	
 	 public ShippingAddress searchShippingAddress(ShippingUserContext userContext, String shippingAddressId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfShippingAddress(shippingAddressId);
		userContext.getChecker().throwExceptionIfHasErrors( ShippingAddressManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ShippingAddress shippingAddress = loadShippingAddress( userContext, shippingAddressId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,shippingAddress, tokens);
 	}
 	
 	

 	protected ShippingAddress present(ShippingUserContext userContext, ShippingAddress shippingAddress, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,shippingAddress,tokens);
		
		
		ShippingAddress  shippingAddressToPresent = userContext.getDAOGroup().getShippingAddressDAO().present(shippingAddress, tokens);
		
		List<BaseEntity> entityListToNaming = shippingAddressToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getShippingAddressDAO().alias(entityListToNaming);
		
		return  shippingAddressToPresent;
		
		
	}
 
 	
 	
 	public ShippingAddress loadShippingAddressDetail(ShippingUserContext userContext, String shippingAddressId) throws Exception{	
 		ShippingAddress shippingAddress = loadShippingAddress( userContext, shippingAddressId, allTokens());
 		return present(userContext,shippingAddress, allTokens());
		
 	}
 	
 	public Object view(ShippingUserContext userContext, String shippingAddressId) throws Exception{	
 		ShippingAddress shippingAddress = loadShippingAddress( userContext, shippingAddressId, viewTokens());
 		return present(userContext,shippingAddress, allTokens());
		
 	}
 	protected ShippingAddress saveShippingAddress(ShippingUserContext userContext, ShippingAddress shippingAddress, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getShippingAddressDAO().save(shippingAddress, tokens);
 	}
 	protected ShippingAddress loadShippingAddress(ShippingUserContext userContext, String shippingAddressId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfShippingAddress(shippingAddressId);
		userContext.getChecker().throwExceptionIfHasErrors( ShippingAddressManagerException.class);

 
 		return userContext.getDAOGroup().getShippingAddressDAO().load(shippingAddressId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(ShippingUserContext userContext, ShippingAddress shippingAddress, Map<String, Object> tokens){
		super.addActions(userContext, shippingAddress, tokens);
		
		addAction(userContext, shippingAddress, tokens,"@create","createShippingAddress","createShippingAddress/","main","primary");
		addAction(userContext, shippingAddress, tokens,"@update","updateShippingAddress","updateShippingAddress/"+shippingAddress.getId()+"/","main","primary");
		addAction(userContext, shippingAddress, tokens,"@copy","cloneShippingAddress","cloneShippingAddress/"+shippingAddress.getId()+"/","main","primary");
		
		addAction(userContext, shippingAddress, tokens,"shipping_address.transfer_to_profile","transferToAnotherProfile","transferToAnotherProfile/"+shippingAddress.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(ShippingUserContext userContext, ShippingAddress shippingAddress, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ShippingAddress createShippingAddress(ShippingUserContext userContext,String name, String cardNumber, String addressLine1, String addressLine2, String addressLine3, String city, String state, String zipCode, String profileId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfShippingAddress(name);
		userContext.getChecker().checkCardNumberOfShippingAddress(cardNumber);
		userContext.getChecker().checkAddressLine1OfShippingAddress(addressLine1);
		userContext.getChecker().checkAddressLine2OfShippingAddress(addressLine2);
		userContext.getChecker().checkAddressLine3OfShippingAddress(addressLine3);
		userContext.getChecker().checkCityOfShippingAddress(city);
		userContext.getChecker().checkStateOfShippingAddress(state);
		userContext.getChecker().checkZipCodeOfShippingAddress(zipCode);
	
		userContext.getChecker().throwExceptionIfHasErrors(ShippingAddressManagerException.class);


		ShippingAddress shippingAddress=createNewShippingAddress();	

		shippingAddress.setName(name);
		shippingAddress.setCardNumber(cardNumber);
		shippingAddress.setAddressLine1(addressLine1);
		shippingAddress.setAddressLine2(addressLine2);
		shippingAddress.setAddressLine3(addressLine3);
		shippingAddress.setCity(city);
		shippingAddress.setState(state);
		shippingAddress.setZipCode(zipCode);
			
		Profile profile = loadProfile(userContext, profileId,emptyOptions());
		shippingAddress.setProfile(profile);
		
		

		shippingAddress = saveShippingAddress(userContext, shippingAddress, emptyOptions());
		
		onNewInstanceCreated(userContext, shippingAddress);
		return shippingAddress;

		
	}
	protected ShippingAddress createNewShippingAddress() 
	{
		
		return new ShippingAddress();		
	}
	
	protected void checkParamsForUpdatingShippingAddress(ShippingUserContext userContext,String shippingAddressId, int shippingAddressVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfShippingAddress(shippingAddressId);
		userContext.getChecker().checkVersionOfShippingAddress( shippingAddressVersion);
		

		if(ShippingAddress.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfShippingAddress(parseString(newValueExpr));
		}
		if(ShippingAddress.CARD_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkCardNumberOfShippingAddress(parseString(newValueExpr));
		}
		if(ShippingAddress.ADDRESS_LINE1_PROPERTY.equals(property)){
			userContext.getChecker().checkAddressLine1OfShippingAddress(parseString(newValueExpr));
		}
		if(ShippingAddress.ADDRESS_LINE2_PROPERTY.equals(property)){
			userContext.getChecker().checkAddressLine2OfShippingAddress(parseString(newValueExpr));
		}
		if(ShippingAddress.ADDRESS_LINE3_PROPERTY.equals(property)){
			userContext.getChecker().checkAddressLine3OfShippingAddress(parseString(newValueExpr));
		}
		if(ShippingAddress.CITY_PROPERTY.equals(property)){
			userContext.getChecker().checkCityOfShippingAddress(parseString(newValueExpr));
		}
		if(ShippingAddress.STATE_PROPERTY.equals(property)){
			userContext.getChecker().checkStateOfShippingAddress(parseString(newValueExpr));
		}
		if(ShippingAddress.ZIP_CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkZipCodeOfShippingAddress(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ShippingAddressManagerException.class);
	
		
	}
	
	
	
	public ShippingAddress clone(ShippingUserContext userContext, String fromShippingAddressId) throws Exception{
		
		return userContext.getDAOGroup().getShippingAddressDAO().clone(fromShippingAddressId, this.allTokens());
	}
	
	public ShippingAddress internalSaveShippingAddress(ShippingUserContext userContext, ShippingAddress shippingAddress) throws Exception 
	{
		return internalSaveShippingAddress(userContext, shippingAddress, allTokens());

	}
	public ShippingAddress internalSaveShippingAddress(ShippingUserContext userContext, ShippingAddress shippingAddress, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingShippingAddress(userContext, shippingAddressId, shippingAddressVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(shippingAddress){ 
			//will be good when the shippingAddress loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ShippingAddress.
			
			
			shippingAddress = saveShippingAddress(userContext, shippingAddress, options);
			return shippingAddress;
			
		}

	}
	
	public ShippingAddress updateShippingAddress(ShippingUserContext userContext,String shippingAddressId, int shippingAddressVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingShippingAddress(userContext, shippingAddressId, shippingAddressVersion, property, newValueExpr, tokensExpr);
		
		
		
		ShippingAddress shippingAddress = loadShippingAddress(userContext, shippingAddressId, allTokens());
		if(shippingAddress.getVersion() != shippingAddressVersion){
			String message = "The target version("+shippingAddress.getVersion()+") is not equals to version("+shippingAddressVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(shippingAddress){ 
			//will be good when the shippingAddress loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ShippingAddress.
			
			shippingAddress.changeProperty(property, newValueExpr);
			shippingAddress = saveShippingAddress(userContext, shippingAddress, tokens().done());
			return present(userContext,shippingAddress, mergedAllTokens(tokensExpr));
			//return saveShippingAddress(userContext, shippingAddress, tokens().done());
		}

	}
	
	public ShippingAddress updateShippingAddressProperty(ShippingUserContext userContext,String shippingAddressId, int shippingAddressVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingShippingAddress(userContext, shippingAddressId, shippingAddressVersion, property, newValueExpr, tokensExpr);
		
		ShippingAddress shippingAddress = loadShippingAddress(userContext, shippingAddressId, allTokens());
		if(shippingAddress.getVersion() != shippingAddressVersion){
			String message = "The target version("+shippingAddress.getVersion()+") is not equals to version("+shippingAddressVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(shippingAddress){ 
			//will be good when the shippingAddress loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ShippingAddress.
			
			shippingAddress.changeProperty(property, newValueExpr);
			
			shippingAddress = saveShippingAddress(userContext, shippingAddress, tokens().done());
			return present(userContext,shippingAddress, mergedAllTokens(tokensExpr));
			//return saveShippingAddress(userContext, shippingAddress, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ShippingAddressTokens tokens(){
		return ShippingAddressTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ShippingAddressTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ShippingAddressTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProfile(ShippingUserContext userContext, String shippingAddressId, String anotherProfileId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfShippingAddress(shippingAddressId);
 		userContext.getChecker().checkIdOfProfile(anotherProfileId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ShippingAddressManagerException.class);
 		
 	}
 	public ShippingAddress transferToAnotherProfile(ShippingUserContext userContext, String shippingAddressId, String anotherProfileId) throws Exception
 	{
 		checkParamsForTransferingAnotherProfile(userContext, shippingAddressId,anotherProfileId);
 
		ShippingAddress shippingAddress = loadShippingAddress(userContext, shippingAddressId, allTokens());	
		synchronized(shippingAddress){
			//will be good when the shippingAddress loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Profile profile = loadProfile(userContext, anotherProfileId, emptyOptions());		
			shippingAddress.updateProfile(profile);		
			shippingAddress = saveShippingAddress(userContext, shippingAddress, emptyOptions());
			
			return present(userContext,shippingAddress, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateProfile requestCandidateProfile(ShippingUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProfile result = new CandidateProfile();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Profile> candidateList = userContext.getDAOGroup().getProfileDAO().requestCandidateProfileForShippingAddress(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Profile loadProfile(ShippingUserContext userContext, String newProfileId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getProfileDAO().load(newProfileId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(ShippingUserContext userContext, String shippingAddressId, int shippingAddressVersion) throws Exception {
		//deleteInternal(userContext, shippingAddressId, shippingAddressVersion);		
	}
	protected void deleteInternal(ShippingUserContext userContext,
			String shippingAddressId, int shippingAddressVersion) throws Exception{
			
		userContext.getDAOGroup().getShippingAddressDAO().delete(shippingAddressId, shippingAddressVersion);
	}
	
	public ShippingAddress forgetByAll(ShippingUserContext userContext, String shippingAddressId, int shippingAddressVersion) throws Exception {
		return forgetByAllInternal(userContext, shippingAddressId, shippingAddressVersion);		
	}
	protected ShippingAddress forgetByAllInternal(ShippingUserContext userContext,
			String shippingAddressId, int shippingAddressVersion) throws Exception{
			
		return userContext.getDAOGroup().getShippingAddressDAO().disconnectFromAll(shippingAddressId, shippingAddressVersion);
	}
	

	
	public int deleteAll(ShippingUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ShippingAddressManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(ShippingUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getShippingAddressDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(ShippingUserContext userContext, ShippingAddress newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


