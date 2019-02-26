
package com.doublechaintech.shipping.shippingaddress;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.shipping.BaseEntity;
import com.doublechaintech.shipping.SmartList;
import com.doublechaintech.shipping.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.shipping.profile.Profile;

@JsonSerialize(using = ShippingAddressSerializer.class)
public class ShippingAddress extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CARD_NUMBER_PROPERTY           = "cardNumber"        ;
	public static final String ADDRESS_LINE1_PROPERTY         = "addressLine1"      ;
	public static final String ADDRESS_LINE2_PROPERTY         = "addressLine2"      ;
	public static final String ADDRESS_LINE3_PROPERTY         = "addressLine3"      ;
	public static final String CITY_PROPERTY                  = "city"              ;
	public static final String STATE_PROPERTY                 = "state"             ;
	public static final String ZIP_CODE_PROPERTY              = "zipCode"           ;
	public static final String PROFILE_PROPERTY               = "profile"           ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="ShippingAddress";
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
	protected		String              	mCardNumber         ;
	protected		String              	mAddressLine1       ;
	protected		String              	mAddressLine2       ;
	protected		String              	mAddressLine3       ;
	protected		String              	mCity               ;
	protected		String              	mState              ;
	protected		String              	mZipCode            ;
	protected		Profile             	mProfile            ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ShippingAddress(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setProfile( null );

		this.changed = true;
	}
	
	public 	ShippingAddress(String name, String cardNumber, String addressLine1, String addressLine2, String addressLine3, String city, String state, String zipCode, Profile profile)
	{
		setName(name);
		setCardNumber(cardNumber);
		setAddressLine1(addressLine1);
		setAddressLine2(addressLine2);
		setAddressLine3(addressLine3);
		setCity(city);
		setState(state);
		setZipCode(zipCode);
		setProfile(profile);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CARD_NUMBER_PROPERTY.equals(property)){
			changeCardNumberProperty(newValueExpr);
		}
		if(ADDRESS_LINE1_PROPERTY.equals(property)){
			changeAddressLine1Property(newValueExpr);
		}
		if(ADDRESS_LINE2_PROPERTY.equals(property)){
			changeAddressLine2Property(newValueExpr);
		}
		if(ADDRESS_LINE3_PROPERTY.equals(property)){
			changeAddressLine3Property(newValueExpr);
		}
		if(CITY_PROPERTY.equals(property)){
			changeCityProperty(newValueExpr);
		}
		if(STATE_PROPERTY.equals(property)){
			changeStateProperty(newValueExpr);
		}
		if(ZIP_CODE_PROPERTY.equals(property)){
			changeZipCodeProperty(newValueExpr);
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
			
			
			
	protected void changeCardNumberProperty(String newValueExpr){
		String oldValue = getCardNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCardNumber(newValue);
		this.onChangeProperty(CARD_NUMBER_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeAddressLine1Property(String newValueExpr){
		String oldValue = getAddressLine1();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAddressLine1(newValue);
		this.onChangeProperty(ADDRESS_LINE1_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeAddressLine2Property(String newValueExpr){
		String oldValue = getAddressLine2();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAddressLine2(newValue);
		this.onChangeProperty(ADDRESS_LINE2_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeAddressLine3Property(String newValueExpr){
		String oldValue = getAddressLine3();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAddressLine3(newValue);
		this.onChangeProperty(ADDRESS_LINE3_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCityProperty(String newValueExpr){
		String oldValue = getCity();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCity(newValue);
		this.onChangeProperty(CITY_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeStateProperty(String newValueExpr){
		String oldValue = getState();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateState(newValue);
		this.onChangeProperty(STATE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeZipCodeProperty(String newValueExpr){
		String oldValue = getZipCode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateZipCode(newValue);
		this.onChangeProperty(ZIP_CODE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public ShippingAddress updateId(String id){
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
	public ShippingAddress updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setCardNumber(String cardNumber){
		this.mCardNumber = trimString(cardNumber);;
	}
	public String getCardNumber(){
		return this.mCardNumber;
	}
	public ShippingAddress updateCardNumber(String cardNumber){
		this.mCardNumber = trimString(cardNumber);;
		this.changed = true;
		return this;
	}
	public void mergeCardNumber(String cardNumber){
		if(cardNumber != null) { setCardNumber(cardNumber);}
	}
	
	
	public void setAddressLine1(String addressLine1){
		this.mAddressLine1 = trimString(addressLine1);;
	}
	public String getAddressLine1(){
		return this.mAddressLine1;
	}
	public ShippingAddress updateAddressLine1(String addressLine1){
		this.mAddressLine1 = trimString(addressLine1);;
		this.changed = true;
		return this;
	}
	public void mergeAddressLine1(String addressLine1){
		if(addressLine1 != null) { setAddressLine1(addressLine1);}
	}
	
	
	public void setAddressLine2(String addressLine2){
		this.mAddressLine2 = trimString(addressLine2);;
	}
	public String getAddressLine2(){
		return this.mAddressLine2;
	}
	public ShippingAddress updateAddressLine2(String addressLine2){
		this.mAddressLine2 = trimString(addressLine2);;
		this.changed = true;
		return this;
	}
	public void mergeAddressLine2(String addressLine2){
		if(addressLine2 != null) { setAddressLine2(addressLine2);}
	}
	
	
	public void setAddressLine3(String addressLine3){
		this.mAddressLine3 = trimString(addressLine3);;
	}
	public String getAddressLine3(){
		return this.mAddressLine3;
	}
	public ShippingAddress updateAddressLine3(String addressLine3){
		this.mAddressLine3 = trimString(addressLine3);;
		this.changed = true;
		return this;
	}
	public void mergeAddressLine3(String addressLine3){
		if(addressLine3 != null) { setAddressLine3(addressLine3);}
	}
	
	
	public void setCity(String city){
		this.mCity = trimString(city);;
	}
	public String getCity(){
		return this.mCity;
	}
	public ShippingAddress updateCity(String city){
		this.mCity = trimString(city);;
		this.changed = true;
		return this;
	}
	public void mergeCity(String city){
		if(city != null) { setCity(city);}
	}
	
	
	public void setState(String state){
		this.mState = trimString(state);;
	}
	public String getState(){
		return this.mState;
	}
	public ShippingAddress updateState(String state){
		this.mState = trimString(state);;
		this.changed = true;
		return this;
	}
	public void mergeState(String state){
		if(state != null) { setState(state);}
	}
	
	
	public void setZipCode(String zipCode){
		this.mZipCode = trimString(zipCode);;
	}
	public String getZipCode(){
		return this.mZipCode;
	}
	public ShippingAddress updateZipCode(String zipCode){
		this.mZipCode = trimString(zipCode);;
		this.changed = true;
		return this;
	}
	public void mergeZipCode(String zipCode){
		if(zipCode != null) { setZipCode(zipCode);}
	}
	
	
	public void setProfile(Profile profile){
		this.mProfile = profile;;
	}
	public Profile getProfile(){
		return this.mProfile;
	}
	public ShippingAddress updateProfile(Profile profile){
		this.mProfile = profile;;
		this.changed = true;
		return this;
	}
	public void mergeProfile(Profile profile){
		if(profile != null) { setProfile(profile);}
	}
	
	
	public void clearProfile(){
		setProfile ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public ShippingAddress updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getProfile(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, CARD_NUMBER_PROPERTY, getCardNumber());
		appendKeyValuePair(result, ADDRESS_LINE1_PROPERTY, getAddressLine1());
		appendKeyValuePair(result, ADDRESS_LINE2_PROPERTY, getAddressLine2());
		appendKeyValuePair(result, ADDRESS_LINE3_PROPERTY, getAddressLine3());
		appendKeyValuePair(result, CITY_PROPERTY, getCity());
		appendKeyValuePair(result, STATE_PROPERTY, getState());
		appendKeyValuePair(result, ZIP_CODE_PROPERTY, getZipCode());
		appendKeyValuePair(result, PROFILE_PROPERTY, getProfile());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ShippingAddress){
		
		
			ShippingAddress dest =(ShippingAddress)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setCardNumber(getCardNumber());
			dest.setAddressLine1(getAddressLine1());
			dest.setAddressLine2(getAddressLine2());
			dest.setAddressLine3(getAddressLine3());
			dest.setCity(getCity());
			dest.setState(getState());
			dest.setZipCode(getZipCode());
			dest.setProfile(getProfile());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ShippingAddress){
		
			
			ShippingAddress dest =(ShippingAddress)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCardNumber(getCardNumber());
			dest.mergeAddressLine1(getAddressLine1());
			dest.mergeAddressLine2(getAddressLine2());
			dest.mergeAddressLine3(getAddressLine3());
			dest.mergeCity(getCity());
			dest.mergeState(getState());
			dest.mergeZipCode(getZipCode());
			dest.mergeProfile(getProfile());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ShippingAddress{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcardNumber='"+getCardNumber()+"';");
		stringBuilder.append("\taddressLine1='"+getAddressLine1()+"';");
		stringBuilder.append("\taddressLine2='"+getAddressLine2()+"';");
		stringBuilder.append("\taddressLine3='"+getAddressLine3()+"';");
		stringBuilder.append("\tcity='"+getCity()+"';");
		stringBuilder.append("\tstate='"+getState()+"';");
		stringBuilder.append("\tzipCode='"+getZipCode()+"';");
		if(getProfile() != null ){
 			stringBuilder.append("\tprofile='Profile("+getProfile().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

