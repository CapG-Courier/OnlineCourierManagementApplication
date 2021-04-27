import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { Redirect } from 'react-router-dom';
import TextField from '@material-ui/core/TextField';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import Alert from '@material-ui/lab/Alert';
import AlertTitle from '@material-ui/lab/AlertTitle';
import * as managerActions from '../store/actions/ManagerActions';


class OfficeAddressComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {

            city: '',
            country: '',
            houseNo: '',
            state: '',
            street: '',
            zip: 0,
            office: {
                officeid: 0
            },
            managerid: 0

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
            officeid: this.state.officeid,
            managerid: this.state.managerid

        }

        const { managerActions, match } = this.props;
        managerActions.createAddress(payload);

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
            office: {
                officeid: 0
            },
            managerid: 0
        });
    }

    render() {

        // if(this.props.address !== undefined) {    
            
        //     const { match } = this.props;
        //     return <Redirect to={`/manager/managerid=${match.params.managerid}/Home`} />;
        // }
        
        if(this.props.address !== undefined) {

            return <Alert severity="success">
                        <AlertTitle>Success</AlertTitle>
                     You have successfully updated the office address!
            </Alert>
        }

        return (
            <div>

                <TextField
                    variant="outlined"
                    required
                    fullWidth
                    type="text"
                    id="houseNo"
                    label="House No."
                    name="houseNo"
                    autoComplete="houseNo"
                    value={this.state.houseNo}
                    onChange={this.handleInputChange}
                    autoFocus
                />
                <Box p={2} />

                <TextField
                    variant="outlined"
                    required
                    fullWidth
                    type="text"
                    id="street"
                    label="Street"
                    name="street"
                    autoComplete="street"
                    value={this.state.street}
                    onChange={this.handleInputChange}
                    autoFocus
                />
                <Box p={2} />

                <TextField
                    variant="outlined"
                    required
                    fullWidth
                    type="text"
                    id="city"
                    label="City Name"
                    name="city"
                    autoComplete="city"
                    value={this.state.city}
                    onChange={this.handleInputChange}
                    autoFocus
                />
                <Box p={2} />

                <TextField
                    variant="outlined"
                    required
                    fullWidth
                    type="text"
                    id="state"
                    label="State Name"
                    name="state"
                    autoComplete="state"
                    value={this.state.state}
                    onChange={this.handleInputChange}
                    autoFocus
                />
                <Box p={2} />

                <TextField
                    variant="outlined"
                    required
                    fullWidth
                    type="text"
                    id="country"
                    label="Country"
                    name="country"
                    autoComplete="country"
                    value={this.state.country}
                    onChange={this.handleInputChange}
                    autoFocus
                />
                <Box p={2} />

                <TextField
                    variant="outlined"
                    required
                    fullWidth
                    type="number"
                    id="zip"
                    label="Zip Code"
                    name="zip"
                    autoComplete="zip"
                    value={this.state.zip}
                    onChange={this.handleInputChange}
                    autoFocus
                />
                <Box p={2} />

                <TextField
                    variant="outlined"
                    required
                    fullWidth
                    type="number"
                    id="officeid"
                    label="Office Id"
                    name="officeid"
                    autoComplete="officeid"
                    value={this.state.officeid}
                    onChange={this.handleInputChange}
                    autoFocus
                />
                <Box p={2} />

                <TextField
                    variant="outlined"
                    required
                    fullWidth
                    type="number"
                    id="managerid"
                    label="Re-enter Manager Id"
                    name="managerid"
                    autoComplete="managerid"
                    value={this.state.managerid}
                    onChange={this.handleInputChange}
                    autoFocus
                />
                <Box p={2} />

                <Button variant="contained" color="secondary" onClick={this.createAddress}>
                    Register Address
                </Button>

                {/* <form onSubmit={this.createAddress}>
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
                                <td><label>Office Id:</label></td>
                                <td><input type="number" placeholder="OfficeId" name="officeid" id="officeid" value={this.state.officeid} onChange={this.handleInputChange}></input></td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="submit" value="Submit"></input>
                </form> */}
            </div >
        );
    }
}

function mapStateToProps(state) {

    return { address: state.managerReducer.address }
}

function mapDispatchToProps(dispatch) {
    return {
        managerActions: bindActionCreators(managerActions, dispatch)
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(OfficeAddressComponent);