import React from 'react';
import { Link, useParams } from 'react-router-dom';

export default function ManagerComponent () {

    let { managerid } = useParams()
    Number(managerid);

    return(

        <div>
            <h2>Manager Home Page</h2>
            <p>
                <Link to={`/addManager/${managerid}`}>Add New Manager</Link>
            </p>
            <p>
                <Link to={`/addStaff/${managerid}`}>Add New Staff</Link>
            </p>
            <p>
                <Link to={`/addOffice/${managerid}`}>Add New Office</Link>
            </p>
            <p>
                <Link to={`/deleteStaff`}>Delete Staff</Link>
            </p>
            <p>
                <Link to={`/getAllStaff/${managerid}`}>Get All Staff</Link>
            </p>
            <p>
                <Link to={`/getAllComplaints/${managerid}`}>Get All Complaints</Link>
            </p>
            <p>
                <Link to={`/getAllCouriers/${managerid}`}>Get All Couriers</Link>
            </p>
            <p>
                <Link to={`/getAllOffice/${managerid}`}>Get All Offices</Link>
            </p>
            <p>
                <Link to={`/${managerid}/Shipment`}>Shipment</Link>
            </p>
        </div>
    )

}