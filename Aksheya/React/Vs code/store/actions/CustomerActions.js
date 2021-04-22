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

export const createCourierSuccess = (courier) => {
    return {
        type: 'CREATE_COURIER_SUCCESS',
        payload: courier
    }
};

export const checkStatusSuccess = (status) => {
    
    return {
        type: 'CHECK_STATUS_SUCCESS',
        status
    }
};
 
//Async Action
export const fetchCustomer = () => {

    return dispatch => {

        return Axios.get(apiUrl + '/customerid={customerid}/profile')
            .then(resp => {
            
                dispatch(fetchCustomerSuccess(resp.data))
            })
            .catch(error => {
                console.log(error);
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

export const checkStatus = () => {

    return dispatch => {

        return Axios.get(apiUrl + '/customerid={customerid}/checkStatus/{consignmentno}')
            .then(resp => {
            
                dispatch(fetchCustomerSuccess(resp.data))
            })
            .catch(error => {
                console.log(error);
                throw (error);
            });
    };
};
 
