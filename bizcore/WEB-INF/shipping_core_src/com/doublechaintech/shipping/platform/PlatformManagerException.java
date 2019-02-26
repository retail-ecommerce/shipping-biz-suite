
package com.doublechaintech.shipping.platform;
//import com.doublechaintech.shipping.EntityNotFoundException;
import com.doublechaintech.shipping.ShippingException;
import com.doublechaintech.shipping.Message;
import java.util.List;

public class PlatformManagerException extends ShippingException {
	private static final long serialVersionUID = 1L;
	public PlatformManagerException(String string) {
		super(string);
	}
	public PlatformManagerException(Message message) {
		super(message);
	}
	public PlatformManagerException(List<Message> messageList) {
		super(messageList);
	}

}


