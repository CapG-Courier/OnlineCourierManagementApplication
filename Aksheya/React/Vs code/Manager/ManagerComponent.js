import React from 'react';
import { Link, useParams } from 'react-router-dom';
import TestNavManager from '../Bootstrap/TestNavManager';
import ManagerCards from '../Bootstrap/ManagerCards';
import Box from '@material-ui/core/Box';
import Footer from '../Bootstrap/Footer';

export default function ManagerComponent () {

    let { managerid } = useParams()
    Number(managerid);

    return(

        <div>
            <TestNavManager/><br></br>
            <Box m={5}/>
            <ManagerCards/>
            <Box m={10}/>
            <Footer/>
        </div>
    )

}