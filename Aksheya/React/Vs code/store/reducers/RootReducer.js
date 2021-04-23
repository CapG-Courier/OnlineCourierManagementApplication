import { combineReducers } from 'redux';
import counterReducer from './CounterReducer';
import customerReducer from './CustomerReducer';
import homeReducer from './HomeReducer';
import managerReducer from './ManagerReducer';
import shipmentReducer from './ShipmentReducer';
 
const rootReducer = combineReducers({
 
    counterReducer,
    customerReducer,
    homeReducer,
    managerReducer,
    shipmentReducer
 
});
 
export default rootReducer;