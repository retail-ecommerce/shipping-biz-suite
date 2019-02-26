
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty shippingAddress}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A ShippingAddress">${userContext.localeMap['shipping_address']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./shippingAddressManager/view/${shippingAddress.id}/"> ${shippingAddress.id}</a></li>
<li><span>${userContext.localeMap['shipping_address.name']}</span> ${shippingAddress.name}</li>
<li><span>${userContext.localeMap['shipping_address.card_number']}</span> ${shippingAddress.cardNumber}</li>
<li><span>${userContext.localeMap['shipping_address.address_line1']}</span> ${shippingAddress.addressLine1}</li>
<li><span>${userContext.localeMap['shipping_address.address_line2']}</span> ${shippingAddress.addressLine2}</li>
<li><span>${userContext.localeMap['shipping_address.address_line3']}</span> ${shippingAddress.addressLine3}</li>
<li><span>${userContext.localeMap['shipping_address.city']}</span> ${shippingAddress.city}</li>
<li><span>${userContext.localeMap['shipping_address.state']}</span> ${shippingAddress.state}</li>
<li><span>${userContext.localeMap['shipping_address.zip_code']}</span> ${shippingAddress.zipCode}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




