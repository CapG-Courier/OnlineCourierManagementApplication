const initialState = {

    manager: undefined,
    staff: undefined,
    office: undefined,
    status: undefined,
    staffs: [],
    employee: {},
    complaints: [],
    customer: {}
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

        default:
            return state;

    }
}