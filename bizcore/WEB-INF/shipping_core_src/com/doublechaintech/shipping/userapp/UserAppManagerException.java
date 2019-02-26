
package com.doublechaintech.shipping.userapp;
//import com.doublechaintech.shipping.EntityNotFoundException;
import com.doublechaintech.shipping.ShippingException;
import com.doublechaintech.shipping.Message;
import java.util.List;

public class UserAppManagerException extends ShippingException {
	private static final long serialVersionUID = 1L;
	public UserAppManagerException(String string) {
		super(string);
	}
	public UserAppManagerException(Message message) {
		super(message);
	}
	public UserAppManagerException(List<Message> messageList) {
		super(messageList);
	}

}


