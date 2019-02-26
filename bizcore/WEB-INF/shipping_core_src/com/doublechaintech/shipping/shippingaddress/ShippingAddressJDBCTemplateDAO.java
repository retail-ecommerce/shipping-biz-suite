
package com.doublechaintech.shipping.shippingaddress;

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


import com.doublechaintech.shipping.profile.Profile;

import com.doublechaintech.shipping.profile.ProfileDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class ShippingAddressJDBCTemplateDAO extends ShippingNamingServiceDAO implements ShippingAddressDAO{
 
 	
 	private  ProfileDAO  profileDAO;
 	public void setProfileDAO(ProfileDAO profileDAO){
	 	this.profileDAO = profileDAO;
 	}
 	public ProfileDAO getProfileDAO(){
	 	return this.profileDAO;
 	}


			
		

	
	/*
	protected ShippingAddress load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalShippingAddress(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ShippingAddress load(String id,Map<String,Object> options) throws Exception{
		return loadInternalShippingAddress(ShippingAddressTable.withId(id), options);
	}
	
	
	
	public ShippingAddress save(ShippingAddress shippingAddress,Map<String,Object> options){
		
		String methodName="save(ShippingAddress shippingAddress,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(shippingAddress, methodName, "shippingAddress");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalShippingAddress(shippingAddress,options);
	}
	public ShippingAddress clone(String shippingAddressId, Map<String,Object> options) throws Exception{
	
		return clone(ShippingAddressTable.withId(shippingAddressId),options);
	}
	
	protected ShippingAddress clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String shippingAddressId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ShippingAddress newShippingAddress = loadInternalShippingAddress(accessKey, options);
		newShippingAddress.setVersion(0);
		
		

		
		saveInternalShippingAddress(newShippingAddress,options);
		
		return newShippingAddress;
	}
	
	
	
	

	protected void throwIfHasException(String shippingAddressId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ShippingAddressVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ShippingAddressNotFoundException(
					"The " + this.getTableName() + "(" + shippingAddressId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String shippingAddressId, int version) throws Exception{
	
		String methodName="delete(String shippingAddressId, int version)";
		assertMethodArgumentNotNull(shippingAddressId, methodName, "shippingAddressId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{shippingAddressId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(shippingAddressId,version);
		}
		
	
	}
	
	
	
	
	

	public ShippingAddress disconnectFromAll(String shippingAddressId, int version) throws Exception{
	
		
		ShippingAddress shippingAddress = loadInternalShippingAddress(ShippingAddressTable.withId(shippingAddressId), emptyOptions());
		shippingAddress.clearFromAll();
		this.saveShippingAddress(shippingAddress);
		return shippingAddress;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ShippingAddressTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "shipping_address";
	}
	@Override
	protected String getBeanName() {
		
		return "shippingAddress";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ShippingAddressTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractProfileEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ShippingAddressTokens.PROFILE);
 	}

 	protected boolean isSaveProfileEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ShippingAddressTokens.PROFILE);
 	}
 	

 	
 
		

	

	protected ShippingAddressMapper getShippingAddressMapper(){
		return new ShippingAddressMapper();
	}

	
	
	protected ShippingAddress extractShippingAddress(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ShippingAddress shippingAddress = loadSingleObject(accessKey, getShippingAddressMapper());
			return shippingAddress;
		}catch(EmptyResultDataAccessException e){
			throw new ShippingAddressNotFoundException("ShippingAddress("+accessKey+") is not found!");
		}

	}

	
	

	protected ShippingAddress loadInternalShippingAddress(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ShippingAddress shippingAddress = extractShippingAddress(accessKey, loadOptions);
 	
 		if(isExtractProfileEnabled(loadOptions)){
	 		extractProfile(shippingAddress, loadOptions);
 		}
 
		
		return shippingAddress;
		
	}

	 

 	protected ShippingAddress extractProfile(ShippingAddress shippingAddress, Map<String,Object> options) throws Exception{

		if(shippingAddress.getProfile() == null){
			return shippingAddress;
		}
		String profileId = shippingAddress.getProfile().getId();
		if( profileId == null){
			return shippingAddress;
		}
		Profile profile = getProfileDAO().load(profileId,options);
		if(profile != null){
			shippingAddress.setProfile(profile);
		}
		
 		
 		return shippingAddress;
 	}
 		
 
		
		
  	
 	public SmartList<ShippingAddress> findShippingAddressByProfile(String profileId,Map<String,Object> options){
 	
  		SmartList<ShippingAddress> resultList = queryWith(ShippingAddressTable.COLUMN_PROFILE, profileId, options, getShippingAddressMapper());
		// analyzeShippingAddressByProfile(resultList, profileId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ShippingAddress> findShippingAddressByProfile(String profileId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ShippingAddress> resultList =  queryWithRange(ShippingAddressTable.COLUMN_PROFILE, profileId, options, getShippingAddressMapper(), start, count);
 		//analyzeShippingAddressByProfile(resultList, profileId, options);
 		return resultList;
 		
 	}
 	public void analyzeShippingAddressByProfile(SmartList<ShippingAddress> resultList, String profileId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countShippingAddressByProfile(String profileId,Map<String,Object> options){

 		return countWith(ShippingAddressTable.COLUMN_PROFILE, profileId, options);
 	}
 	@Override
	public Map<String, Integer> countShippingAddressByProfileIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ShippingAddressTable.COLUMN_PROFILE, ids, options);
	}
 	
 	
		
		
		

	

	protected ShippingAddress saveShippingAddress(ShippingAddress  shippingAddress){
		
		if(!shippingAddress.isChanged()){
			return shippingAddress;
		}
		
		
		String SQL=this.getSaveShippingAddressSQL(shippingAddress);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveShippingAddressParameters(shippingAddress);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		shippingAddress.incVersion();
		return shippingAddress;
	
	}
	public SmartList<ShippingAddress> saveShippingAddressList(SmartList<ShippingAddress> shippingAddressList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitShippingAddressList(shippingAddressList);
		
		batchShippingAddressCreate((List<ShippingAddress>)lists[CREATE_LIST_INDEX]);
		
		batchShippingAddressUpdate((List<ShippingAddress>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ShippingAddress shippingAddress:shippingAddressList){
			if(shippingAddress.isChanged()){
				shippingAddress.incVersion();
			}
			
		
		}
		
		
		return shippingAddressList;
	}

	public SmartList<ShippingAddress> removeShippingAddressList(SmartList<ShippingAddress> shippingAddressList,Map<String,Object> options){
		
		
		super.removeList(shippingAddressList, options);
		
		return shippingAddressList;
		
		
	}
	
	protected List<Object[]> prepareShippingAddressBatchCreateArgs(List<ShippingAddress> shippingAddressList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ShippingAddress shippingAddress:shippingAddressList ){
			Object [] parameters = prepareShippingAddressCreateParameters(shippingAddress);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareShippingAddressBatchUpdateArgs(List<ShippingAddress> shippingAddressList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ShippingAddress shippingAddress:shippingAddressList ){
			if(!shippingAddress.isChanged()){
				continue;
			}
			Object [] parameters = prepareShippingAddressUpdateParameters(shippingAddress);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchShippingAddressCreate(List<ShippingAddress> shippingAddressList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareShippingAddressBatchCreateArgs(shippingAddressList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchShippingAddressUpdate(List<ShippingAddress> shippingAddressList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareShippingAddressBatchUpdateArgs(shippingAddressList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitShippingAddressList(List<ShippingAddress> shippingAddressList){
		
		List<ShippingAddress> shippingAddressCreateList=new ArrayList<ShippingAddress>();
		List<ShippingAddress> shippingAddressUpdateList=new ArrayList<ShippingAddress>();
		
		for(ShippingAddress shippingAddress: shippingAddressList){
			if(isUpdateRequest(shippingAddress)){
				shippingAddressUpdateList.add( shippingAddress);
				continue;
			}
			shippingAddressCreateList.add(shippingAddress);
		}
		
		return new Object[]{shippingAddressCreateList,shippingAddressUpdateList};
	}
	
	protected boolean isUpdateRequest(ShippingAddress shippingAddress){
 		return shippingAddress.getVersion() > 0;
 	}
 	protected String getSaveShippingAddressSQL(ShippingAddress shippingAddress){
 		if(isUpdateRequest(shippingAddress)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveShippingAddressParameters(ShippingAddress shippingAddress){
 		if(isUpdateRequest(shippingAddress) ){
 			return prepareShippingAddressUpdateParameters(shippingAddress);
 		}
 		return prepareShippingAddressCreateParameters(shippingAddress);
 	}
 	protected Object[] prepareShippingAddressUpdateParameters(ShippingAddress shippingAddress){
 		Object[] parameters = new Object[12];
 
 		parameters[0] = shippingAddress.getName();
 		parameters[1] = shippingAddress.getCardNumber();
 		parameters[2] = shippingAddress.getAddressLine1();
 		parameters[3] = shippingAddress.getAddressLine2();
 		parameters[4] = shippingAddress.getAddressLine3();
 		parameters[5] = shippingAddress.getCity();
 		parameters[6] = shippingAddress.getState();
 		parameters[7] = shippingAddress.getZipCode(); 	
 		if(shippingAddress.getProfile() != null){
 			parameters[8] = shippingAddress.getProfile().getId();
 		}
 		
 		parameters[9] = shippingAddress.nextVersion();
 		parameters[10] = shippingAddress.getId();
 		parameters[11] = shippingAddress.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareShippingAddressCreateParameters(ShippingAddress shippingAddress){
		Object[] parameters = new Object[10];
		String newShippingAddressId=getNextId();
		shippingAddress.setId(newShippingAddressId);
		parameters[0] =  shippingAddress.getId();
 
 		parameters[1] = shippingAddress.getName();
 		parameters[2] = shippingAddress.getCardNumber();
 		parameters[3] = shippingAddress.getAddressLine1();
 		parameters[4] = shippingAddress.getAddressLine2();
 		parameters[5] = shippingAddress.getAddressLine3();
 		parameters[6] = shippingAddress.getCity();
 		parameters[7] = shippingAddress.getState();
 		parameters[8] = shippingAddress.getZipCode(); 	
 		if(shippingAddress.getProfile() != null){
 			parameters[9] = shippingAddress.getProfile().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected ShippingAddress saveInternalShippingAddress(ShippingAddress shippingAddress, Map<String,Object> options){
		
		saveShippingAddress(shippingAddress);
 	
 		if(isSaveProfileEnabled(options)){
	 		saveProfile(shippingAddress, options);
 		}
 
		
		return shippingAddress;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ShippingAddress saveProfile(ShippingAddress shippingAddress, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(shippingAddress.getProfile() == null){
 			return shippingAddress;//do nothing when it is null
 		}
 		
 		getProfileDAO().save(shippingAddress.getProfile(),options);
 		return shippingAddress;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public ShippingAddress present(ShippingAddress shippingAddress,Map<String, Object> options){
	

		return shippingAddress;
	
	}
		

	

	protected String getTableName(){
		return ShippingAddressTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ShippingAddress> shippingAddressList) {		
		this.enhanceListInternal(shippingAddressList, this.getShippingAddressMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ShippingAddress> shippingAddressList = ownerEntity.collectRefsWithType(ShippingAddress.INTERNAL_TYPE);
		this.enhanceList(shippingAddressList);
		
	}
	
	@Override
	public SmartList<ShippingAddress> findShippingAddressWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getShippingAddressMapper());

	}
	@Override
	public int countShippingAddressWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countShippingAddressWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ShippingAddress> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getShippingAddressMapper());
	}
}


