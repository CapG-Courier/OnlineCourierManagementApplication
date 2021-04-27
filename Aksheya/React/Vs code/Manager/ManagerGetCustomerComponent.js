import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as managerActions from '../store/actions/ManagerActions';
import '../Bootstrap/Design.css';
import TestNav2Manager from '../Bootstrap/TestNav2Manager';
import { Box } from '@material-ui/core';
 
class ManagerGetCustomerComponent extends Component {

    componentDidMount() {  
        
        const { managerActions, match } = this.props;
        managerActions.fetchCustomer(match.params.managerid, match.params.customerid);    
        
    }

    render() {
        const { customer } = this.props;
        return (
            <div class="container">
                <TestNav2Manager />

                <Box m={15} />
                {/* <h2>Customer Details</h2> */}
                {
                     customer !== undefined ?
 
                        <div class="container">
                            <br></br>
                            <br></br>
                            <h2>Customer Details</h2>
                            <br></br>
                            <ul class="responsive-table">
                                <li class="table-header">
                                    <div class="col">Customer ID</div>
                                    <div class="col">First Name</div>
                                    <div class="col">Last Name</div>
                                    <div class="col">Mobile No.</div>
                                </li>
                            </ul>
                            <ul>
                                {
                                        <li class="table-row">
                                            <div class="col">{customer.customerid}</div>
                                            <div class="col">{customer.firstname}</div>
                                            <div class="col">{customer.lastname}</div>
                                            <div class="col">{customer.mobileno}</div>
                                        </li>
                                }
                            </ul>
                        </div>
                        :
                        <h3>Loading....</h3>
                }
            </div>
        );
    }
}
 
function mapStateToProps(state) {
 
    return { customer: state.managerReducer.customer }
}  
 
function mapDispatchToProps (dispatch) {
   return {
      managerActions : bindActionCreators(managerActions,dispatch)      
   }   
  };
 
export default connect(mapStateToProps,mapDispatchToProps) (ManagerGetCustomerComponent);