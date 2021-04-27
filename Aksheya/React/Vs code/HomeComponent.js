import React from 'react';
import { Link } from 'react-router-dom';
import Navbar from './Bootstrap/Navbar';
import HomePage from './Bootstrap/HomePage';
import HomeCards from './Bootstrap/HomeCards';
import Footer from './Bootstrap/Footer';
 
export default function HomeComponent () {
 
    return(
        <div>
        <Navbar/>
           <HomePage /><br></br>
           <br></br><HomeCards/><br></br>
           <br></br><Footer/>
    </div>
     );
}