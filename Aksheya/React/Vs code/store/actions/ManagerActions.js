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

// export const checkStatus = () => {

//     return dispatch => {

//         return Axios.get(apiUrl + '/customerid={customerid}/checkStatus/{consignmentno}')
//             .then(resp => {
            
//                 dispatch(fetchCustomerSuccess(resp.data))
//             })
//             .catch(error => {
//                 console.log(error);
//                 throw (error);
//             });
//     };
// };