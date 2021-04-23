const initialState = {

    statuses: [],
    isAuthInitiate: undefined,
    initiateMessage: undefined,
    isAuthClose: undefined,
    closeMessage: undefined,
    isAuthReject: undefined,
    rejectMessage: undefined
}

export default function ShipmentReducer(state = initialState, action) {

    switch (action.type) {

        case 'FETCH_ALL_STATUSES_SUCCESS':
            return {
                ...state,
                statuses: action.statuses
            };

        case 'INITIATE_SUCCESS':
            return {
                ...state,
                initiateMessage: action.payload,
                isAuthInitiate: true
            };
        case 'INITIATE_FAILURE':
            return {
                ...state,
                isAuthInitiate: false
            };

        case 'CLOSE_SUCCESS':
            return {
                ...state,
                closeMessage: action.payload,
                isAuthClose: true
            };
        case 'CLOSE_FAILURE':
            return {
                ...state,
                isAuthClose: false
            };
        
        case 'REJECT_SUCCESS':
            return {
                ...state,
                rejectMessage: action.payload,
                isAuthReject: true
            };
        case 'REJECT_FAILURE':
            return {
                ...state,
                isAuthReject: false
            };

        default:
            return state;

    }
}