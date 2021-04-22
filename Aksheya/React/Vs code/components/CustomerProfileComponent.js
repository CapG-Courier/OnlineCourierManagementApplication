import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as customerActions from '../store/actions/CustomerActions';
 
class CustomerProfileComponent extends Component {
 
    componentDidMount() {  

        const { customerActions, match } = this.props;
        customerActions.fetchCustomer(match.params.id);    
        
    }
    render() {
        const { customer } = this.props;
        return (
            <div>
                {
                    customer !== undefined ?
                    <div>

                        <p>
                            <h4>Customer Details:</h4>
                            {customer.customerid} {customer.aadharno} {customer.firstname} {customer.lastname} {customer.mobileno} {customer.acct.accountno} 
                        </p>
                    </div>
                    : <h3>Loading....</h3>
                }
            </div>
        );
    }
}
 
function mapStateToProps(state) {
 
    return { customer: state.customerReducer.customer }
}  
 
function mapDispatchToProps (dispatch) {
   return {
      customerActions : bindActionCreators(customerActions,dispatch)      
   }   
  };
 
export default connect(mapStateToProps,mapDispatchToProps) (CustomerProfileComponent);