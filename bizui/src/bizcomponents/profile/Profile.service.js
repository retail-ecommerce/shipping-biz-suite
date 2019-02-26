import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}profileManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}profileManager/loadProfile/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}profileManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}profileManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addShippingAddress = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addShippingAddress/profileId/name/cardNumber/addressLine1/addressLine2/addressLine3/city/state/zipCode/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateShippingAddress = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateShippingAddressProperties/profileId/id/name/cardNumber/addressLine1/addressLine2/addressLine3/city/state/zipCode/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeShippingAddressList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeShippingAddressList/profileId/shippingAddressIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const ProfileService = { view,
  load,
  addShippingAddress,
  updateShippingAddress,
  removeShippingAddressList,
  requestCandidatePlatform,
  transferToAnotherPlatform }
export default ProfileService

