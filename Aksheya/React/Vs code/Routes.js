import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
 
import HomeComponent from './HomeComponent';
import CustomerComponent from './Customer/CustomerComponent';
import ManagerComponent from './Manager/ManagerComponent';

import LoginPage from './Bootstrap/LoginPage';
import CustomerRegisterComponent from './Customer/CustomerRegisterComponent';
import CustomerProfileComponent from './Customer/CustomerProfileComponent';
import AddCourierComponent from './Customer/AddCourierComponent';
import AddComplaintComponent from './Customer/AddComplaintComponent';
import CustomerCouriersComponent from './Customer/CustomerCouriersComponent';
import CustomerComplaintsComponent from './Customer/CustomerComplaintsComponent';
import CustomerAddressComponent from './Customer/CustomerAddressComponent';

import ManagerLoginComponent from './Manager/ManagerLoginComponent';
import AddManagerComponent from './Manager/AddManagerComponent';
import AddStaffComponent from './Manager/AddStaffComponent';
import AddOfficeComponent from './Manager/AddOfficeComponent';
import ManagerAllStaffComponent from './Manager/ManagerAllStaffComponent';
import ManagerStaffComponent from './Manager/ManagerStaffComponent';
import ManagerAllComplaintsComponent from './Manager/ManagerAllComplaintsComponent';
import ManagerAllCouriersComponent from './Manager/ManagerAllCouriersComponent';
import ManagerGetCustomerComponent from './Manager/ManagerGetCustomerComponent';
import ManagerDeleteStaffComponent from './Manager/ManagerDeleteStaffComponent';
import ManagerAllOfficeComponent from './Manager/ManagerAllOfficeComponent';
import ManagerDeleteOfficeComponent from './Manager/ManagerDeleteOfficeComponent';
import OfficeAddressComponent from './Manager/OfficeAddressComponent';

import ShipmentComponent from './Shipment/ShipmentComponent';
import ShipmentStatusesComponent from './Shipment/ShipmentStatusesComponent';
import ShipmentInitiateComponent from './Shipment/ShipmentInitiateComponent';
import ShipmentCloseComponent from './Shipment/ShipmentCloseComponent';
import ShipmentRejectComponent from './Shipment/ShipmentRejectComponent';

const Routes = () => (
    <BrowserRouter>
        <Switch>
            <Route path='/' component={HomeComponent} exact />
            <Route path={`/customer/customerid=:customerid/Home`} component={CustomerComponent}/>
            <Route path={`/manager/managerid=:managerid/Home`} component={ManagerComponent}/>
            <Route path={`/:managerid/Shipment`} component={ShipmentComponent} />
--------------------------------------------------------------------------------------------------------------------------------------
            <Route path={`/login`} component={LoginPage}/>
            <Route path={`/register`} component={CustomerRegisterComponent}/>
            <Route path={`/profile/:customerid`} component={CustomerProfileComponent}/>
            <Route path={`/registerAddress/:customerid`} component={CustomerAddressComponent}/>
            <Route path={`/newCourier`} component={AddCourierComponent}/>
            <Route path={`/getCouriers/:customerid`} component={CustomerCouriersComponent}/>
            <Route path={`/getComplaints/:customerid`} component={CustomerComplaintsComponent}/>
            <Route path={`/registerComplaint`} component={AddComplaintComponent}/>
----------------------------------------------------------------------------------------------------------------------------------------
            <Route path={`/managerLogin`} component={ManagerLoginComponent}/>
            <Route path={`/addManager/:managerid`} component={AddManagerComponent}/>
            <Route path={`/addStaff/:managerid`} component={AddStaffComponent}/>
            <Route path={`/addOffice/:managerid`} component={AddOfficeComponent}/>
            <Route path={`/getAllStaff/:managerid`} component={ManagerAllStaffComponent}/>
            <Route path={`/getStaff/:managerid/view/:empid`} component={ManagerStaffComponent} exact/>
            <Route path={`/getAllComplaints/:managerid`} component={ManagerAllComplaintsComponent} />
            <Route path={`/getAllCouriers/:managerid`} component={ManagerAllCouriersComponent} />
            <Route path={`/getAllOffice/:managerid`} component={ManagerAllOfficeComponent} />
            <Route path={`/getCustomer/:managerid/view/:customerid`} component={ManagerGetCustomerComponent} />
            <Route path={`/deleteStaff`} component={ManagerDeleteStaffComponent} />
            <Route path={`/addAddress/:managerid/office/:officeid`} component={OfficeAddressComponent}/>
            <Route path={`/deleteOffice/:managerid/office/:officeid`} component={ManagerDeleteOfficeComponent}/>
-----------------------------------------------------------------------------------------------------------------------------------
            <Route path={`/getStatus/:managerid`} component={ShipmentStatusesComponent}/>
            <Route path={`/initiateCourier/:managerid`} component={ShipmentInitiateComponent}/>
            <Route path={`/closeCourier/:managerid`} component={ShipmentCloseComponent}/>
            <Route path={`/rejectCourier/:managerid`} component={ShipmentRejectComponent}/>
            
        </Switch>
    </BrowserRouter>
);
 
export default Routes;