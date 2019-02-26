
package com.doublechaintech.shipping.profile;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.shipping.ShippingNamingServiceDAO;
import com.doublechaintech.shipping.BaseEntity;
import com.doublechaintech.shipping.SmartList;
import com.doublechaintech.shipping.AccessKey;
import com.doublechaintech.shipping.DateKey;
import com.doublechaintech.shipping.StatsInfo;
import com.doublechaintech.shipping.StatsItem;

import com.doublechaintech.shipping.MultipleAccessKey;
import com.doublechaintech.shipping.ShippingUserContext;


import com.doublechaintech.shipping.platform.Platform;
import com.doublechaintech.shipping.shippingaddress.ShippingAddress;

import com.doublechaintech.shipping.platform.PlatformDAO;
import com.doublechaintech.shipping.shippingaddress.ShippingAddressDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class ProfileJDBCTemplateDAO extends ShippingNamingServiceDAO implements ProfileDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		
	
  	private  ShippingAddressDAO  shippingAddressDAO;
 	public void setShippingAddressDAO(ShippingAddressDAO pShippingAddressDAO){
 	
 		if(pShippingAddressDAO == null){
 			throw new IllegalStateException("Do not try to set shippingAddressDAO to null.");
 		}
	 	this.shippingAddressDAO = pShippingAddressDAO;
 	}
 	public ShippingAddressDAO getShippingAddressDAO(){
 		if(this.shippingAddressDAO == null){
 			throw new IllegalStateException("The shippingAddressDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.shippingAddressDAO;
 	}	
 	
			
		

	
	/*
	protected Profile load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalProfile(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Profile load(String id,Map<String,Object> options) throws Exception{
		return loadInternalProfile(ProfileTable.withId(id), options);
	}
	
	
	
	public Profile save(Profile profile,Map<String,Object> options){
		
		String methodName="save(Profile profile,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(profile, methodName, "profile");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalProfile(profile,options);
	}
	public Profile clone(String profileId, Map<String,Object> options) throws Exception{
	
		return clone(ProfileTable.withId(profileId),options);
	}
	
	protected Profile clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String profileId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Profile newProfile = loadInternalProfile(accessKey, options);
		newProfile.setVersion(0);
		
		
 		
 		if(isSaveShippingAddressListEnabled(options)){
 			for(ShippingAddress item: newProfile.getShippingAddressList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalProfile(newProfile,options);
		
		return newProfile;
	}
	
	
	
	

	protected void throwIfHasException(String profileId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ProfileVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ProfileNotFoundException(
					"The " + this.getTableName() + "(" + profileId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String profileId, int version) throws Exception{
	
		String methodName="delete(String profileId, int version)";
		assertMethodArgumentNotNull(profileId, methodName, "profileId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{profileId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(profileId,version);
		}
		
	
	}
	
	
	
	
	

	public Profile disconnectFromAll(String profileId, int version) throws Exception{
	
		
		Profile profile = loadInternalProfile(ProfileTable.withId(profileId), emptyOptions());
		profile.clearFromAll();
		this.saveProfile(profile);
		return profile;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ProfileTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "profile";
	}
	@Override
	protected String getBeanName() {
		
		return "profile";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ProfileTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ProfileTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ProfileTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractShippingAddressListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProfileTokens.SHIPPING_ADDRESS_LIST);
 	}
 	protected boolean isAnalyzeShippingAddressListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,ProfileTokens.SHIPPING_ADDRESS_LIST+".analyze");
 	}
	
	protected boolean isSaveShippingAddressListEnabled(Map<String,Object> options){
		return checkOptions(options, ProfileTokens.SHIPPING_ADDRESS_LIST);
		
 	}
 	
		

	

	protected ProfileMapper getProfileMapper(){
		return new ProfileMapper();
	}

	
	
	protected Profile extractProfile(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Profile profile = loadSingleObject(accessKey, getProfileMapper());
			return profile;
		}catch(EmptyResultDataAccessException e){
			throw new ProfileNotFoundException("Profile("+accessKey+") is not found!");
		}

	}

	
	

	protected Profile loadInternalProfile(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Profile profile = extractProfile(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(profile, loadOptions);
 		}
 
		
		if(isExtractShippingAddressListEnabled(loadOptions)){
	 		extractShippingAddressList(profile, loadOptions);
 		}	
 		if(isAnalyzeShippingAddressListEnabled(loadOptions)){
	 		analyzeShippingAddressList(profile, loadOptions);
 		}
 		
		
		return profile;
		
	}

	 

 	protected Profile extractPlatform(Profile profile, Map<String,Object> options) throws Exception{

		if(profile.getPlatform() == null){
			return profile;
		}
		String platformId = profile.getPlatform().getId();
		if( platformId == null){
			return profile;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			profile.setPlatform(platform);
		}
		
 		
 		return profile;
 	}
 		
 
		
	protected void enhanceShippingAddressList(SmartList<ShippingAddress> shippingAddressList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Profile extractShippingAddressList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<ShippingAddress> shippingAddressList = getShippingAddressDAO().findShippingAddressByProfile(profile.getId(),options);
		if(shippingAddressList != null){
			enhanceShippingAddressList(shippingAddressList,options);
			profile.setShippingAddressList(shippingAddressList);
		}
		
		return profile;
	
	}	
	
	protected Profile analyzeShippingAddressList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<ShippingAddress> shippingAddressList = profile.getShippingAddressList();
		if(shippingAddressList != null){
			getShippingAddressDAO().analyzeShippingAddressByProfile(shippingAddressList, profile.getId(), options);
			
		}
		
		return profile;
	
	}	
	
		
		
  	
 	public SmartList<Profile> findProfileByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<Profile> resultList = queryWith(ProfileTable.COLUMN_PLATFORM, platformId, options, getProfileMapper());
		// analyzeProfileByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Profile> findProfileByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Profile> resultList =  queryWithRange(ProfileTable.COLUMN_PLATFORM, platformId, options, getProfileMapper(), start, count);
 		//analyzeProfileByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeProfileByPlatform(SmartList<Profile> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Profile.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//Profile.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Profile");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(Profile.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Profile.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countProfileByPlatform(String platformId,Map<String,Object> options){

 		return countWith(ProfileTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countProfileByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ProfileTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected Profile saveProfile(Profile  profile){
		
		if(!profile.isChanged()){
			return profile;
		}
		
		
		String SQL=this.getSaveProfileSQL(profile);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveProfileParameters(profile);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		profile.incVersion();
		return profile;
	
	}
	public SmartList<Profile> saveProfileList(SmartList<Profile> profileList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitProfileList(profileList);
		
		batchProfileCreate((List<Profile>)lists[CREATE_LIST_INDEX]);
		
		batchProfileUpdate((List<Profile>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Profile profile:profileList){
			if(profile.isChanged()){
				profile.incVersion();
			}
			
		
		}
		
		
		return profileList;
	}

	public SmartList<Profile> removeProfileList(SmartList<Profile> profileList,Map<String,Object> options){
		
		
		super.removeList(profileList, options);
		
		return profileList;
		
		
	}
	
	protected List<Object[]> prepareProfileBatchCreateArgs(List<Profile> profileList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Profile profile:profileList ){
			Object [] parameters = prepareProfileCreateParameters(profile);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareProfileBatchUpdateArgs(List<Profile> profileList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Profile profile:profileList ){
			if(!profile.isChanged()){
				continue;
			}
			Object [] parameters = prepareProfileUpdateParameters(profile);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchProfileCreate(List<Profile> profileList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareProfileBatchCreateArgs(profileList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchProfileUpdate(List<Profile> profileList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareProfileBatchUpdateArgs(profileList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitProfileList(List<Profile> profileList){
		
		List<Profile> profileCreateList=new ArrayList<Profile>();
		List<Profile> profileUpdateList=new ArrayList<Profile>();
		
		for(Profile profile: profileList){
			if(isUpdateRequest(profile)){
				profileUpdateList.add( profile);
				continue;
			}
			profileCreateList.add(profile);
		}
		
		return new Object[]{profileCreateList,profileUpdateList};
	}
	
	protected boolean isUpdateRequest(Profile profile){
 		return profile.getVersion() > 0;
 	}
 	protected String getSaveProfileSQL(Profile profile){
 		if(isUpdateRequest(profile)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveProfileParameters(Profile profile){
 		if(isUpdateRequest(profile) ){
 			return prepareProfileUpdateParameters(profile);
 		}
 		return prepareProfileCreateParameters(profile);
 	}
 	protected Object[] prepareProfileUpdateParameters(Profile profile){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = profile.getName();
 		parameters[1] = profile.getLastUpdateTime(); 	
 		if(profile.getPlatform() != null){
 			parameters[2] = profile.getPlatform().getId();
 		}
 		
 		parameters[3] = profile.nextVersion();
 		parameters[4] = profile.getId();
 		parameters[5] = profile.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareProfileCreateParameters(Profile profile){
		Object[] parameters = new Object[4];
		String newProfileId=getNextId();
		profile.setId(newProfileId);
		parameters[0] =  profile.getId();
 
 		parameters[1] = profile.getName();
 		parameters[2] = profile.getLastUpdateTime(); 	
 		if(profile.getPlatform() != null){
 			parameters[3] = profile.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Profile saveInternalProfile(Profile profile, Map<String,Object> options){
		
		saveProfile(profile);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(profile, options);
 		}
 
		
		if(isSaveShippingAddressListEnabled(options)){
	 		saveShippingAddressList(profile, options);
	 		//removeShippingAddressList(profile, options);
	 		//Not delete the record
	 		
 		}		
		
		return profile;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Profile savePlatform(Profile profile, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(profile.getPlatform() == null){
 			return profile;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(profile.getPlatform(),options);
 		return profile;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Profile planToRemoveShippingAddressList(Profile profile, String shippingAddressIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ShippingAddress.PROFILE_PROPERTY, profile.getId());
		key.put(ShippingAddress.ID_PROPERTY, shippingAddressIds);
		
		SmartList<ShippingAddress> externalShippingAddressList = getShippingAddressDAO().
				findShippingAddressWithKey(key, options);
		if(externalShippingAddressList == null){
			return profile;
		}
		if(externalShippingAddressList.isEmpty()){
			return profile;
		}
		
		for(ShippingAddress shippingAddress: externalShippingAddressList){

			shippingAddress.clearFromAll();
		}
		
		
		SmartList<ShippingAddress> shippingAddressList = profile.getShippingAddressList();		
		shippingAddressList.addAllToRemoveList(externalShippingAddressList);
		return profile;	
	
	}



		
	protected Profile saveShippingAddressList(Profile profile, Map<String,Object> options){
		
		
		
		
		SmartList<ShippingAddress> shippingAddressList = profile.getShippingAddressList();
		if(shippingAddressList == null){
			//null list means nothing
			return profile;
		}
		SmartList<ShippingAddress> mergedUpdateShippingAddressList = new SmartList<ShippingAddress>();
		
		
		mergedUpdateShippingAddressList.addAll(shippingAddressList); 
		if(shippingAddressList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateShippingAddressList.addAll(shippingAddressList.getToRemoveList());
			shippingAddressList.removeAll(shippingAddressList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getShippingAddressDAO().saveShippingAddressList(mergedUpdateShippingAddressList,options);
		
		if(shippingAddressList.getToRemoveList() != null){
			shippingAddressList.removeAll(shippingAddressList.getToRemoveList());
		}
		
		
		return profile;
	
	}
	
	protected Profile removeShippingAddressList(Profile profile, Map<String,Object> options){
	
	
		SmartList<ShippingAddress> shippingAddressList = profile.getShippingAddressList();
		if(shippingAddressList == null){
			return profile;
		}	
	
		SmartList<ShippingAddress> toRemoveShippingAddressList = shippingAddressList.getToRemoveList();
		
		if(toRemoveShippingAddressList == null){
			return profile;
		}
		if(toRemoveShippingAddressList.isEmpty()){
			return profile;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getShippingAddressDAO().removeShippingAddressList(toRemoveShippingAddressList,options);
		
		return profile;
	
	}
	
	

 	
 	
	
	
	
		

	public Profile present(Profile profile,Map<String, Object> options){
	
		presentShippingAddressList(profile,options);

		return profile;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Profile presentShippingAddressList(
			Profile profile,
			Map<String, Object> options) {

		SmartList<ShippingAddress> shippingAddressList = profile.getShippingAddressList();		
				SmartList<ShippingAddress> newList= presentSubList(profile.getId(),
				shippingAddressList,
				options,
				getShippingAddressDAO()::countShippingAddressByProfile,
				getShippingAddressDAO()::findShippingAddressByProfile
				);

		
		profile.setShippingAddressList(newList);
		

		return profile;
	}			
		

	
    public SmartList<Profile> requestCandidateProfileForShippingAddress(ShippingUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProfileTable.COLUMN_NAME, filterKey, pageNo, pageSize, getProfileMapper());
    }
		

	protected String getTableName(){
		return ProfileTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Profile> profileList) {		
		this.enhanceListInternal(profileList, this.getProfileMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Profile> profileList = ownerEntity.collectRefsWithType(Profile.INTERNAL_TYPE);
		this.enhanceList(profileList);
		
	}
	
	@Override
	public SmartList<Profile> findProfileWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getProfileMapper());

	}
	@Override
	public int countProfileWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countProfileWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Profile> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getProfileMapper());
	}
}


