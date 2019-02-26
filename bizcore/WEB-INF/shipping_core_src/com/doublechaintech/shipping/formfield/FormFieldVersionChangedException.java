
package com.doublechaintech.shipping.formfield;
import com.doublechaintech.shipping.EntityNotFoundException;

public class FormFieldVersionChangedException extends FormFieldManagerException {
	private static final long serialVersionUID = 1L;
	public FormFieldVersionChangedException(String string) {
		super(string);
	}


}


