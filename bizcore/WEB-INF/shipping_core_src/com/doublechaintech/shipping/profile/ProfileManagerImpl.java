
package com.doublechaintech.shipping.profile;

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

import com.doublechaintech.shipping.platform.Platform;
import com.doublechaintech.shipping.shippingaddress.ShippingAddress;

import com.doublechaintech.shipping.platform.CandidatePlatform;

import com.doublechaintech.shipping.profile.Profile;






public class ProfileManagerImpl extends CustomShippingCheckerManager implements ProfileManager {
	
	private static final String SERVICE_TYPE = "Profile";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ProfileManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ProfileManagerException(message);

	}
	
	

 	protected Profile saveProfile(ShippingUserContext userContext, Profile profile, String [] tokensExpr) throws Exception{	
 		//return getProfileDAO().save(profile, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProfile(userContext, profile, tokens);
 	}
 	
 	protected Profile saveProfileDetail(ShippingUserContext userContext, Profile profile) throws Exception{	

 		
 		return saveProfile(userContext, profile, allTokens());
 	}
 	
 	public Profile loadProfile(ShippingUserContext userContext, String profileId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Profile profile = loadProfile( userContext, profileId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,profile, tokens);
 	}
 	
 	
 	 public Profile searchProfile(ShippingUserContext userContext, String profileId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Profile profile = loadProfile( userContext, profileId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,profile, tokens);
 	}
 	
 	

 	protected Profile present(ShippingUserContext userContext, Profile profile, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,profile,tokens);
		
		
		Profile  profileToPresent = userContext.getDAOGroup().getProfileDAO().present(profile, tokens);
		
		List<BaseEntity> entityListToNaming = profileToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getProfileDAO().alias(entityListToNaming);
		
		return  profileToPresent;
		
		
	}
 
 	
 	
 	public Profile loadProfileDetail(ShippingUserContext userContext, String profileId) throws Exception{	
 		Profile profile = loadProfile( userContext, profileId, allTokens());
 		return present(userContext,profile, allTokens());
		
 	}
 	
 	public Object view(ShippingUserContext userContext, String profileId) throws Exception{	
 		Profile profile = loadProfile( userContext, profileId, viewTokens());
 		return present(userContext,profile, allTokens());
		
 	}
 	protected Profile saveProfile(ShippingUserContext userContext, Profile profile, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getProfileDAO().save(profile, tokens);
 	}
 	protected Profile loadProfile(ShippingUserContext userContext, String profileId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 
 		return userContext.getDAOGroup().getProfileDAO().load(profileId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(ShippingUserContext userContext, Profile profile, Map<String, Object> tokens){
		super.addActions(userContext, profile, tokens);
		
		addAction(userContext, profile, tokens,"@create","createProfile","createProfile/","main","primary");
		addAction(userContext, profile, tokens,"@update","updateProfile","updateProfile/"+profile.getId()+"/","main","primary");
		addAction(userContext, profile, tokens,"@copy","cloneProfile","cloneProfile/"+profile.getId()+"/","main","primary");
		
		addAction(userContext, profile, tokens,"profile.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+profile.getId()+"/","main","primary");
		addAction(userContext, profile, tokens,"profile.addShippingAddress","addShippingAddress","addShippingAddress/"+profile.getId()+"/","shippingAddressList","primary");
		addAction(userContext, profile, tokens,"profile.removeShippingAddress","removeShippingAddress","removeShippingAddress/"+profile.getId()+"/","shippingAddressList","primary");
		addAction(userContext, profile, tokens,"profile.updateShippingAddress","updateShippingAddress","updateShippingAddress/"+profile.getId()+"/","shippingAddressList","primary");
		addAction(userContext, profile, tokens,"profile.copyShippingAddressFrom","copyShippingAddressFrom","copyShippingAddressFrom/"+profile.getId()+"/","shippingAddressList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(ShippingUserContext userContext, Profile profile, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Profile createProfile(ShippingUserContext userContext,String name, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfProfile(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);


		Profile profile=createNewProfile();	

		profile.setName(name);
		profile.setLastUpdateTime(userContext.now());
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		profile.setPlatform(platform);
		
		

		profile = saveProfile(userContext, profile, emptyOptions());
		
		onNewInstanceCreated(userContext, profile);
		return profile;

		
	}
	protected Profile createNewProfile() 
	{
		
		return new Profile();		
	}
	
	protected void checkParamsForUpdatingProfile(ShippingUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkVersionOfProfile( profileVersion);
		

		if(Profile.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProfile(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
		
	}
	
	
	
	public Profile clone(ShippingUserContext userContext, String fromProfileId) throws Exception{
		
		return userContext.getDAOGroup().getProfileDAO().clone(fromProfileId, this.allTokens());
	}
	
	public Profile internalSaveProfile(ShippingUserContext userContext, Profile profile) throws Exception 
	{
		return internalSaveProfile(userContext, profile, allTokens());

	}
	public Profile internalSaveProfile(ShippingUserContext userContext, Profile profile, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			
			
			profile = saveProfile(userContext, profile, options);
			return profile;
			
		}

	}
	
	public Profile updateProfile(ShippingUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		if(profile.getVersion() != profileVersion){
			String message = "The target version("+profile.getVersion()+") is not equals to version("+profileVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			profile.updateLastUpdateTime(userContext.now());
			profile.changeProperty(property, newValueExpr);
			profile = saveProfile(userContext, profile, tokens().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
			//return saveProfile(userContext, profile, tokens().done());
		}

	}
	
	public Profile updateProfileProperty(ShippingUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		if(profile.getVersion() != profileVersion){
			String message = "The target version("+profile.getVersion()+") is not equals to version("+profileVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			
			profile.changeProperty(property, newValueExpr);
			profile.updateLastUpdateTime(userContext.now());
			profile = saveProfile(userContext, profile, tokens().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
			//return saveProfile(userContext, profile, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProfileTokens tokens(){
		return ProfileTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProfileTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortShippingAddressListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProfileTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(ShippingUserContext userContext, String profileId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProfile(profileId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
 		
 	}
 	public Profile transferToAnotherPlatform(ShippingUserContext userContext, String profileId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, profileId,anotherPlatformId);
 
		Profile profile = loadProfile(userContext, profileId, allTokens());	
		synchronized(profile){
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			profile.updatePlatform(platform);		
			profile = saveProfile(userContext, profile, emptyOptions());
			
			return present(userContext,profile, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePlatform requestCandidatePlatform(ShippingUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForProfile(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Platform loadPlatform(ShippingUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(ShippingUserContext userContext, String profileId, int profileVersion) throws Exception {
		//deleteInternal(userContext, profileId, profileVersion);		
	}
	protected void deleteInternal(ShippingUserContext userContext,
			String profileId, int profileVersion) throws Exception{
			
		userContext.getDAOGroup().getProfileDAO().delete(profileId, profileVersion);
	}
	
	public Profile forgetByAll(ShippingUserContext userContext, String profileId, int profileVersion) throws Exception {
		return forgetByAllInternal(userContext, profileId, profileVersion);		
	}
	protected Profile forgetByAllInternal(ShippingUserContext userContext,
			String profileId, int profileVersion) throws Exception{
			
		return userContext.getDAOGroup().getProfileDAO().disconnectFromAll(profileId, profileVersion);
	}
	

	
	public int deleteAll(ShippingUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProfileManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(ShippingUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getProfileDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingShippingAddress(ShippingUserContext userContext, String profileId, String name, String cardNumber, String addressLine1, String addressLine2, String addressLine3, String city, String state, String zipCode,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkNameOfShippingAddress(name);
		
		userContext.getChecker().checkCardNumberOfShippingAddress(cardNumber);
		
		userContext.getChecker().checkAddressLine1OfShippingAddress(addressLine1);
		
		userContext.getChecker().checkAddressLine2OfShippingAddress(addressLine2);
		
		userContext.getChecker().checkAddressLine3OfShippingAddress(addressLine3);
		
		userContext.getChecker().checkCityOfShippingAddress(city);
		
		userContext.getChecker().checkStateOfShippingAddress(state);
		
		userContext.getChecker().checkZipCodeOfShippingAddress(zipCode);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addShippingAddress(ShippingUserContext userContext, String profileId, String name, String cardNumber, String addressLine1, String addressLine2, String addressLine3, String city, String state, String zipCode, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingShippingAddress(userContext,profileId,name, cardNumber, addressLine1, addressLine2, addressLine3, city, state, zipCode,tokensExpr);
		
		ShippingAddress shippingAddress = createShippingAddress(userContext,name, cardNumber, addressLine1, addressLine2, addressLine3, city, state, zipCode);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addShippingAddress( shippingAddress );		
			profile = saveProfile(userContext, profile, tokens().withShippingAddressList().done());
			
			userContext.getManagerGroup().getShippingAddressManager().onNewInstanceCreated(userContext, shippingAddress);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingShippingAddressProperties(ShippingUserContext userContext, String profileId,String id,String name,String cardNumber,String addressLine1,String addressLine2,String addressLine3,String city,String state,String zipCode,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfShippingAddress(id);
		
		userContext.getChecker().checkNameOfShippingAddress( name);
		userContext.getChecker().checkCardNumberOfShippingAddress( cardNumber);
		userContext.getChecker().checkAddressLine1OfShippingAddress( addressLine1);
		userContext.getChecker().checkAddressLine2OfShippingAddress( addressLine2);
		userContext.getChecker().checkAddressLine3OfShippingAddress( addressLine3);
		userContext.getChecker().checkCityOfShippingAddress( city);
		userContext.getChecker().checkStateOfShippingAddress( state);
		userContext.getChecker().checkZipCodeOfShippingAddress( zipCode);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateShippingAddressProperties(ShippingUserContext userContext, String profileId, String id,String name,String cardNumber,String addressLine1,String addressLine2,String addressLine3,String city,String state,String zipCode, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingShippingAddressProperties(userContext,profileId,id,name,cardNumber,addressLine1,addressLine2,addressLine3,city,state,zipCode,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withShippingAddressListList()
				.searchShippingAddressListWith(ShippingAddress.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getShippingAddressList().isEmpty()){
			throw new ProfileManagerException("ShippingAddress is NOT FOUND with id: '"+id+"'");
		}
		
		ShippingAddress item = profileToUpdate.getShippingAddressList().first();
		
		item.updateName( name );
		item.updateCardNumber( cardNumber );
		item.updateAddressLine1( addressLine1 );
		item.updateAddressLine2( addressLine2 );
		item.updateAddressLine3( addressLine3 );
		item.updateCity( city );
		item.updateState( state );
		item.updateZipCode( zipCode );

		
		//checkParamsForAddingShippingAddress(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withShippingAddressList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ShippingAddress createShippingAddress(ShippingUserContext userContext, String name, String cardNumber, String addressLine1, String addressLine2, String addressLine3, String city, String state, String zipCode) throws Exception{

		ShippingAddress shippingAddress = new ShippingAddress();
		
		
		shippingAddress.setName(name);		
		shippingAddress.setCardNumber(cardNumber);		
		shippingAddress.setAddressLine1(addressLine1);		
		shippingAddress.setAddressLine2(addressLine2);		
		shippingAddress.setAddressLine3(addressLine3);		
		shippingAddress.setCity(city);		
		shippingAddress.setState(state);		
		shippingAddress.setZipCode(zipCode);
	
		
		return shippingAddress;
	
		
	}
	
	protected ShippingAddress createIndexedShippingAddress(String id, int version){

		ShippingAddress shippingAddress = new ShippingAddress();
		shippingAddress.setId(id);
		shippingAddress.setVersion(version);
		return shippingAddress;			
		
	}
	
	protected void checkParamsForRemovingShippingAddressList(ShippingUserContext userContext, String profileId, 
			String shippingAddressIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String shippingAddressId: shippingAddressIds){
			userContext.getChecker().checkIdOfShippingAddress(shippingAddressId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeShippingAddressList(ShippingUserContext userContext, String profileId, 
			String shippingAddressIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingShippingAddressList(userContext, profileId,  shippingAddressIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveShippingAddressList(profile, shippingAddressIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withShippingAddressList().done());
				deleteRelationListInGraph(userContext, profile.getShippingAddressList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingShippingAddress(ShippingUserContext userContext, String profileId, 
		String shippingAddressId, int shippingAddressVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfShippingAddress(shippingAddressId);
		userContext.getChecker().checkVersionOfShippingAddress(shippingAddressVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeShippingAddress(ShippingUserContext userContext, String profileId, 
		String shippingAddressId, int shippingAddressVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingShippingAddress(userContext,profileId, shippingAddressId, shippingAddressVersion,tokensExpr);
		
		ShippingAddress shippingAddress = createIndexedShippingAddress(shippingAddressId, shippingAddressVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeShippingAddress( shippingAddress );		
			profile = saveProfile(userContext, profile, tokens().withShippingAddressList().done());
			deleteRelationInGraph(userContext, shippingAddress);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingShippingAddress(ShippingUserContext userContext, String profileId, 
		String shippingAddressId, int shippingAddressVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfShippingAddress(shippingAddressId);
		userContext.getChecker().checkVersionOfShippingAddress(shippingAddressVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyShippingAddressFrom(ShippingUserContext userContext, String profileId, 
		String shippingAddressId, int shippingAddressVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingShippingAddress(userContext,profileId, shippingAddressId, shippingAddressVersion,tokensExpr);
		
		ShippingAddress shippingAddress = createIndexedShippingAddress(shippingAddressId, shippingAddressVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			profile.copyShippingAddressFrom( shippingAddress );		
			profile = saveProfile(userContext, profile, tokens().withShippingAddressList().done());
			
			userContext.getManagerGroup().getShippingAddressManager().onNewInstanceCreated(userContext, (ShippingAddress)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingShippingAddress(ShippingUserContext userContext, String profileId, String shippingAddressId, int shippingAddressVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfShippingAddress(shippingAddressId);
		userContext.getChecker().checkVersionOfShippingAddress(shippingAddressVersion);
		

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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateShippingAddress(ShippingUserContext userContext, String profileId, String shippingAddressId, int shippingAddressVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingShippingAddress(userContext, profileId, shippingAddressId, shippingAddressVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withShippingAddressList().searchShippingAddressListWith(ShippingAddress.ID_PROPERTY, "eq", shippingAddressId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeShippingAddress( shippingAddress );	
			//make changes to AcceleraterAccount.
			ShippingAddress shippingAddressIndex = createIndexedShippingAddress(shippingAddressId, shippingAddressVersion);
		
			ShippingAddress shippingAddress = profile.findTheShippingAddress(shippingAddressIndex);
			if(shippingAddress == null){
				throw new ProfileManagerException(shippingAddress+" is NOT FOUND" );
			}
			
			shippingAddress.changeProperty(property, newValueExpr);
			
			profile = saveProfile(userContext, profile, tokens().withShippingAddressList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(ShippingUserContext userContext, Profile newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


