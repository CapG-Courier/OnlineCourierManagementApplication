import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as customerActions from '../store/actions/CustomerActions';
import { useParams } from 'react-router';
import { Link } from 'react-router-dom';
import Button from '@material-ui/core/Button';
import TestNav2 from '../Bootstrap/TestNav2';
import { Box } from '@material-ui/core';
 
class CustomerProfileComponent extends Component {

    componentDidMount() {  
        
        const { customerActions, match } = this.props;
        customerActions.fetchCustomer(match.params.customerid);    
        
    }

    render() {
        const { customer } = this.props;
        return (
            <div class="container">
                <TestNav2 />
                <Box m={15} />
                {
                    customer !== undefined ?

                    // <form>
                    //     <div class="panel panel-primary">
                    //         <div class="panel-heading">Basic details</div>
                    //         <div class="panel-body">
                            //     <div class="form-group row">
                            //         <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Customer Id</label>
                            //         <div class="col-sm-10">
                            //             <input type="text" readonly class="form-control form-control-lg" id="colFormLabelLg" value={customer.customerid}></input>
                            //         </div>
                            //     </div>
                            //     <div class="form-group row">
                            //         <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">First Name</label>
                            //         <div class="col-sm-10">
                            //             <input type="text" readonly class="form-control form-control-lg" id="colFormLabelLg" value={customer.firstname}></input>
                            //         </div>
                            //     </div>
                            //     <div class="form-group row">
                            //         <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Last Name</label>
                            //         <div class="col-sm-10">
                            //             <input type="text" readonly class="form-control form-control-lg" id="colFormLabelLg" value={customer.lastname}></input>
                            //         </div>
                            //     </div>
                            //     <div class="form-group row">
                            //         <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Aadhar Number</label>
                            //         <div class="col-sm-10">
                            //             <input type="text" readonly class="form-control form-control-lg" id="colFormLabelLg" value={customer.aadharno}></input>
                            //         </div>
                            //     </div>
                            //     <div class="form-group row">
                            //         <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Mobile Number</label>
                            //         <div class="col-sm-10">
                            //             <input type="text" readonly class="form-control form-control-lg" id="colFormLabelLg" value={customer.mobileno}></input>
                            //         </div>
                            //     </div>
                            // </div>
                    //     </div>
                    //     <div class="panel panel-primary">
                    //     <div class="panel-heading">Panel with panel-primary class</div>
                    //     <div class="panel-body">Panel Content</div>
                    //     </div>
                    // </form>
                    <div class="card">
                        <div class="card-header h5">Personal Details</div>
                        <div class="card-body">
                            <div class="form-group row">
                                <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Customer Id</label>
                                <div class="col-sm-10">
                                    <input type="text" readonly class="form-control form-control-lg" id="colFormLabelLg" value={customer.customerid}></input>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">First Name</label>
                                <div class="col-sm-10">
                                    <input type="text" readonly class="form-control form-control-lg" id="colFormLabelLg" value={customer.firstname}></input>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Last Name</label>
                                <div class="col-sm-10">
                                    <input type="text" readonly class="form-control form-control-lg" id="colFormLabelLg" value={customer.lastname}></input>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Aadhar Number</label>
                                <div class="col-sm-10">
                                    <input type="text" readonly class="form-control form-control-lg" id="colFormLabelLg" value={customer.aadharno}></input>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Mobile Number</label>
                                <div class="col-sm-10">
                                    <input type="text" readonly class="form-control form-control-lg" id="colFormLabelLg" value={customer.mobileno}></input>
                                </div>
                            </div>
                        </div>
                        <div class="card-header h5">Bank Account Details</div>
                        <div class="card-body">
                            <div class="form-group row">
                                <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Account Number</label>
                                <div class="col-sm-10">
                                    <input type="text" readonly class="form-control form-control-lg" id="colFormLabelLg" value={customer.acct.accountno}></input>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Account Type</label>
                                <div class="col-sm-10">
                                    <input type="text" readonly class="form-control form-control-lg" id="colFormLabelLg" value={customer.acct.accountType}></input>
                                </div>
                            </div>
                        </div>
                        <div class="card-header h5">Address Details</div>
                        <Button variant="contained" color="primary">
                        <Link to={`/registerAddress/${customer.customerid}`}>
                        Update
                        </Link>
                        </Button>

                    </div>

                    
                        :
                        <h3>Loading....</h3>
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