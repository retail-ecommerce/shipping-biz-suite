
package com.doublechaintech.shipping;
import java.util.Map;

import com.doublechaintech.shipping.platform.Platform;
import com.doublechaintech.shipping.profile.Profile;
import com.doublechaintech.shipping.shippingaddress.ShippingAddress;
import com.doublechaintech.shipping.userdomain.UserDomain;
import com.doublechaintech.shipping.userwhitelist.UserWhiteList;
import com.doublechaintech.shipping.secuser.SecUser;
import com.doublechaintech.shipping.secuserblocking.SecUserBlocking;
import com.doublechaintech.shipping.userapp.UserApp;
import com.doublechaintech.shipping.listaccess.ListAccess;
import com.doublechaintech.shipping.objectaccess.ObjectAccess;
import com.doublechaintech.shipping.loginhistory.LoginHistory;
import com.doublechaintech.shipping.genericform.GenericForm;
import com.doublechaintech.shipping.formmessage.FormMessage;
import com.doublechaintech.shipping.formfieldmessage.FormFieldMessage;
import com.doublechaintech.shipping.formfield.FormField;
import com.doublechaintech.shipping.formaction.FormAction;

public class BeanFactoryImpl{


	public Platform createPlatform(Map<String,Object> options){
		return new Platform();
	}


	public Profile createProfile(Map<String,Object> options){
		return new Profile();
	}


	public ShippingAddress createShippingAddress(Map<String,Object> options){
		return new ShippingAddress();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserWhiteList createUserWhiteList(Map<String,Object> options){
		return new UserWhiteList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public SecUserBlocking createSecUserBlocking(Map<String,Object> options){
		return new SecUserBlocking();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public ObjectAccess createObjectAccess(Map<String,Object> options){
		return new ObjectAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public GenericForm createGenericForm(Map<String,Object> options){
		return new GenericForm();
	}


	public FormMessage createFormMessage(Map<String,Object> options){
		return new FormMessage();
	}


	public FormFieldMessage createFormFieldMessage(Map<String,Object> options){
		return new FormFieldMessage();
	}


	public FormField createFormField(Map<String,Object> options){
		return new FormField();
	}


	public FormAction createFormAction(Map<String,Object> options){
		return new FormAction();
	}





}










