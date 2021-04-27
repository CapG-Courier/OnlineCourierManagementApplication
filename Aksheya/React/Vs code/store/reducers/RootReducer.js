import { combineReducers } from 'redux';
import customerReducer from './CustomerReducer';
import homeReducer from './HomeReducer';
import managerReducer from './ManagerReducer';
import shipmentReducer from './ShipmentReducer';
 
const rootReducer = combineReducers({
    
    customerReducer,
    homeReducer,
    managerReducer,
    shipmentReducer
 
});
 
export default rootReducer;