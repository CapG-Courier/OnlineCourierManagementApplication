import React from 'react';
import { Link } from 'react-router-dom';
import HomePage from './Bootstrap/HomePage';
import Navbar from './Bootstrap/Navbar';
import LoginPage from './Bootstrap/LoginPage';
import TestNavbar from './Bootstrap/TestNavbar';
 
export default function HomeComponent () {
 
    return(
       <div>
           <Navbar/>
           <HomePage />
           {/* <TestNavbar /><br></br> */}
       <h2>Home Page</h2>
       <p>
           <Link to={`/login`}>Customer Login</Link>
       </p>
       <p>
           <Link to={`/register`}>Register</Link>
       </p>
       <p>
           <Link to={`/managerLogin`}>Manager Login</Link>
       </p>
       <p>
           <Link to={`/AboutUs`}>About Us</Link>
       </p>
       <p>
           <Link to={`/Services`}>Services</Link>
       </p>    
 
   </div>
    );
}