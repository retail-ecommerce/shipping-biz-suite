package com.doublechaintech.shipping.objectaccess;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.shipping.ShippingObjectPlainCustomSerializer;
public class ObjectAccessSerializer extends ShippingObjectPlainCustomSerializer<ObjectAccess>{

	@Override
	public void serialize(ObjectAccess objectAccess, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, objectAccess, provider);
		
	}
}


