import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as customerActions from '../store/actions/CustomerActions';
import TextField from '@material-ui/core/TextField';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import Alert from '@material-ui/lab/Alert';
import AlertTitle from '@material-ui/lab/AlertTitle';


class AddComplaintComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {

            consignmentNo: 0,
            detailDescription:'',
            shortDescription:'',
            customer: {
                customerid: 0,
            }

        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.createComplaint = this.createComplaint.bind(this);
    }

    handleInputChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    createComplaint(e) {
        e.preventDefault();

        let payload = {

            consignmentNo: this.state.consignmentNo,
            detailDescription: this.state.detailDescription,
            shortDescription: this.state.shortDescription,
            customerid: this.state.customerid

        }

        const { customerActions } = this.props;
        customerActions.createComplaint(payload);

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
            consignmentNo:0,
            detailDescription: '',
            shortDescription: '',
            customer: {
                customerid: 0
            }
        });
    }

    render() {

        if(this.props.complaint !== undefined) {

            return <Alert severity="success">
                        <AlertTitle>Success</AlertTitle>
                     You have successfully registered a complaint!
            </Alert>
            // let cid = parseInt(this.state.customerid)
            // return <Redirect to={`/customer/customerid=${cid}/Home`} />;
        }

        return (
            <div>

                <TextField
                    variant="outlined"
                    required
                    fullWidth
                    type="number"
                    id="customerid"
                    label="Re-enter Customer Id"
                    name="customerid"
                    autoComplete="customerid"
                    value={this.state.customerid}
                    onChange={this.handleInputChange}
                    autoFocus
                />
                <Box m={2} />

                <TextField
                    variant="outlined"
                    required
                    fullWidth
                    type="number"
                    id="consignmentNo"
                    label="Consignment No."
                    name="consignmentNo"
                    autoComplete="consignmentNo"
                    value={this.state.consignmentNo}
                    onChange={this.handleInputChange}
                    autoFocus
                />
                <Box m={2} />

                <TextField
                    variant="outlined"
                    fullWidth
                    type="text"
                    multiline
                    rows={4}
                    rowsMax={10}
                    id="detailDescription"
                    label="Enter Detailed Description"
                    name="detailDescription"
                    autoComplete="detailDescription"
                    value={this.state.detailDescription}
                    onChange={this.handleInputChange}
                    autoFocus
                />
                <Box m={2} />

                <TextField
                    variant="outlined"
                    required
                    fullWidth
                    type="text"
                    multiline
                    rows={2}
                    rowsMax={4}
                    id="shortDescription"
                    label="Enter Short Description"
                    name="shortDescription"
                    autoComplete="shortDescription"
                    value={this.state.shortDescription}
                    onChange={this.handleInputChange}
                    autoFocus
                />
                <Box m={2} />

                <Button variant="contained" color="secondary" onClick={this.createComplaint}>
                    Submit
                </Button>

                {/* <h3>Register Complaint</h3>
                <form onSubmit={this.createComplaint}>
                    <table>
                        <tbody>
                        <tr>
                                <td><label>Customer ID:</label></td>
                                <td><input type="number" placeholder="CustomerID" name="customerid" id="customerid" value={this.state.customerid} onChange={this.handleInputChange}></input></td>
                            </tr>
                            <tr>
                                <td><label>Consignment No:</label></td>
                                <td><input type="number" placeholder="ConsignmentNo" name="consignmentNo" id="consignmentNo" value={this.state.consignmentNo} onChange={this.handleInputChange}></input></td>
                            </tr>
                            <tr>
                                <td><label>Detail Description:</label></td>
                                <td><textarea  name="detailDescription" id="detailDescription" value={this.state.detailDescription} onChange={this.handleInputChange}></textarea></td>
                            </tr>
                            <tr>
                                <td><label>Short Description:</label></td>
                                <td><textarea name="shortDescription" id="shortDescription" value={this.state.shortDescription} onChange={this.handleInputChange}></textarea></td>
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

    return { complaint: state.customerReducer.complaint }
}

function mapDispatchToProps(dispatch) {
    return {
        customerActions: bindActionCreators(customerActions, dispatch)
    }
};
export default connect(mapStateToProps, mapDispatchToProps)(AddComplaintComponent);