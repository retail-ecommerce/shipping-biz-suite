
package com.doublechaintech.shipping.profile;
import com.doublechaintech.shipping.EntityNotFoundException;

public class ProfileVersionChangedException extends ProfileManagerException {
	private static final long serialVersionUID = 1L;
	public ProfileVersionChangedException(String string) {
		super(string);
	}


}


