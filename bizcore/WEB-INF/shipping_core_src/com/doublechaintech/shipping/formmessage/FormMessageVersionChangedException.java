
package com.doublechaintech.shipping.formmessage;
import com.doublechaintech.shipping.EntityNotFoundException;

public class FormMessageVersionChangedException extends FormMessageManagerException {
	private static final long serialVersionUID = 1L;
	public FormMessageVersionChangedException(String string) {
		super(string);
	}


}


