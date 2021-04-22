import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import {Redirect} from 'react-router-dom';
import * as homeActions from '../store/actions/HomeActions';


class CustomerRegisterComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {

            aadharno: 0,
            acct:{
            accountHolderName: '',
            accountType: '',
            accountno: 0
            },
            firstname: '',
            lastname: '',
            mobileno: 0,
            password: ''

        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.createCustomer = this.createCustomer.bind(this);
    }

    handleInputChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    createCustomer(e) {
        e.preventDefault();

        let payload = {

            aadharno: this.state.aadharno,
            firstname: this.state.firstname,
            lastname: this.state.lastname,
            password: this.state.password,
            mobileno: this.state.mobileno,
            accountHolderName: this.state.accountHolderName,
            accountType: this.state.accountType,
            accountno: this.state.accountno

        }

        const { homeActions } = this.props;
        homeActions.createCustomer(payload);

        // if(this.validate()) {
        //     const { homeActions } = this.props;
        //     homeActions.createCustomer(payload);        
        // }

    }

    // validate(){

    //     let aadharno = this.state.aadharno;
    //     let firstname =  this.state.firstname;
    //     let lastname = this.state.lastname;
    //     let password = this.state.password;
    //     let mobileno = this.state.mobileno;
    //     let accountHolderName = this.state.accountHolderName;
    //     let accountType = this.state.accountType;
    //     let accountno = this.state.accountno;
    //     let errors = {};
    //     let isValid = true;
    
    //     if (!aadharno) {
    //       isValid = false;
    //       errors["aadharno"] = "Please enter a value";
    //     }
    
    //     if (!firstname) {
    //       isValid = false;
    //       errors["firstname"] = "This field cannot be empty";
    //     }
        
    //     if (!lastname) {
    //         isValid = false;
    //         errors["lastname"] = "This field cannot be empty";
    //     }

    //     if (!password) {
    //         isValid = false;
    //         errors["password"] = "A digit must occur at least once, A lower case letter must occur at least once, An upper case letter must occur at least once, A special character must occur at least once, No whitespace allowed in the entire password, Atleast 8 characters must be there";
    //     }

    //     if (!mobileno) {
    //         isValid = false;
    //         errors["mobileno"] = "This field cannot be empty";
    //     }

    //     if (!accountHolderName) {
    //         isValid = false;
    //         errors["accountHolderName"] = "This field cannot be empty";
    //     }

    //     if (!accountno) {
    //         isValid = false;
    //         errors["accountno"] = "This field cannot be empty";
    //     }
      
    //     this.setState({
    //       errors: errors
    //     });
    
    //     return isValid;
    // }

    clear = () => {
        this.setState = ({
            aadharno: 0,
            acct:{
            accountHolderName: '',
            accountType: '',
            accountno: 0
            },
            firstname: '',
            lastname: '',
            mobileno: 0,
            password: ''
        });
    }

    render() {
        return (
            <div>
                <h3>Register</h3>
                <form onSubmit={this.createCustomer}>
                    <table>
                        <tbody>
                            <tr>
                                <td><label>First Name:</label></td>
                                <td><input type="text" placeholder="FirstName" name="firstname" id="firstname" value={this.state.firstname} onChange={this.handleInputChange}></input></td>
                            </tr>
                            <tr>
                                <td><label>Last Name:</label></td>
                                <td><input type="text" placeholder="LastName" name="lastname" id="lastname" value={this.state.lastname} onChange={this.handleInputChange}></input></td>
                            </tr>
                            <tr>
                                <td><label>Aadhar No.:</label></td>
                                <td><input type="number" placeholder="AadharNo" name="aadharno" id="aadharno" value={this.state.aadharno} onChange={this.handleInputChange}></input></td>
                            </tr>
                            <tr>
                                <td><label>Mobile No.:</label></td>
                                <td><input type="number" placeholder="MobileNo" name="mobileno" id="mobileno" value={this.state.mobileno} onChange={this.handleInputChange}></input></td>
                            </tr>
                            <tr>
                                <td><label>Password:</label></td>
                                <td><input type="password" placeholder="Password" name="password" id="password" value={this.state.password} onChange={this.handleInputChange}></input></td>
                            </tr>
                            {/* <tr>
                                <h3> Enter bank details </h3>
                            </tr> */}
                            <tr>
                                <td><label>Account No.:</label></td>
                                <td><input type="number" placeholder="AccountNo" name="accountno" id="accountno" value={this.state.accountno} onChange={this.handleInputChange}></input></td>
                            </tr>
                            <tr>
                                <td><label>Account Holder Name:</label></td>
                                <td><input type="text" placeholder="AccountHolderName" name="accountHolderName" id="accountHolderName" value={this.state.accountHolderName} onChange={this.handleInputChange}></input></td>
                            </tr>
                            <tr>
                                <td>
                                    <label>
                                    Choose your Account Type:
                                    <select name="accountType" id="accountType" value={this.state.accountType} onChange={this.handleInputChange}> 
                                        <option value="CURRENT">CURRENT</option>           
                                        <option value="SAVINGS">SAVINGS</option>
                                        <option value="SALARY">SALARY</option>
                                        <option value="FIXED DEPOSIT">FIXED DEPOSIT</option>
                                        <option value="NRI">NRI</option>
                                    </select>
                                    </label>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="submit" value="Submit"></input>
	            </form>

                {
                    this.props.customer !== undefined &&
                        <Redirect to="/home" />
                }
                   
            </div > 
        );
    }
}

function mapStateToProps(state) {

    return { customer: state.homeReducer.newCustomer }
}

function mapDispatchToProps(dispatch) {
    return {
        homeActions: bindActionCreators(homeActions, dispatch)
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(CustomerRegisterComponent);