
package com.doublechaintech.shipping.profile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.shipping.BaseEntity;
import com.doublechaintech.shipping.SmartList;
import com.doublechaintech.shipping.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.shipping.platform.Platform;
import com.doublechaintech.shipping.shippingaddress.ShippingAddress;

@JsonSerialize(using = ProfileSerializer.class)
public class Profile extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String SHIPPING_ADDRESS_LIST                    = "shippingAddressList";

	public static final String INTERNAL_TYPE="Profile";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ShippingAddress>	mShippingAddressList;
	
		
	public 	Profile(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPlatform( null );

		this.changed = true;
	}
	
	public 	Profile(String name, DateTime lastUpdateTime, Platform platform)
	{
		setName(name);
		setLastUpdateTime(lastUpdateTime);
		setPlatform(platform);

		this.mShippingAddressList = new SmartList<ShippingAddress>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLastUpdateTimeProperty(String newValueExpr){
		DateTime oldValue = getLastUpdateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLastUpdateTime(newValue);
		this.onChangeProperty(LAST_UPDATE_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Profile updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public Profile updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public Profile updateLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
		this.changed = true;
		return this;
	}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}
	
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public Profile updatePlatform(Platform platform){
		this.mPlatform = platform;;
		this.changed = true;
		return this;
	}
	public void mergePlatform(Platform platform){
		if(platform != null) { setPlatform(platform);}
	}
	
	
	public void clearPlatform(){
		setPlatform ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Profile updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<ShippingAddress> getShippingAddressList(){
		if(this.mShippingAddressList == null){
			this.mShippingAddressList = new SmartList<ShippingAddress>();
			this.mShippingAddressList.setListInternalName (SHIPPING_ADDRESS_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mShippingAddressList;	
	}
	public  void setShippingAddressList(SmartList<ShippingAddress> shippingAddressList){
		for( ShippingAddress shippingAddress:shippingAddressList){
			shippingAddress.setProfile(this);
		}

		this.mShippingAddressList = shippingAddressList;
		this.mShippingAddressList.setListInternalName (SHIPPING_ADDRESS_LIST );
		
	}
	
	public  void addShippingAddress(ShippingAddress shippingAddress){
		shippingAddress.setProfile(this);
		getShippingAddressList().add(shippingAddress);
	}
	public  void addShippingAddressList(SmartList<ShippingAddress> shippingAddressList){
		for( ShippingAddress shippingAddress:shippingAddressList){
			shippingAddress.setProfile(this);
		}
		getShippingAddressList().addAll(shippingAddressList);
	}
	public  void mergeShippingAddressList(SmartList<ShippingAddress> shippingAddressList){
		if(shippingAddressList==null){
			return;
		}
		if(shippingAddressList.isEmpty()){
			return;
		}
		addShippingAddressList( shippingAddressList );
		
	}
	public  ShippingAddress removeShippingAddress(ShippingAddress shippingAddressIndex){
		
		int index = getShippingAddressList().indexOf(shippingAddressIndex);
        if(index < 0){
        	String message = "ShippingAddress("+shippingAddressIndex.getId()+") with version='"+shippingAddressIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ShippingAddress shippingAddress = getShippingAddressList().get(index);        
        // shippingAddress.clearProfile(); //disconnect with Profile
        shippingAddress.clearFromAll(); //disconnect with Profile
		
		boolean result = getShippingAddressList().planToRemove(shippingAddress);
        if(!result){
        	String message = "ShippingAddress("+shippingAddressIndex.getId()+") with version='"+shippingAddressIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return shippingAddress;
        
	
	}
	//断舍离
	public  void breakWithShippingAddress(ShippingAddress shippingAddress){
		
		if(shippingAddress == null){
			return;
		}
		shippingAddress.setProfile(null);
		//getShippingAddressList().remove();
	
	}
	
	public  boolean hasShippingAddress(ShippingAddress shippingAddress){
	
		return getShippingAddressList().contains(shippingAddress);
  
	}
	
	public void copyShippingAddressFrom(ShippingAddress shippingAddress) {

		ShippingAddress shippingAddressInList = findTheShippingAddress(shippingAddress);
		ShippingAddress newShippingAddress = new ShippingAddress();
		shippingAddressInList.copyTo(newShippingAddress);
		newShippingAddress.setVersion(0);//will trigger copy
		getShippingAddressList().add(newShippingAddress);
		addItemToFlexiableObject(COPIED_CHILD, newShippingAddress);
	}
	
	public  ShippingAddress findTheShippingAddress(ShippingAddress shippingAddress){
		
		int index =  getShippingAddressList().indexOf(shippingAddress);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ShippingAddress("+shippingAddress.getId()+") with version='"+shippingAddress.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getShippingAddressList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpShippingAddressList(){
		getShippingAddressList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getShippingAddressList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getShippingAddressList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, SHIPPING_ADDRESS_LIST, getShippingAddressList());
		if(!getShippingAddressList().isEmpty()){
			appendKeyValuePair(result, "shippingAddressCount", getShippingAddressList().getTotalCount());
			appendKeyValuePair(result, "shippingAddressCurrentPageNumber", getShippingAddressList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Profile){
		
		
			Profile dest =(Profile)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());
			dest.setShippingAddressList(getShippingAddressList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Profile){
		
			
			Profile dest =(Profile)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergePlatform(getPlatform());
			dest.mergeVersion(getVersion());
			dest.mergeShippingAddressList(getShippingAddressList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Profile{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

