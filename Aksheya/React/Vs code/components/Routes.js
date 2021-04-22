import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
 
import HomeComponent from './HomeComponent';
import CustomerComponent from './CustomerComponent';
import CustomerLoginComponent from './CustomerLoginComponent';
import ManagerComponent from './ManagerComponent';
import ManagerLoginComponent from './ManagerLoginComponent';
import CustomerRegisterComponent from './CustomerRegisterComponent';
import CustomerProfileComponent from './CustomerProfileComponent';
import AddCourierComponent from './AddCourierComponent';
import CheckStatusComponent from './CheckStatusComponent';
import AddComplaintComponent from './AddComplaintComponent';
import CustomerCouriersComponent from './CustomerCouriersComponent';
import AddManagerComponent from './AddManagerComponent';
import CustomerComplaintsComponent from './CustomerComplaintsComponent';
 
const Routes = () => (
    <BrowserRouter>
        <Switch>
            <Route path='/' component={HomeComponent} exact />
            <Route path={`/login`} component={CustomerLoginComponent}/>
            <Route path={`/customer/customerid=:customerid/Home`} component={CustomerComponent}/>
            <Route path={`/managerLogin`} component={ManagerLoginComponent}/>
            <Route path={`/manager/managerid=:managerid/Home`} component={ManagerComponent}/>
            <Route path={`/register`} component={CustomerRegisterComponent}/>
            <Route path={`/profile/:customerid`} component={CustomerProfileComponent}/>
            <Route path={`/newCourier`} component={AddCourierComponent}/>
            <Route path={`/getCouriers/:customerid`} component={CustomerCouriersComponent}/>
            <Route path={`/getComplaints/:customerid`} component={CustomerComplaintsComponent}/>
            <Route path={`/checkStatus`} component={CheckStatusComponent}/>
            <Route path={`/registerComplaint`} component={AddComplaintComponent}/>
            <Route path={`/addManager`} component={AddManagerComponent}/>
            
        </Switch>
    </BrowserRouter>
);
 
export default Routes;