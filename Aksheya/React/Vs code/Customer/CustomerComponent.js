import React from 'react';
import { Link } from 'react-router-dom';
import { useParams } from 'react-router-dom';

export default function CustomerComponent() {

    let { customerid } = useParams()
    Number(customerid);

    return (

        <div>
            <h2>Customer Home Page</h2>
            <p>
                <Link to={`/profile/${customerid}`}>Check Profile</Link>
            </p>
            <p>
                <Link to={`/newCourier`}>Initiate Courier</Link>
            </p>
            <p>
                <Link to={`/getCouriers/${customerid}`}>Get All Couriers</Link>
            </p>
            <p>
                <Link to={`/getComplaints/${customerid}`}>Get All Complaints</Link>
            </p>
            <p>
                <Link to={`/registerComplaint`}>Register Complaint</Link>
            </p>
        </div>
    );
}

