import { combineReducers } from 'redux';
import counterReducer from './CounterReducer';
import customerReducer from './CustomerReducer';
import homeReducer from './HomeReducer';
 
const rootReducer = combineReducers({
 
    counterReducer,
    customerReducer,
    homeReducer
 
});
 
export default rootReducer;