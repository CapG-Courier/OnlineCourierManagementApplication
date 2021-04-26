import React from 'react';
import HomePage from './Bootstrap/HomePage';
import Navbar from './Bootstrap/Navbar';
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