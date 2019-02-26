
package com.doublechaintech.shipping.formmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.shipping.ShippingUserContext;
import com.doublechaintech.shipping.BaseEntity;
import com.doublechaintech.shipping.SmartList;

public interface FormMessageManager{

		

	public FormMessage createFormMessage(ShippingUserContext userContext, String title, String formId, String level) throws Exception;	
	public FormMessage updateFormMessage(ShippingUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormMessage loadFormMessage(ShippingUserContext userContext, String formMessageId, String [] tokensExpr) throws Exception;
	public FormMessage internalSaveFormMessage(ShippingUserContext userContext, FormMessage formMessage) throws Exception;
	public FormMessage internalSaveFormMessage(ShippingUserContext userContext, FormMessage formMessage,Map<String,Object>option) throws Exception;
	
	public FormMessage transferToAnotherForm(ShippingUserContext userContext, String formMessageId, String anotherFormId)  throws Exception;
 

	public void delete(ShippingUserContext userContext, String formMessageId, int version) throws Exception;
	public int deleteAll(ShippingUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(ShippingUserContext userContext, FormMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


