import Axios from 'axios';

// let customerid = this.props.match.params.id
// const apiUrl = 'http://localhost:8085/home/customerid=' + customerid;
 
// API URL
const apiUrl = 'http://localhost:8085/home';
 
// Sync Action
export const fetchCustomerSuccess = (customer) => {
    
    return {
        type: 'FETCH_CUSTOMER_SUCCESS',
        customer
    }
};

export const createAddressSuccess = (address) => {
    return {
        type: 'CREATE_ADDRESS_SUCCESS',
        payload: address
    }
};

export const createCourierSuccess = (courier) => {
    return {
        type: 'CREATE_COURIER_SUCCESS',
        payload: courier
    }
};

export const createComplaintSuccess = (complaint) => {
    return {
        type: 'CREATE_COMPLAINT_SUCCESS',
        payload: complaint
    }
};

export const fetchAllCouriersSuccess = (couriers) => {
    
    return {
        type: 'FETCH_ALL_COURIERS_SUCCESS',
        couriers
    }
};

export const fetchAllComplaintsSuccess = (complaints) => {
    
    return {
        type: 'FETCH_ALL_COMPLAINTS_SUCCESS',
        complaints
    }
};

export const checkStatusSuccess = (status) => {
    
    return {
        type: 'CHECK_STATUS_SUCCESS',
        payload: status
    }
};
 
//Async Action
export const fetchCustomer = (customerid) => {

    Number(customerid);

    return dispatch => {

        return Axios.get(apiUrl + `/customerid=` + customerid + `/profile`)
            .then(resp => {
            
                dispatch(fetchCustomerSuccess(resp.data))
            })
            .catch(error => {
                console.log(error);
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
        customer:{
            customerid: Number(payload.customerid),
        }
    }
    return (dispatch) => {
        return Axios.post(apiUrl + `/customerid=${data.customer.customerid}/profile/addAddress`, data)
            .then(response => {
                dispatch(createAddressSuccess(response.data))
            })
            .catch(error => {
                throw (error);
            });
    };
};

export const createCourier = (payload) => {
    let data = {
        initiatedDate: payload.initiatedDate,
        customer:{
            customerid: Number(payload.customerid),
        }
    }
    return (dispatch) => {
        return Axios.post(apiUrl + `/customerid=${data.customer.customerid}/newCourier`, data)
            .then(response => {
                dispatch(createCourierSuccess(response.data))
            })
            .catch(error => {
                throw (error);
            });
    };
};

export const createComplaint = (payload) => {
    let data = {
        consignmentNo: payload.consignmentNo,
        detailDescription: payload.detailDescription,
        shortDescription: payload.shortDescription,
        customer:{
            customerid: Number(payload.customerid),
        }
    }
    return (dispatch) => {
        return Axios.post(apiUrl + `/customerid=${data.customer.customerid}/registerComplaint`, data)
            .then(response => {
                dispatch(createComplaintSuccess(response.data))
            })
            .catch(error => {
                throw (error);
            });
    };
};

export const fetchAllCouriers = (customerid) => {

    Number(customerid);
    
    return dispatch => {
        
        return Axios.get(apiUrl + `/customerid=` + customerid + `/getCouriers`)
            .then(resp => {
                    
                dispatch(fetchAllCouriersSuccess(resp.data))
            })
            .catch(error => {
                console.log(error);
                throw (error);
            });
    };
};

export const fetchAllComplaints = (customerid) => {

    Number(customerid);
    
    return dispatch => {
        
        return Axios.get(apiUrl + `/customerid=` + customerid + `/getComplaints`)
            .then(resp => {
                    
                dispatch(fetchAllComplaintsSuccess(resp.data))
            })
            .catch(error => {
                console.log(error);
                throw (error);
            });
    };
};