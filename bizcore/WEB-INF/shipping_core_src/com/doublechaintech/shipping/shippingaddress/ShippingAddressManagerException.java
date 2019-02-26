
package com.doublechaintech.shipping.shippingaddress;
//import com.doublechaintech.shipping.EntityNotFoundException;
import com.doublechaintech.shipping.ShippingException;
import com.doublechaintech.shipping.Message;
import java.util.List;

public class ShippingAddressManagerException extends ShippingException {
	private static final long serialVersionUID = 1L;
	public ShippingAddressManagerException(String string) {
		super(string);
	}
	public ShippingAddressManagerException(Message message) {
		super(message);
	}
	public ShippingAddressManagerException(List<Message> messageList) {
		super(messageList);
	}

}


