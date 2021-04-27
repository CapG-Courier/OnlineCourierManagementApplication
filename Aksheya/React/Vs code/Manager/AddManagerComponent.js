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

class AddManagerComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {

            name: '',
            office: {
                officeid: 0,
            },
            password: '',
            role: '',
            managerid: 0

        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.createManager = this.createManager.bind(this);
    }

    handleInputChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    createManager(e) {
        e.preventDefault();

        let payload = {

            name: this.state.name,
            officeid: this.state.officeid,
            password: this.state.password,
            role: this.state.role,
            managerid: this.state.managerid

        }

        const { managerActions, match } = this.props;
        managerActions.createManager(payload);


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
            password: '',
            role: '',
            managerid: 0
        });
    }

    render() {

        // if (this.props.manager !== undefined) {

        //     const { match } = this.props;
        //     let empid = parseInt(match.params.managerid)
        //     return <Redirect to={`/manager/managerid=${empid}/Home`} />;
        // }
        if(this.props.manager !== undefined) {
            return <Alert severity="success">
                        <AlertTitle>Success</AlertTitle>
                     You have successfully added a new manager!
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

                <TextField
                    variant="outlined"
                    required
                    fullWidth
                    type="password"
                    id="password"
                    label="Password"
                    name="password"
                    autoComplete="password"
                    value={this.state.password}
                    onChange={this.handleInputChange}
                    autoFocus
                />
                <Box p={2} />

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
                    <option value="MANAGER">MANAGER</option>
                    <option value="STAFF">STAFF</option>
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

                <Button variant="contained" color="secondary" onClick={this.createManager}>
                    Add
                </Button>

            </div >
        );
    }
}

function mapStateToProps(state) {

    return { manager: state.managerReducer.manager }
}

function mapDispatchToProps(dispatch) {
    return {
        managerActions: bindActionCreators(managerActions, dispatch)
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(AddManagerComponent);