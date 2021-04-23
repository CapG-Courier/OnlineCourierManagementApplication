const initialState = {

    manager: undefined,
    staff: undefined,
    office: undefined,
    status: undefined,
    deleteMessage: undefined,
    isAuthDelete: undefined,
    isAuthDeleteOffice: undefined,
    address: undefined,
    employee: {},
    customer: {},
    staffs: [],
    complaints: [],
    couriers: [],
    offices: []
}

export default function ManagerReducer(state = initialState, action) {

    switch (action.type) {

        case 'CREATE_MANAGER_SUCCESS':
            return {
                ...state,
                manager: action.payload
            };

        case 'CREATE_STAFF_SUCCESS':
            return {
                ...state,
                staff: action.payload
            };

        case 'CREATE_OFFICE_SUCCESS':
            return {
                ...state,
                office: action.payload
            };

        case 'CREATE_ADDRESS_SUCCESS':
            return {
                ...state,
                address: action.payload
            };

        case 'CHECK_STATUS_SUCCESS':
            return {
                ...state,
                status: action.status
            };

        case 'FETCH_ALL_STAFF_SUCCESS':
            return {
                ...state,
                staffs: action.staffs
            };

        case 'FETCH_STAFF_SUCCESS':
            return {
                ...state,
                employee: action.employee
            };

        case 'FETCH_CUSTOMER_SUCCESS':
            return {
                ...state,
                customer: action.customer
            };

        case 'FETCH_ALL_COMPLAINTS_SUCCESS':
            return {
                ...state,
                complaints: action.complaints
            };

        case 'FETCH_ALL_COURIERS_SUCCESS':
            return {
                ...state,
                couriers: action.couriers
            };

        case 'FETCH_ALL_OFFICE_SUCCESS':
            return {
                ...state,
                offices: action.offices
            };

        case 'DELETE_SUCCESS':
            return {
                ...state,
                deleteMessage: action.payload,
                isAuthDelete: true
            };
        case 'DELETE_FAILURE':
            return {
                ...state,
                isAuthDelete: false
            };

        case 'DELETE_OFFICE_SUCCESS':
            return {
                ...state,
                deleteMessage: action.payload,
                isAuthDeleteOffice: true
            };
        case 'DELETE_OFFICE_FAILURE':
            return {
                ...state,
                isAuthDeleteOffice: false
            };

        default:
            return state;

    }
}