import React from 'react';
import { Link } from 'react-router-dom';

export default class CustomerComponent extends React.Component {

    render() {

        return (

            <div>
                <h2>Customer Home Page</h2>
                <p>
                    <Link to={`/profile`}>Check Profile</Link>
                </p>
                <p>
                    <Link to={`/newCourier`}>Initiate Courier</Link>
                </p>
                <p>
                    <Link to={`/checkStatus`}>Check Courier Status</Link>
                </p>
                <p>
                    <Link to={`/registerComplaint`}>Register Complaint</Link>
                </p>
            </div>
        )

    }

}