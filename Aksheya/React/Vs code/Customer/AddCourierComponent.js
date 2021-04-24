import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { Redirect } from 'react-router-dom';
import * as customerActions from '../store/actions/CustomerActions';


class AddCourierComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {

            initiatedDate: '',
            customer: {
                customerid: 0,
            }

        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.createCourier = this.createCourier.bind(this);
    }

    handleInputChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    createCourier(e) {
        e.preventDefault();

        let payload = {

            initiatedDate: this.state.initiatedDate,
            customerid: this.state.customerid

        }

        const { customerActions } = this.props;
        customerActions.createCourier(payload);

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
            initiatedDate: '',
            customer: {
                customerid: 0
            }
        });
    }

    render() {

        if(this.props.courier !== undefined) {

            let cid = parseInt(this.state.customerid)
            return <Redirect to={`/customer/customerid=${cid}/Home`} />;
        }

        return (
            <div>
                <h3>Register Courier</h3>
                <form onSubmit={this.createCourier}>
                    <table>
                        <tbody>
                            <tr>
                                <td><label>Initiated Date:</label></td>
                                <td><input type="date" placeholder="Initiated Date" name="initiatedDate" id="initiatedDate" value={this.state.initiatedDate} onChange={this.handleInputChange}></input></td>
                            </tr>
                            <tr>
                                <td><label>Customer Id:</label></td>
                                <td><input type="number" placeholder="CustomerId" name="customerid" id="customerid" value={this.state.customerid} onChange={this.handleInputChange}></input></td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="submit" value="Submit"></input>
                </form>
{/* 
                {
                    this.props.courier !== undefined &&
                    <Redirect to="/customer/Home" />
                } */}

            </div >
        );
    }
}

function mapStateToProps(state) {

    return { courier: state.customerReducer.courier }
}

function mapDispatchToProps(dispatch) {
    return {
        customerActions: bindActionCreators(customerActions, dispatch)
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(AddCourierComponent);