import { combineReducers } from 'redux';
import counterReducer from './CounterReducer';
import customerReducer from './CustomerReducer';
import homeReducer from './HomeReducer';
import managerReducer from './ManagerReducer';
 
const rootReducer = combineReducers({
 
    counterReducer,
    customerReducer,
    homeReducer,
    managerReducer
 
});
 
export default rootReducer;