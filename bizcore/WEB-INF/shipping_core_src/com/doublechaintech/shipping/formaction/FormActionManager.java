
package com.doublechaintech.shipping.formaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.shipping.ShippingUserContext;
import com.doublechaintech.shipping.BaseEntity;
import com.doublechaintech.shipping.SmartList;

public interface FormActionManager{

		

	public FormAction createFormAction(ShippingUserContext userContext, String label, String localeKey, String actionKey, String level, String url, String formId) throws Exception;	
	public FormAction updateFormAction(ShippingUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormAction loadFormAction(ShippingUserContext userContext, String formActionId, String [] tokensExpr) throws Exception;
	public FormAction internalSaveFormAction(ShippingUserContext userContext, FormAction formAction) throws Exception;
	public FormAction internalSaveFormAction(ShippingUserContext userContext, FormAction formAction,Map<String,Object>option) throws Exception;
	
	public FormAction transferToAnotherForm(ShippingUserContext userContext, String formActionId, String anotherFormId)  throws Exception;
 

	public void delete(ShippingUserContext userContext, String formActionId, int version) throws Exception;
	public int deleteAll(ShippingUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(ShippingUserContext userContext, FormAction newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}














