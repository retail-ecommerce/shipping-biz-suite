
package com.doublechaintech.shipping.userwhitelist;
//import com.doublechaintech.shipping.EntityNotFoundException;
import com.doublechaintech.shipping.ShippingException;
import com.doublechaintech.shipping.Message;
import java.util.List;

public class UserWhiteListManagerException extends ShippingException {
	private static final long serialVersionUID = 1L;
	public UserWhiteListManagerException(String string) {
		super(string);
	}
	public UserWhiteListManagerException(Message message) {
		super(message);
	}
	public UserWhiteListManagerException(List<Message> messageList) {
		super(messageList);
	}

}


