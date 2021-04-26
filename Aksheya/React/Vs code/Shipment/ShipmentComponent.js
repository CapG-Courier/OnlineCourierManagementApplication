import React from 'react';
import { Link, useParams } from 'react-router-dom';
import ShipmentCards from '../Bootstrap/ShipmentCards';
import ShipmentHeader from '../Bootstrap/ShipmentHeader';
import TestNav3 from '../Bootstrap/TestNav3';
import Box from '@material-ui/core/Box';

export default function ShipmentComponent () {

    let { managerid } = useParams()
    Number(managerid);

    return(

        <div>
            <TestNav3/>
            <Box m={8.2}/>
            <ShipmentHeader/>
            <Box m={5}/>
            <ShipmentCards/>
            <Box m={15}/>
            {/* <h2>Shipment Home Page</h2>
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
            </p> */}
        </div>
    )

}