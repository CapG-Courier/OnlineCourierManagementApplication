import React from 'react';
import { useParams } from 'react-router-dom';
import TestNav from '../Bootstrap/TestNav';
import Footer from '../Bootstrap/Footer';
import CustomerCards from '../Bootstrap/CustomerCards';
import Box from '@material-ui/core/Box';

export default function CustomerComponent() {

    let { customerid } = useParams()
    Number(customerid);

    return (

        <div>
            <TestNav/><br></br>
            <Box m={10}></Box>
            {/* <NavBarLogin/><br></br> */}
            <CustomerCards/><br></br>
            <Footer/>
        </div>
    );
}