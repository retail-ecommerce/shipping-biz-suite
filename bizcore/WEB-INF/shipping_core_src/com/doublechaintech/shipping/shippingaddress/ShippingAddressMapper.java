
package com.doublechaintech.shipping.shippingaddress;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.shipping.BaseRowMapper;
import com.doublechaintech.shipping.profile.Profile;

public class ShippingAddressMapper extends BaseRowMapper<ShippingAddress>{
	
	protected ShippingAddress internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ShippingAddress shippingAddress = getShippingAddress();		
		 		
 		setId(shippingAddress, rs, rowNumber); 		
 		setName(shippingAddress, rs, rowNumber); 		
 		setCardNumber(shippingAddress, rs, rowNumber); 		
 		setAddressLine1(shippingAddress, rs, rowNumber); 		
 		setAddressLine2(shippingAddress, rs, rowNumber); 		
 		setAddressLine3(shippingAddress, rs, rowNumber); 		
 		setCity(shippingAddress, rs, rowNumber); 		
 		setState(shippingAddress, rs, rowNumber); 		
 		setZipCode(shippingAddress, rs, rowNumber); 		
 		setProfile(shippingAddress, rs, rowNumber); 		
 		setVersion(shippingAddress, rs, rowNumber);

		return shippingAddress;
	}
	
	protected ShippingAddress getShippingAddress(){
		return new ShippingAddress();
	}		
		
	protected void setId(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ShippingAddressTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setId(id);
	}
		
	protected void setName(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ShippingAddressTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setName(name);
	}
		
	protected void setCardNumber(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String cardNumber = rs.getString(ShippingAddressTable.COLUMN_CARD_NUMBER);
		if(cardNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setCardNumber(cardNumber);
	}
		
	protected void setAddressLine1(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String addressLine1 = rs.getString(ShippingAddressTable.COLUMN_ADDRESS_LINE1);
		if(addressLine1 == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setAddressLine1(addressLine1);
	}
		
	protected void setAddressLine2(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String addressLine2 = rs.getString(ShippingAddressTable.COLUMN_ADDRESS_LINE2);
		if(addressLine2 == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setAddressLine2(addressLine2);
	}
		
	protected void setAddressLine3(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String addressLine3 = rs.getString(ShippingAddressTable.COLUMN_ADDRESS_LINE3);
		if(addressLine3 == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setAddressLine3(addressLine3);
	}
		
	protected void setCity(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String city = rs.getString(ShippingAddressTable.COLUMN_CITY);
		if(city == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setCity(city);
	}
		
	protected void setState(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String state = rs.getString(ShippingAddressTable.COLUMN_STATE);
		if(state == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setState(state);
	}
		
	protected void setZipCode(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String zipCode = rs.getString(ShippingAddressTable.COLUMN_ZIP_CODE);
		if(zipCode == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setZipCode(zipCode);
	}
		 		
 	protected void setProfile(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
 		String profileId = rs.getString(ShippingAddressTable.COLUMN_PROFILE);
 		if( profileId == null){
 			return;
 		}
 		if( profileId.isEmpty()){
 			return;
 		}
 		Profile profile = shippingAddress.getProfile();
 		if( profile != null ){
 			//if the root object 'shippingAddress' already have the property, just set the id for it;
 			profile.setId(profileId);
 			
 			return;
 		}
 		shippingAddress.setProfile(createEmptyProfile(profileId));
 	}
 	
	protected void setVersion(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ShippingAddressTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setVersion(version);
	}
		
		

 	protected Profile  createEmptyProfile(String profileId){
 		Profile profile = new Profile();
 		profile.setId(profileId);
 		profile.setVersion(Integer.MAX_VALUE);
 		return profile;
 	}
 	
}


