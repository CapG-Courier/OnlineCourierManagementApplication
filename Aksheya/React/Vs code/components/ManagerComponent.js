import React from 'react';
import { Link } from 'react-router-dom';

export default class ManagerComponent extends React.Component{

    render(){

        return(

            <div>
                <h2>Manager Home Page</h2>
                <p>
                    <Link to={`/addManager`}>Add New Manager</Link>
                </p>
                <p>
                    <Link to={`/addStaff`}>Add New Staff</Link>
                </p>
                <p>
                    <Link to={`/deleteStaff`}>Delete Staff</Link>
                </p>
                <p>
                    <Link to={`/getStaff`}>Get Staff</Link>
                </p>
                <p>
                    <Link to={`/getAllStaff`}>Get Staff</Link>
                </p>
                <p>
                    <Link to={`/checkStatus`}>Check Status</Link>
                </p>
                <p>
                    <Link to={`/getComplaint`}>Get Complaint</Link>
                </p>
                <p>
                    <Link to={`/getAllComplaints`}>Get All Complaint</Link>
                </p>
                <p>
                    <Link to={`/getAllCouriers`}>Get All Couriers</Link>
                </p>
            </div>
        )

    }

}