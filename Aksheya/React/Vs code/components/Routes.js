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
 
const Routes = () => (
    <BrowserRouter>
        <Switch>
            <Route path='/' component={HomeComponent} exact />
            <Route path={`/login`} component={CustomerLoginComponent}/>
            <Route path={`/customer/Home`} component={CustomerComponent}/>
            <Route path={`/managerLogin`} component={ManagerLoginComponent}/>
            <Route path={`/manager/Home`} component={ManagerComponent}/>
            <Route path={`/register`} component={CustomerRegisterComponent}/>
            <Route path={`/profile`} component={CustomerProfileComponent}/>
            <Route path={`/newCourier`} component={AddCourierComponent}/>
            <Route path={`/checkStatus`} component={CheckStatusComponent}/>
            <Route path={`/registerComplaint`} component={AddComplaintComponent}/>
            
        </Switch>
    </BrowserRouter>
);
 
export default Routes;