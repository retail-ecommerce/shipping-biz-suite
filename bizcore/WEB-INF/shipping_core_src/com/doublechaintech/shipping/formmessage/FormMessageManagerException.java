
package com.doublechaintech.shipping.formmessage;
//import com.doublechaintech.shipping.EntityNotFoundException;
import com.doublechaintech.shipping.ShippingException;
import com.doublechaintech.shipping.Message;
import java.util.List;

public class FormMessageManagerException extends ShippingException {
	private static final long serialVersionUID = 1L;
	public FormMessageManagerException(String string) {
		super(string);
	}
	public FormMessageManagerException(Message message) {
		super(message);
	}
	public FormMessageManagerException(List<Message> messageList) {
		super(messageList);
	}

}


