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
import AddStaffComponent from './AddStaffComponent';
import AddOfficeComponent from './AddOfficeComponent';
import ManagerAllStaffComponent from './ManagerAllStaffComponent';
import ManagerStaffComponent from './ManagerStaffComponent';
import ManagerAllComplaintsComponent from './ManagerAllComplaintsComponent';
import ManagerAllCouriersComponent from './ManagerAllCouriersComponent';
import ManagerGetCustomerComponent from './ManagerGetCustomerComponent';
import ManagerDeleteStaffComponent from './ManagerDeleteStaffComponent';
import CustomerAddressComponent from './CustomerAddressComponent';
import ManagerAllOfficeComponent from './ManagerAllOfficeComponent';
import OfficeAddressComponent from './OfficeAddressComponent';
import ManagerDeleteOfficeComponent from './ManagerDeleteOfficeComponent';
import ShipmentComponent from './ShipmentComponent';
import ShipmentStatusesComponent from './ShipmentStatusesComponent';
import ShipmentInitiateComponent from './ShipmentInitiateComponent';
import ShipmentCloseComponent from './ShipmentCloseComponent';
import ShipmentRejectComponent from './ShipmentRejectComponent';

const Routes = () => (
    <BrowserRouter>
        <Switch>
            <Route path='/' component={HomeComponent} exact />
            <Route path={`/customer/customerid=:customerid/Home`} component={CustomerComponent}/>
            <Route path={`/manager/managerid=:managerid/Home`} component={ManagerComponent}/>
            <Route path={`/:managerid/Shipment`} component={ShipmentComponent} />
--------------------------------------------------------------------------------------------------------------------------------------
            <Route path={`/login`} component={CustomerLoginComponent}/>
            <Route path={`/register`} component={CustomerRegisterComponent}/>
            <Route path={`/profile/:customerid`} component={CustomerProfileComponent}/>
            <Route path={`/registerAddress/:customerid`} component={CustomerAddressComponent}/>
            <Route path={`/newCourier`} component={AddCourierComponent}/>
            <Route path={`/getCouriers/:customerid`} component={CustomerCouriersComponent}/>
            <Route path={`/getComplaints/:customerid`} component={CustomerComplaintsComponent}/>
            <Route path={`/checkStatus`} component={CheckStatusComponent}/>
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