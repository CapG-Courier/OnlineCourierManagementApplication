import React from 'react';
import { Link, useParams } from 'react-router-dom';

export default function ShipmentComponent () {

    let { managerid } = useParams()
    Number(managerid);

    return(

        <div>
            <h2>Shipment Home Page</h2>
            <p>
                <Link to={`/initiateCourier/${managerid}`}>Initiate Process</Link>
            </p>
            <p>
                <Link to={`/closeCourier/${managerid}`}>Close Process</Link>
            </p>
            <p>
                <Link to={`/rejectCourier/${managerid}`}>Reject Process</Link>
            </p>
            <p>
                <Link to={`/getStatus/${managerid}`}>Check Status</Link>
            </p>
        </div>
    )

}