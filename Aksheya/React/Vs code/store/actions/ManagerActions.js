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

export const createAddressSuccess = (address) => {
    return {
        type: 'CREATE_ADDRESS_SUCCESS',
        payload: address
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

export const fetchAllOfficeSuccess = (offices) => {
    
    return {
        type: 'FETCH_ALL_OFFICE_SUCCESS',
        offices
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

export const deleteOfficeSuccess = (deleteMessage) => {
    return {
        type: 'DELETE_OFFICE_SUCCESS',
        payload: deleteMessage
    }
};
 
export const deleteOfficeFailure = () => {
    return {
        type: 'DELETE_OFFICE_FAILURE'
    }
};

export const createManager = (payload) => {

    let data = {
        name: payload.name,
        office:{
            officeid: Number(payload.officeid),
        },
        password: payload.password,
        role: payload.role,
        managerid: payload.managerid
    }
    return (dispatch) => {
        return Axios.post(apiUrl + `/managerid=` + data.managerid + `/addManager`, data)
            .then(response => {
                dispatch(createManagerSuccess(response.data))
            })
            .catch(error => {
                throw (error);
            });
    };
};

export const createStaff = (payload) => {

    let data = {
        name: payload.name,
        office:{
            officeid: Number(payload.officeid),
        },
        role: payload.role,
        managerid: payload.managerid
    }
    return (dispatch) => {
        return Axios.post(apiUrl + `/managerid=` + data.managerid + `/addStaff`, data)
            .then(response => {
                dispatch(createStaffSuccess(response.data))
            })
            .catch(error => {
                throw (error);
            });
    };
};

export const createOffice = (payload) => {

    let data = {
        openingTime: payload.openingTime,
        closingTime: payload.closingTime,
        managerid: payload.managerid

    }

    return (dispatch) => {
        return Axios.post(apiUrl + `/managerid=` + data.managerid + `/addOffice`, data)
            .then(response => {
                dispatch(createOfficeSuccess(response.data))
            })
            .catch(error => {
                throw (error);
            });
    };
};

export const createAddress = (payload) => {

    let data = {
        city: payload.city,
        country: payload.country,
        houseNo: payload.houseNo,
        state: payload.state,
        street: payload.street,
        zip: Number(payload.zip),
        office:{
            officeid: Number(payload.officeid),
        },
        managerid: Number(payload.managerid)
    }
    return (dispatch) => {
        return Axios.post(apiUrl + `/managerid=` + data.managerid + `/registerAddress`, data)
            .then(response => {
                dispatch(createAddressSuccess(response.data))
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

export const fetchAllOffice = (managerid) => {

    Number(managerid);
    
    return dispatch => {
        
        return Axios.get(apiUrl + `/managerid=` + managerid + `/getAllOffice`)
            .then(resp => {
                    
                dispatch(fetchAllOfficeSuccess(resp.data))
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

export const doDeleteOffice = (payload) => {
    let data = {
        officeid: Number(payload.officeid),
        managerid: Number(payload.managerid)
    }   
    return (dispatch) => {
        return Axios.delete(apiUrl + `/managerid=${data.managerid}/deleteOffice/${data.officeid}`, data)
            .then(response => {
                dispatch(deleteOfficeSuccess(response.data))
            })
            .catch(error => {
                dispatch(deleteOfficeFailure());
            });
    };
    
};