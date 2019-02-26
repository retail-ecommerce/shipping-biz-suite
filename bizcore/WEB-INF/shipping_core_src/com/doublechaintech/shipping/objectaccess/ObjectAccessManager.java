
package com.doublechaintech.shipping.objectaccess;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.shipping.ShippingUserContext;
import com.doublechaintech.shipping.BaseEntity;
import com.doublechaintech.shipping.SmartList;

public interface ObjectAccessManager{

		

	public ObjectAccess createObjectAccess(ShippingUserContext userContext, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9, String appId) throws Exception;	
	public ObjectAccess updateObjectAccess(ShippingUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ObjectAccess loadObjectAccess(ShippingUserContext userContext, String objectAccessId, String [] tokensExpr) throws Exception;
	public ObjectAccess internalSaveObjectAccess(ShippingUserContext userContext, ObjectAccess objectAccess) throws Exception;
	public ObjectAccess internalSaveObjectAccess(ShippingUserContext userContext, ObjectAccess objectAccess,Map<String,Object>option) throws Exception;
	
	public ObjectAccess transferToAnotherApp(ShippingUserContext userContext, String objectAccessId, String anotherAppId)  throws Exception;
 

	public void delete(ShippingUserContext userContext, String objectAccessId, int version) throws Exception;
	public int deleteAll(ShippingUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(ShippingUserContext userContext, ObjectAccess newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}

