
package com.doublechaintech.shipping.shippingaddress;
import com.doublechaintech.shipping.EntityNotFoundException;

public class ShippingAddressVersionChangedException extends ShippingAddressManagerException {
	private static final long serialVersionUID = 1L;
	public ShippingAddressVersionChangedException(String string) {
		super(string);
	}


}


