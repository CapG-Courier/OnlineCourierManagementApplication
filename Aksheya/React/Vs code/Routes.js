import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
 
import HomeComponent from './HomeComponent';
import CustomerComponent from './Customer/CustomerComponent';
import ManagerComponent from './Manager/ManagerComponent';
import ServicesPage from './Bootstrap/ServicesPage';
import AboutUsPage from './Bootstrap/AboutUsPage';

import LoginPage from './Bootstrap/LoginPage';
import RegistrationPage from './Bootstrap/RegistrationPage';
import CustomerProfileComponent from './Customer/CustomerProfileComponent';
import CourierRegister from './Bootstrap/CourierRegister';
import ComplaintRegister from './Bootstrap/ComplaintRegister';
import CustomerCouriersComponent from './Customer/CustomerCouriersComponents';
import CustomerComplaintsComponent from './Customer/CustomerComplaintsComponents';
import CustomerAddressPage from './Bootstrap/CustomerAddressPage';
import Checkout from './Bootstrap/Checkout';

import ManagerLogin from './Bootstrap/ManagerLogin';
import ManagerRegister from './Bootstrap/ManagerRegister';
import StaffRegister from './Bootstrap/StaffRegister';
import OfficeRegister from './Bootstrap/OfficeRegister';
import ManagerAllStaffComponent from './Manager/ManagerAllStaffComponent';
import ManagerStaffComponent from './Manager/ManagerStaffComponent';
import ManagerAllComplaintsComponent from './Manager/ManagerAllComplaintsComponent';
import ManagerAllCouriersComponent from './Manager/ManagerAllCouriersComponent';
import ManagerGetCustomerComponent from './Manager/ManagerGetCustomerComponent';
import ManagerDeleteStaffPage from './Bootstrap/ManagerDeleteStaffPage';
import ManagerAllOfficeComponent from './Manager/ManagerAllOfficeComponent';
import ManagerDeleteOfficePage from './Bootstrap/ManagerDeleteOfficePage';
import OfficeAddressPage from './Bootstrap/OfficeAddressPage';

import ShipmentComponent from './Shipment/ShipmentComponent';
import ShipmentStatusesComponent from './Shipment/ShipmentStatusesComponent';
import InitiateCourierPage from './Bootstrap/InitiateCourierPage';
import CloseCourierPage from './Bootstrap/CloseCourierPage';
import RejectCourierPage from './Bootstrap/RejectCourierPage';


const Routes = () => (
    <BrowserRouter>
        <Switch>
            <Route path='/' component={HomeComponent} exact />
            <Route path={`/customer/customerid=:customerid/Home`} component={CustomerComponent}/>
            <Route path={`/manager/managerid=:managerid/Home`} component={ManagerComponent}/>
            <Route path={`/:managerid/Shipment`} component={ShipmentComponent} />
            <Route path={`/Services`} component={ServicesPage} />
            <Route path={`/AboutUs`} component={AboutUsPage} />
--------------------------------------------------------------------------------------------------------------------------------------
            <Route path={`/login`} component={LoginPage}/>
            <Route path={`/register`} component={RegistrationPage}/>
            <Route path={`/profile/:customerid`} component={CustomerProfileComponent}/>
            <Route path={`/registerAddress/:customerid`} component={CustomerAddressPage}/>
            <Route path={`/newCourier/:customerid`} component={CourierRegister}/>
            <Route path={`/byCard/:customerid`} component={Checkout}/>
            <Route path={`/getCouriers/:customerid`} component={CustomerCouriersComponent}/>
            <Route path={`/getComplaints/:customerid`} component={CustomerComplaintsComponent}/>
            <Route path={`/registerComplaint/:customerid`} component={ComplaintRegister}/>
----------------------------------------------------------------------------------------------------------------------------------------
            <Route path={`/managerLogin`} component={ManagerLogin}/>
            <Route path={`/addManager/:managerid`} component={ManagerRegister}/>
            <Route path={`/addStaff/:managerid`} component={StaffRegister}/>
            <Route path={`/addOffice/:managerid`} component={OfficeRegister}/>
            <Route path={`/getAllStaff/:managerid`} component={ManagerAllStaffComponent}/>
            <Route path={`/getStaff/:managerid/view/:empid`} component={ManagerStaffComponent} exact/>
            <Route path={`/getAllComplaints/:managerid`} component={ManagerAllComplaintsComponent} />
            <Route path={`/getAllCouriers/:managerid`} component={ManagerAllCouriersComponent} />
            <Route path={`/getAllOffice/:managerid`} component={ManagerAllOfficeComponent} />
            <Route path={`/getCustomer/:managerid/view/:customerid`} component={ManagerGetCustomerComponent} />
            <Route path={`/deleteStaff/:managerid`} component={ManagerDeleteStaffPage} />
            <Route path={`/addAddress/:managerid/office/:officeid`} component={OfficeAddressPage}/>
            <Route path={`/deleteOffice/:managerid/office/:officeid`} component={ManagerDeleteOfficePage}/>
-----------------------------------------------------------------------------------------------------------------------------------
            <Route path={`/getStatus/:managerid`} component={ShipmentStatusesComponent}/>
            <Route path={`/initiateCourier/:managerid`} component={InitiateCourierPage}/>
            <Route path={`/closeCourier/:managerid`} component={CloseCourierPage}/>
            <Route path={`/rejectCourier/:managerid`} component={RejectCourierPage}/>
            
        </Switch>
    </BrowserRouter>
);
 
export default Routes;