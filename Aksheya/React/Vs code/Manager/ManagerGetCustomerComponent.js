import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as managerActions from '../store/actions/ManagerActions';
 
class ManagerGetCustomerComponent extends Component {

    componentDidMount() {  
        
        const { managerActions, match } = this.props;
        managerActions.fetchCustomer(match.params.managerid, match.params.customerid);    
        
    }

    render() {
        const { customer } = this.props;
        return (
            <div class="container">
                <h2>Customer Details</h2>
                {
                     customer !== undefined ?
 
                        <table class="table table-dark table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Customer ID</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Mobile No.</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                        <tr>
                                            <td>{customer.customerid}</td>
                                            <td>{customer.firstname}</td>
                                            <td>{customer.lastname}</td>
                                            <td>{customer.mobileno}</td>
                                        </tr>
                                }
                            </tbody>
                        </table>
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