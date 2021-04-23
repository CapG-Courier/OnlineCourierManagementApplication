const initialState = {

    customer: undefined,
    courier: undefined,
    complaint: undefined,
    status: undefined,
    address: undefined,
    couriers: [],
    complaints: []
}

export default function CustomerReducer(state = initialState, action) {

    switch (action.type) {

        case 'FETCH_CUSTOMER_SUCCESS':
            return {
                ...state,
                customer: action.customer
            };

        case 'FETCH_ALL_COURIERS_SUCCESS':
            return {
                ...state,
                couriers: action.couriers
            };

        case 'FETCH_ALL_COMPLAINTS_SUCCESS':
            return {
                ...state,
                complaints: action.complaints
            };

        case 'CREATE_ADDRESS_SUCCESS':
            return {
                ...state,
                address: action.payload
            };

        case 'CREATE_COURIER_SUCCESS':
            return {
                ...state,
                courier: action.payload
            };

        case 'CREATE_COMPLAINT_SUCCESS':
            return {
                ...state,
                complaint: action.payload
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