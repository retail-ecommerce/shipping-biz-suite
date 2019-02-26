
package com.doublechaintech.shipping.platform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.shipping.ShippingUserContext;
import com.doublechaintech.shipping.BaseEntity;
import com.doublechaintech.shipping.SmartList;

public interface PlatformManager{

		

	public Platform createPlatform(ShippingUserContext userContext, String name, String introduction, String currentVersion) throws Exception;	
	public Platform updatePlatform(ShippingUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Platform loadPlatform(ShippingUserContext userContext, String platformId, String [] tokensExpr) throws Exception;
	public Platform internalSavePlatform(ShippingUserContext userContext, Platform platform) throws Exception;
	public Platform internalSavePlatform(ShippingUserContext userContext, Platform platform,Map<String,Object>option) throws Exception;
	


	public void delete(ShippingUserContext userContext, String platformId, int version) throws Exception;
	public int deleteAll(ShippingUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(ShippingUserContext userContext, Platform newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ProfileManager getProfileManager(ShippingUserContext userContext, String platformId, String name ,String [] tokensExpr)  throws Exception;
	
	public  Platform addProfile(ShippingUserContext userContext, String platformId, String name , String [] tokensExpr)  throws Exception;
	public  Platform removeProfile(ShippingUserContext userContext, String platformId, String profileId, int profileVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateProfile(ShippingUserContext userContext, String platformId, String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


