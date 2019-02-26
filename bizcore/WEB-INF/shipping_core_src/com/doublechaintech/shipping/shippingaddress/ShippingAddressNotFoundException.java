
package com.doublechaintech.shipping.shippingaddress;
import com.doublechaintech.shipping.EntityNotFoundException;
public class ShippingAddressNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public ShippingAddressNotFoundException(String string) {
		super(string);
	}

}

