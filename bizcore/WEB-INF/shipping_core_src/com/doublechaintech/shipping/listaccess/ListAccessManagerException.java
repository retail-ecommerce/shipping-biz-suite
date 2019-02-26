
package com.doublechaintech.shipping.listaccess;
//import com.doublechaintech.shipping.EntityNotFoundException;
import com.doublechaintech.shipping.ShippingException;
import com.doublechaintech.shipping.Message;
import java.util.List;

public class ListAccessManagerException extends ShippingException {
	private static final long serialVersionUID = 1L;
	public ListAccessManagerException(String string) {
		super(string);
	}
	public ListAccessManagerException(Message message) {
		super(message);
	}
	public ListAccessManagerException(List<Message> messageList) {
		super(messageList);
	}

}


