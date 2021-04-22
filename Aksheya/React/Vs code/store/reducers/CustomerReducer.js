const initialState = {

    customer: undefined,
    courier: undefined,
    status: undefined
}

export default function CustomerReducer(state = initialState, action) {

    switch (action.type) {

        case 'FETCH_CUSTOMER_SUCCESS':
            return {
                ...state,
                customer: action.customer
            };

        case 'CREATE_COURIER_SUCCESS':
            return {
                ...state,
                courier: action.payload 
            };

        case 'CHECK_STATUS_SUCCESS':
            return {
                ...state,
                status: action.status 
            };

        default:
            return state;

    }
}