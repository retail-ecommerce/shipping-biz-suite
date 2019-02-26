package com.doublechaintech.shipping;


import com.doublechaintech.shipping.platform.PlatformManager;

import com.doublechaintech.shipping.profile.ProfileManager;

import com.doublechaintech.shipping.shippingaddress.ShippingAddressManager;

import com.doublechaintech.shipping.userdomain.UserDomainManager;

import com.doublechaintech.shipping.userwhitelist.UserWhiteListManager;

import com.doublechaintech.shipping.secuser.SecUserManager;

import com.doublechaintech.shipping.secuserblocking.SecUserBlockingManager;

import com.doublechaintech.shipping.userapp.UserAppManager;

import com.doublechaintech.shipping.listaccess.ListAccessManager;

import com.doublechaintech.shipping.objectaccess.ObjectAccessManager;

import com.doublechaintech.shipping.loginhistory.LoginHistoryManager;

import com.doublechaintech.shipping.genericform.GenericFormManager;

import com.doublechaintech.shipping.formmessage.FormMessageManager;

import com.doublechaintech.shipping.formfieldmessage.FormFieldMessageManager;

import com.doublechaintech.shipping.formfield.FormFieldManager;

import com.doublechaintech.shipping.formaction.FormActionManager;


public class ManagerGroup {

	protected PlatformManager platformManager;

	protected ProfileManager profileManager;

	protected ShippingAddressManager shippingAddressManager;

	protected UserDomainManager userDomainManager;

	protected UserWhiteListManager userWhiteListManager;

	protected SecUserManager secUserManager;

	protected SecUserBlockingManager secUserBlockingManager;

	protected UserAppManager userAppManager;

	protected ListAccessManager listAccessManager;

	protected ObjectAccessManager objectAccessManager;

	protected LoginHistoryManager loginHistoryManager;

	protected GenericFormManager genericFormManager;

	protected FormMessageManager formMessageManager;

	protected FormFieldMessageManager formFieldMessageManager;

	protected FormFieldManager formFieldManager;

	protected FormActionManager formActionManager;

	

	public PlatformManager getPlatformManager(){
		return this.platformManager;
	}
	public void setPlatformManager(PlatformManager manager){
		this.platformManager = manager;
	}


	public ProfileManager getProfileManager(){
		return this.profileManager;
	}
	public void setProfileManager(ProfileManager manager){
		this.profileManager = manager;
	}


	public ShippingAddressManager getShippingAddressManager(){
		return this.shippingAddressManager;
	}
	public void setShippingAddressManager(ShippingAddressManager manager){
		this.shippingAddressManager = manager;
	}


	public UserDomainManager getUserDomainManager(){
		return this.userDomainManager;
	}
	public void setUserDomainManager(UserDomainManager manager){
		this.userDomainManager = manager;
	}


	public UserWhiteListManager getUserWhiteListManager(){
		return this.userWhiteListManager;
	}
	public void setUserWhiteListManager(UserWhiteListManager manager){
		this.userWhiteListManager = manager;
	}


	public SecUserManager getSecUserManager(){
		return this.secUserManager;
	}
	public void setSecUserManager(SecUserManager manager){
		this.secUserManager = manager;
	}


	public SecUserBlockingManager getSecUserBlockingManager(){
		return this.secUserBlockingManager;
	}
	public void setSecUserBlockingManager(SecUserBlockingManager manager){
		this.secUserBlockingManager = manager;
	}


	public UserAppManager getUserAppManager(){
		return this.userAppManager;
	}
	public void setUserAppManager(UserAppManager manager){
		this.userAppManager = manager;
	}


	public ListAccessManager getListAccessManager(){
		return this.listAccessManager;
	}
	public void setListAccessManager(ListAccessManager manager){
		this.listAccessManager = manager;
	}


	public ObjectAccessManager getObjectAccessManager(){
		return this.objectAccessManager;
	}
	public void setObjectAccessManager(ObjectAccessManager manager){
		this.objectAccessManager = manager;
	}


	public LoginHistoryManager getLoginHistoryManager(){
		return this.loginHistoryManager;
	}
	public void setLoginHistoryManager(LoginHistoryManager manager){
		this.loginHistoryManager = manager;
	}


	public GenericFormManager getGenericFormManager(){
		return this.genericFormManager;
	}
	public void setGenericFormManager(GenericFormManager manager){
		this.genericFormManager = manager;
	}


	public FormMessageManager getFormMessageManager(){
		return this.formMessageManager;
	}
	public void setFormMessageManager(FormMessageManager manager){
		this.formMessageManager = manager;
	}


	public FormFieldMessageManager getFormFieldMessageManager(){
		return this.formFieldMessageManager;
	}
	public void setFormFieldMessageManager(FormFieldMessageManager manager){
		this.formFieldMessageManager = manager;
	}


	public FormFieldManager getFormFieldManager(){
		return this.formFieldManager;
	}
	public void setFormFieldManager(FormFieldManager manager){
		this.formFieldManager = manager;
	}


	public FormActionManager getFormActionManager(){
		return this.formActionManager;
	}
	public void setFormActionManager(FormActionManager manager){
		this.formActionManager = manager;
	}


}









