import Axios from 'axios';
 
// API URL
const apiUrl = 'http://localhost:8085';
 
export const loginSuccess = (loginMessage) => {
    return {
        type: 'LOGIN_SUCCESS',
        payload: loginMessage
    }
};
 
export const loginFailure = () => {
    return {
        type: 'LOGIN_FAILURE'
    }
};

export const loginSuccessManager = (loginMessage) => {
    return {
        type: 'LOGIN_SUCCESS_MANAGER',
        payload: loginMessage
    }
};
 
export const loginFailureManager = () => {
    return {
        type: 'LOGIN_FAILURE_MANAGER'
    }
};

export const createCustomerSuccess = (customer) => {
    return {
        type: 'CREATE_CUSTOMER_SUCCESS',
        payload: customer
    }
};
 
export const doLogin = (payload) => {
    let data = {
        customerid: Number(payload.customerid),
        password: payload.password
    }   
    return (dispatch) => {
        return Axios.post(apiUrl + `/home/login?customerid=${data.customerid}&password=${data.password}`, data)
            .then(response => {
                dispatch(loginSuccess(response.data))
            })
            .catch(error => {
                dispatch(loginFailure());
            });
    };
    
};

export const doLoginManager = (payload) => {
    let data = {
        empId: Number(payload.empId),
        password: payload.password
    }   
    return (dispatch) => {
        return Axios.post(apiUrl + `/home/managerLogin?empId=${data.empId}&password=${data.password}`, data)
            .then(response => {
                dispatch(loginSuccessManager(response.data))
            })
            .catch(error => {
                dispatch(loginFailureManager());
            });
    };
    
};

export const createCustomer = (payload) => {
    let data = {
        aadharno: Number(payload.aadharno),
        acct:{
            accountHolderName: payload.accountHolderName,
            accountType: payload.accountType,
            accountno: Number(payload.accountno)
        },
        firstname: payload.firstname,
        lastname: payload.lastname,
        mobileno: Number(payload.mobileno),
        password: payload.password
    }
    return (dispatch) => {
        return Axios.post(apiUrl + `/home/register`, data)
            .then(response => {
                dispatch(createCustomerSuccess(response.data))
            })
            .catch(error => {
                throw (error);
            });
    };
};