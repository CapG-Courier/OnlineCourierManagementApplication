import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { Redirect } from 'react-router-dom';
import * as customerActions from '../store/actions/CustomerActions';


class CustomerAddressComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {

            city: '',
            country: '',
            houseNo: '',
            state: '',
            street: '',
            zip: 0,
            customer: {
                customerid: 0
            }

        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.createAddress = this.createAddress.bind(this);
    }

    handleInputChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    createAddress(e) {
        e.preventDefault();

        let payload = {

            city: this.state.city,
            country: this.state.country,
            houseNo: this.state.houseNo,
            state: this.state.state,
            street: this.state.street,
            zip: this.state.zip,
            customerid: this.state.customerid

        }

        const { customerActions } = this.props;
        customerActions.createAddress(payload);

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
            city: '',
            country: '',
            houseNo: '',
            state: '',
            street: '',
            zip: 0,
            customer: {
                customerid: 0
            }
        });
    }

    render() {
        return (
            <div>
                <h3>Register Address</h3>
                <form onSubmit={this.createAddress}>
                    <table>
                        <tbody>
                            <tr>
                                <td><label>House No.:</label></td>
                                <td><input type="text" placeholder="HouseNo" name="houseNo" id="houseNo" value={this.state.houseNo} onChange={this.handleInputChange}></input></td>
                            </tr>
                            <tr>
                                <td><label>Street Name:</label></td>
                                <td><input type="text" placeholder="StreetName" name="street" id="street" value={this.state.street} onChange={this.handleInputChange}></input></td>
                            </tr>
                            <tr>
                                <td><label>City Name:</label></td>
                                <td><input type="text" placeholder="CityName" name="city" id="city" value={this.state.city} onChange={this.handleInputChange}></input></td>
                            </tr>
                            <tr>
                                <td><label>State Name:</label></td>
                                <td><input type="text" placeholder="StateName" name="state" id="state" value={this.state.state} onChange={this.handleInputChange}></input></td>
                            </tr>
                            <tr>
                                <td><label>Country:</label></td>
                                <td><input type="text" placeholder="Country" name="country" id="country" value={this.state.country} onChange={this.handleInputChange}></input></td>
                            </tr>
                            <tr>
                                <td><label>Zip Code:</label></td>
                                <td><input type="number" placeholder="ZipCode" name="zip" id="zip" value={this.state.zip} onChange={this.handleInputChange}></input></td>
                            </tr>
                            <tr>
                                <td><label>Customer Id:</label></td>
                                <td><input type="number" placeholder="CustomerId" name="customerid" id="customerid" value={this.state.customerid} onChange={this.handleInputChange}></input></td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="submit" value="Submit"></input>
                </form>

                {
                    this.props.address !== undefined &&
                    <Redirect to={`/customer/customerid=${Number(address.customer.customerid)}/Home`} />
                }

            </div >
        );
    }
}

function mapStateToProps(state) {

    return { address: state.customerReducer.address }
}

function mapDispatchToProps(dispatch) {
    return {
        customerActions: bindActionCreators(customerActions, dispatch)
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(CustomerAddressComponent);