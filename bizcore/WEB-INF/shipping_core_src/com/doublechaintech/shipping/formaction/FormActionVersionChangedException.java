
package com.doublechaintech.shipping.formaction;
import com.doublechaintech.shipping.EntityNotFoundException;

public class FormActionVersionChangedException extends FormActionManagerException {
	private static final long serialVersionUID = 1L;
	public FormActionVersionChangedException(String string) {
		super(string);
	}


}


