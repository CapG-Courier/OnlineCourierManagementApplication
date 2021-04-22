const initialState = {

    manager: undefined,
    staff: undefined,
    office: undefined,
    status: undefined
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

        default:
            return state;

    }
}