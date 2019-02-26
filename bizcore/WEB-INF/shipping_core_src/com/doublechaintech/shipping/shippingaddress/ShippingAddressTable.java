
package com.doublechaintech.shipping.shippingaddress;
import com.doublechaintech.shipping.AccessKey;


public class ShippingAddressTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="shipping_address_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_CARD_NUMBER = "card_number";
	static final String COLUMN_ADDRESS_LINE1 = "address_line1";
	static final String COLUMN_ADDRESS_LINE2 = "address_line2";
	static final String COLUMN_ADDRESS_LINE3 = "address_line3";
	static final String COLUMN_CITY = "city";
	static final String COLUMN_STATE = "state";
	static final String COLUMN_ZIP_CODE = "zip_code";
	static final String COLUMN_PROFILE = "profile";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_CARD_NUMBER, COLUMN_ADDRESS_LINE1, COLUMN_ADDRESS_LINE2, COLUMN_ADDRESS_LINE3, COLUMN_CITY, COLUMN_STATE, COLUMN_ZIP_CODE, COLUMN_PROFILE, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_CARD_NUMBER, COLUMN_ADDRESS_LINE1, COLUMN_ADDRESS_LINE2, COLUMN_ADDRESS_LINE3, COLUMN_CITY, COLUMN_STATE, COLUMN_ZIP_CODE, COLUMN_PROFILE
		};
	
	
}


