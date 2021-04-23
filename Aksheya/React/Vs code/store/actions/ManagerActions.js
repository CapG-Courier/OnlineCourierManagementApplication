import Axios from 'axios';
 
// API URL
const apiUrl = 'http://localhost:8085/home';

export const createManagerSuccess = (manager) => {
    return {
        type: 'CREATE_MANAGER_SUCCESS',
        payload: manager
    }
};

export const createStaffSuccess = (staff) => {
    return {
        type: 'CREATE_STAFF_SUCCESS',
        payload: staff
    }
};

export const createOfficeSuccess = (office) => {
    return {
        type: 'CREATE_OFFICE_SUCCESS',
        payload: office
    }
};

export const checkStatusSuccess = (status) => {
    
    return {
        type: 'CHECK_STATUS_SUCCESS',
        status
    }
};

export const fetchAllStaffSuccess = (staffs) => {
    
    return {
        type: 'FETCH_ALL_STAFF_SUCCESS',
        staffs
    }
};

export const fetchStaffSuccess = (employee) => {
    
    return {
        type: 'FETCH_STAFF_SUCCESS',
        employee
    }
};

export const fetchCustomerSuccess = (customer) => {
    
    return {
        type: 'FETCH_CUSTOMER_SUCCESS',
        customer
    }
};

export const fetchAllComplaintsSuccess = (complaints) => {
    
    return {
        type: 'FETCH_ALL_COMPLAINTS_SUCCESS',
        complaints
    }
};

export const fetchAllCouriersSuccess = (couriers) => {
    
    return {
        type: 'FETCH_ALL_COURIERS_SUCCESS',
        couriers
    }
};

export const deleteSuccess = (deleteMessage) => {
    return {
        type: 'DELETE_SUCCESS',
        payload: deleteMessage
    }
};
 
export const deleteFailure = () => {
    return {
        type: 'DELETE_FAILURE'
    }
};

export const createManager = (payload, managerid) => {

    Number(managerid)

    let data = {
        name: payload.name,
        office:{
            officeid: Number(payload.officeid),
        },
        password: payload.password,
        role: payload.role
    }
    return (dispatch) => {
        return Axios.post(apiUrl + `/managerid=` + managerid + `/addManager`, data)
            .then(response => {
                dispatch(createManagerSuccess(response.data))
            })
            .catch(error => {
                throw (error);
            });
    };
};

export const createStaff = (payload, managerid) => {

    Number(managerid)

    let data = {
        name: payload.name,
        office:{
            officeid: Number(payload.officeid),
        },
        role: payload.role
    }
    return (dispatch) => {
        return Axios.post(apiUrl + `/managerid=` + managerid + `/addStaff`, data)
            .then(response => {
                dispatch(createStaffSuccess(response.data))
            })
            .catch(error => {
                throw (error);
            });
    };
};

export const createOffice = (payload, managerid) => {

    Number(managerid)

    let data = {
        openingTime: payload.openingtime,
        closingTime: payload.closingtime

    }

    return (dispatch) => {
        return Axios.post(apiUrl + `/managerid=` + managerid + `/addOffice`, data)
            .then(response => {
                dispatch(createOfficeSuccess(response.data))
            })
            .catch(error => {
                throw (error);
            });
    };
};

export const fetchAllStaff = (managerid) => {

    Number(managerid);
    
    return dispatch => {
        
        return Axios.get(apiUrl + `/managerid=` + managerid + `/getAllStaff`)
            .then(resp => {
                    
                dispatch(fetchAllStaffSuccess(resp.data))
            })
            .catch(error => {
                console.log(error);
                throw (error);
            });
    };
};

export const fetchStaff = (managerid, empid) => {

    Number(managerid)
    Number(empid);

    return dispatch => {

        return Axios.get(apiUrl + `/managerid=` + managerid + `/getStaff/` + empid)
            .then(resp => {
            
                dispatch(fetchStaffSuccess(resp.data))
            })
            .catch(error => {
                console.log(error);
                throw (error);
            });
    };
};

export const fetchCustomer = (managerid, customerid) => {

    Number(managerid)
    Number(customerid);

    return dispatch => {

        return Axios.get(apiUrl + `/managerid=` + managerid + `/getCustomer/customerid=` + customerid)
            .then(resp => {
            
                dispatch(fetchCustomerSuccess(resp.data))
            })
            .catch(error => {
                console.log(error);
                throw (error);
            });
    };
};

export const fetchAllComplaints = (managerid) => {

    Number(managerid);
    
    return dispatch => {
        
        return Axios.get(apiUrl + `/managerid=` + managerid + `/getAllComplaints`)
            .then(resp => {
                    
                dispatch(fetchAllComplaintsSuccess(resp.data))
            })
            .catch(error => {
                console.log(error);
                throw (error);
            });
    };
};

export const fetchAllCouriers = (managerid) => {

    Number(managerid);
    
    return dispatch => {
        
        return Axios.get(apiUrl + `/managerid=` + managerid + `/getAllCouriers`)
            .then(resp => {
                    
                dispatch(fetchAllCouriersSuccess(resp.data))
            })
            .catch(error => {
                console.log(error);
                throw (error);
            });
    };
};

export const doDelete = (payload) => {
    let data = {
        empid: Number(payload.empid),
        managerid: Number(payload.managerid)
    }   
    return (dispatch) => {
        return Axios.delete(apiUrl + `/managerid=${data.managerid}/deleteStaff/${data.empid}`, data)
            .then(response => {
                dispatch(deleteSuccess(response.data))
            })
            .catch(error => {
                dispatch(deleteFailure());
            });
    };
    
};