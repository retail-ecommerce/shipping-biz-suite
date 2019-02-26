
package com.doublechaintech.shipping.shippingaddress;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.shipping.ShippingUserContext;
import com.doublechaintech.shipping.BaseEntity;
import com.doublechaintech.shipping.SmartList;

public interface ShippingAddressManager{

		

	public ShippingAddress createShippingAddress(ShippingUserContext userContext, String name, String cardNumber, String addressLine1, String addressLine2, String addressLine3, String city, String state, String zipCode, String profileId) throws Exception;	
	public ShippingAddress updateShippingAddress(ShippingUserContext userContext,String shippingAddressId, int shippingAddressVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ShippingAddress loadShippingAddress(ShippingUserContext userContext, String shippingAddressId, String [] tokensExpr) throws Exception;
	public ShippingAddress internalSaveShippingAddress(ShippingUserContext userContext, ShippingAddress shippingAddress) throws Exception;
	public ShippingAddress internalSaveShippingAddress(ShippingUserContext userContext, ShippingAddress shippingAddress,Map<String,Object>option) throws Exception;
	
	public ShippingAddress transferToAnotherProfile(ShippingUserContext userContext, String shippingAddressId, String anotherProfileId)  throws Exception;
 

	public void delete(ShippingUserContext userContext, String shippingAddressId, int version) throws Exception;
	public int deleteAll(ShippingUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(ShippingUserContext userContext, ShippingAddress newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


