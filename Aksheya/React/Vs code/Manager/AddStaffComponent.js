import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { Redirect } from 'react-router-dom';
import * as managerActions from '../store/actions/ManagerActions';
import TextField from '@material-ui/core/TextField';
import Box from '@material-ui/core/Box';
import InputLabel from '@material-ui/core/InputLabel';
import Select from '@material-ui/core/Select';
import Button from '@material-ui/core/Button';
import Alert from '@material-ui/lab/Alert';
import AlertTitle from '@material-ui/lab/AlertTitle';



class AddStaffComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {

            name: '',
            office: {
                officeid: 0,
            },
            role: '',
            managerid: 0

        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.createStaff = this.createStaff.bind(this);
    }

    handleInputChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    createStaff(e) {
        e.preventDefault();

        let payload = {

            name: this.state.name,
            officeid: this.state.officeid,
            role: this.state.role

        }

        const { managerActions, match } = this.props;
        managerActions.createStaff(payload);

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
            name: '',
            office: {
                officeid: 0
            },
            role: '',
            managerid: 0
        });
    }

    render() {

        // if (this.props.staff !== undefined) {

        //     const { match } = this.props;
        //     let empid = parseInt(match.params.managerid)
        //     return <Redirect to={`/manager/managerid=${empid}/Home`} />;
        // }

        if(this.props.staff !== undefined) {
            return <Alert severity="success">
                        <AlertTitle>Success</AlertTitle>
                     You have successfully added a new staff!
            </Alert>
        }

        return (
            <div>
            <TextField
                variant="outlined"
                required
                fullWidth
                type="text"
                id="name"
                label="Name"
                name="name"
                autoComplete="name"
                value={this.state.name}
                onChange={this.handleInputChange}
                autoFocus
            />
            <Box m={2} />

            <TextField
                variant="outlined"
                required
                fullWidth
                type="number"
                id="officeid"
                label="Office Id."
                name="officeid"
                autoComplete="officeid"
                value={this.state.officeid}
                onChange={this.handleInputChange}
                autoFocus
            />
            <Box m={2} />

            <InputLabel htmlFor="role-native-simple">Role</InputLabel>
                <Select
                variant="outlined"
                required
                fullWidth
                autoComplete="role"
                value={this.state.role}
                onChange={this.handleInputChange}
                inputProps={{
                    name: 'role',
                    id: 'role',
                }}
                autoFocus
                >
                <option value="STAFF">STAFF</option>           
                <option value="ACCOUNTING">ACCOUNTING</option>
                <option value="SALES">SALES</option>
                <option value="MARKETING">MARKETING</option>
                </Select>
                
                <Box m={2} />
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
                <Box m={2} />

            <Button variant="contained" color="secondary" onClick={this.createStaff}>
                Add
            </Button>


            {/* <h3>Add Staff</h3>
            <form onSubmit={this.createStaff}>
                <table>
                    <tbody>
                        <tr>
                            <td><label>Name:</label></td>
                            <td><input type="text" placeholder="Name" name="name" id="name" value={this.state.name} onChange={this.handleInputChange}></input></td>
                        </tr>
                        <tr>
                            <td><label>Office Id:</label></td>
                            <td><input type="number" placeholder="OfficeId" name="officeid" id="officeid" value={this.state.officeid} onChange={this.handleInputChange}></input></td>
                        </tr>
                        <tr>
                            <td>
                                <label>
                                Choose your Staff Type:
                                <select type="text" name="role" id="role" value={this.state.role} onChange={this.handleInputChange}> 
                                    <option value="STAFF">STAFF</option>           
                                    <option value="ACCOUNTING">ACCOUNTING</option>
                                    <option value="SALES">SALES</option>
                                    <option value="MARKETING">MARKETING</option>
                                </select>
                                </label>
                            </td>
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

return { staff: state.managerReducer.staff }
}

function mapDispatchToProps(dispatch) {
return {
    managerActions: bindActionCreators(managerActions, dispatch)
}
};

export default connect(mapStateToProps, mapDispatchToProps)(AddStaffComponent);