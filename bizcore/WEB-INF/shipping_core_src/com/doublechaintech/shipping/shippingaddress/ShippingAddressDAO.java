
package com.doublechaintech.shipping.shippingaddress;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.shipping.BaseEntity;
import com.doublechaintech.shipping.SmartList;
import com.doublechaintech.shipping.MultipleAccessKey;
import com.doublechaintech.shipping.ShippingUserContext;
import com.doublechaintech.shipping.profile.ProfileDAO;


public interface ShippingAddressDAO{

	
	public ShippingAddress load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ShippingAddress> shippingAddressList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ShippingAddress present(ShippingAddress shippingAddress,Map<String,Object> options) throws Exception;
	public ShippingAddress clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ShippingAddress save(ShippingAddress shippingAddress,Map<String,Object> options);
	public SmartList<ShippingAddress> saveShippingAddressList(SmartList<ShippingAddress> shippingAddressList,Map<String,Object> options);
	public SmartList<ShippingAddress> removeShippingAddressList(SmartList<ShippingAddress> shippingAddressList,Map<String,Object> options);
	public SmartList<ShippingAddress> findShippingAddressWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countShippingAddressWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countShippingAddressWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String shippingAddressId, int version) throws Exception;
	public ShippingAddress disconnectFromAll(String shippingAddressId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ShippingAddress> queryList(String sql, Object ... parmeters);
 
 	public SmartList<ShippingAddress> findShippingAddressByProfile(String profileId, Map<String,Object> options);
 	public int countShippingAddressByProfile(String profileId, Map<String,Object> options);
 	public Map<String, Integer> countShippingAddressByProfileIds(String[] ids, Map<String,Object> options);
 	public SmartList<ShippingAddress> findShippingAddressByProfile(String profileId, int start, int count, Map<String,Object> options);
 	public void analyzeShippingAddressByProfile(SmartList<ShippingAddress> resultList, String profileId, Map<String,Object> options);

 
 }


