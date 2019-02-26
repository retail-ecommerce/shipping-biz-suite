
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'



const menuData = {menuName:"Shipping Address", menuFor: "shippingAddress",
  		subItems: [
  
  		],
}

const renderTextCell=(value, record)=>{
	const userContext = null
	if(!value){
		return '';
	}
	if(value==null){
		return '';
	}
	if(value.length>15){
		return value.substring(0,15)+"...("+value.length+appLocaleName(userContext,"Chars")+")"
	}
	return value
	
}

const renderIdentifier=(value, record, targtObjectType)=>{

	return (<Link to={`/${targtObjectType}/${value}/dashboard`}>{value}</Link>)
	
}

const renderDateCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD');
}
const renderDateTimeCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD HH:mm');	
}

const renderImageCell=(value, record, title)=>{
	return (<ImagePreview imageTitle={title} imageLocation={value} />)	
}

const renderMoneyCell=(value, record)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"Empty")
	}
	if(value == null){
		return appLocaleName(userContext,"Empty")
	}
	return (`${appLocaleName(userContext,"Currency")}${value.toFixed(2)}`)
}

const renderBooleanCell=(value, record)=>{
	const userContext = null

	return  (value? appLocaleName(userContext,"Yes") : appLocaleName(userContext,"No"))

}

const renderReferenceCell=(value, record)=>{
	const userContext = null
	return (value ? value.displayName : appLocaleName(userContext,"NotAssigned")) 

}

const displayColumns = [
  { title: 'Id', debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Name', debugtype: 'string', dataIndex: 'name', width: '23',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Card Number', debugtype: 'string', dataIndex: 'cardNumber', width: '18',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Address Line1', debugtype: 'string', dataIndex: 'addressLine1', width: '25',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Address Line2', debugtype: 'string', dataIndex: 'addressLine2', width: '13',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Address Line3', debugtype: 'string', dataIndex: 'addressLine3', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: 'City', debugtype: 'string', dataIndex: 'city', width: '16',render: (text, record)=>renderTextCell(text,record) },
  { title: 'State', debugtype: 'string', dataIndex: 'state', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Zip Code', debugtype: 'string', dataIndex: 'zipCode', width: '13',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Profile', dataIndex: 'profile', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  cardNumber: 'Card Number',
  addressLine1: 'Address Line1',
  addressLine2: 'Address Line2',
  addressLine3: 'Address Line3',
  city: 'City',
  state: 'State',
  zipCode: 'Zip Code',
  profile: 'Profile',

}


const ShippingAddressBase={menuData,displayColumns,fieldLabels}
export default ShippingAddressBase



