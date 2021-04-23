import Axios from 'axios';

// API URL
const apiUrl = 'http://localhost:8085/home';

export const fetchAllStatusesSuccess = (statuses) => {
    
    return {
        type: 'FETCH_ALL_STATUSES_SUCCESS',
        statuses
    }
};

export const initiateSuccess = (initiateMessage) => {
    return {
        type: 'INITIATE_SUCCESS',
        payload: initiateMessage
    }
};
 
export const initiateFailure = () => {
    return {
        type: 'INITIATE_FAILURE'
    }
};

export const closeSuccess = (closeMessage) => {
    return {
        type: 'CLOSE_SUCCESS',
        payload: closeMessage
    }
};
 
export const closeFailure = () => {
    return {
        type: 'CLOSE_FAILURE'
    }
};

export const rejectSuccess = (rejectMessage) => {
    return {
        type: 'REJECT_SUCCESS',
        payload: rejectMessage
    }
};
 
export const rejectFailure = () => {
    return {
        type: 'REJECT_FAILURE'
    }
};

export const fetchAllStatuses = (managerid) => {

    Number(managerid);
    
    return dispatch => {
        
        return Axios.get(apiUrl + `/managerid=` + managerid + `/getAllCouriers`)
            .then(resp => {
                    
                dispatch(fetchAllStatusesSuccess(resp.data))
            })
            .catch(error => {
                console.log(error);
                throw (error);
            });
    };
};

export const doInitiate = (payload) => {
    let data = {
        courierid: Number(payload.courierid),
        managerid: Number(payload.managerid)
    }   
    return (dispatch) => {
        return Axios.patch(apiUrl + `/managerid=${data.managerid}/shipment/initiate/${data.courierid}`, data)
            .then(response => {
                dispatch(initiateSuccess(response.data))
            })
            .catch(error => {
                dispatch(initiateFailure());
            });
    };
    
};

export const doClose = (payload) => {
    let data = {
        courierid: Number(payload.courierid),
        managerid: Number(payload.managerid)
    }   
    return (dispatch) => {
        return Axios.patch(apiUrl + `/managerid=${data.managerid}/shipment/close/${data.courierid}`, data)
            .then(response => {
                dispatch(closeSuccess(response.data))
            })
            .catch(error => {
                dispatch(closeFailure());
            });
    };
    
};

export const doReject = (payload) => {
    let data = {
        courierid: Number(payload.courierid),
        managerid: Number(payload.managerid)
    }   
    return (dispatch) => {
        return Axios.patch(apiUrl + `/managerid=${data.managerid}/shipment/reject/${data.courierid}`, data)
            .then(response => {
                dispatch(rejectSuccess(response.data))
            })
            .catch(error => {
                dispatch(rejectFailure());
            });
    };
    
};