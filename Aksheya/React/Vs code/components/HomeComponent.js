import React from 'react';
import { Link } from 'react-router-dom';
 
export default function HomeComponent () {
 
    return(
       <div>
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