
package com.doublechaintech.shipping.profile;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.shipping.ShippingUserContext;
import com.doublechaintech.shipping.BaseEntity;
import com.doublechaintech.shipping.SmartList;

public interface ProfileManager{

		

	public Profile createProfile(ShippingUserContext userContext, String name, String platformId) throws Exception;	
	public Profile updateProfile(ShippingUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Profile loadProfile(ShippingUserContext userContext, String profileId, String [] tokensExpr) throws Exception;
	public Profile internalSaveProfile(ShippingUserContext userContext, Profile profile) throws Exception;
	public Profile internalSaveProfile(ShippingUserContext userContext, Profile profile,Map<String,Object>option) throws Exception;
	
	public Profile transferToAnotherPlatform(ShippingUserContext userContext, String profileId, String anotherPlatformId)  throws Exception;
 

	public void delete(ShippingUserContext userContext, String profileId, int version) throws Exception;
	public int deleteAll(ShippingUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(ShippingUserContext userContext, Profile newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ShippingAddressManager getShippingAddressManager(ShippingUserContext userContext, String profileId, String name, String cardNumber, String addressLine1, String addressLine2, String addressLine3, String city, String state, String zipCode ,String [] tokensExpr)  throws Exception;
	
	public  Profile addShippingAddress(ShippingUserContext userContext, String profileId, String name, String cardNumber, String addressLine1, String addressLine2, String addressLine3, String city, String state, String zipCode , String [] tokensExpr)  throws Exception;
	public  Profile removeShippingAddress(ShippingUserContext userContext, String profileId, String shippingAddressId, int shippingAddressVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateShippingAddress(ShippingUserContext userContext, String profileId, String shippingAddressId, int shippingAddressVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


