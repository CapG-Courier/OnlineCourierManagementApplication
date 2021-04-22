const initialState = {
    loginMessage: undefined,
    isAuthCustomer: undefined,
    isAuthManager: undefined,
    newCustomer: undefined
}
 
export default function HomeReducer(state = initialState, action) {
 
    switch (action.type) {
 
        case 'LOGIN_SUCCESS':
            return {
                ...state,
                loginMessage: action.payload,
                isAuthCustomer: true
            };
        case 'LOGIN_FAILURE':
            return {
                ...state,
                isAuthCustomer: false
            };

        case 'LOGIN_SUCCESS_MANAGER':
            return {
                ...state,
                loginMessage: action.payload,
                isAuthManager: true
            };

        case 'LOGIN_FAILURE_MANAGER':
            return {
                ...state,
                isAuthManager: false
            };

        case 'CREATE_CUSTOMER_SUCCESS':
            return {
                ...state,
                newCustomer: action.payload
            };
 
        default:
            return state;
 
    }
}