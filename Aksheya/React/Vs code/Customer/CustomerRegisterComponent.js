import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import {Redirect} from 'react-router-dom';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import Alert from '@material-ui/lab/Alert';
import Select from'@material-ui/core/Select';
import DropDownMenu, { Menu } from '@material-ui/core/';
import InputLabel from '@material-ui/core/InputLabel';
import * as homeActions from '../store/actions/HomeActions';
import AlertTitle from '@material-ui/lab/AlertTitle';

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

        // const { homeActions } = this.props;
        // homeActions.createCustomer(payload);

        if(this.validate()) {
            const { homeActions } = this.props;
            homeActions.createCustomer(payload);        
        }

    }

     validate(){

         let aadharno = this.state.aadharno;
         let firstname =  this.state.firstname;
         let lastname = this.state.lastname;
         let password = this.state.password;
         let mobileno = this.state.mobileno;
         let accountHolderName = this.state.accountHolderName;
         let accountType = this.state.accountType;
         let accountno = this.state.accountno;
         let errors = {};
         let isValid = true;
    
         if (!aadharno) {
           isValid = false;
           errors["aadharno"] = "Please enter a value";
         }
    
         if (!firstname) {
           isValid = false;
           errors["firstname"] = "This field cannot be empty";
         }
        
         if (!lastname) {
             isValid = false;
             errors["lastname"] = "This field cannot be empty";
         }

         if (!password) {
             isValid = false;
             errors["password"] = "A digit must occur at least once, A lower case letter must occur at least once, An upper case letter must occur at least once, A special character must occur at least once, No whitespace allowed in the entire password, Atleast 8 characters must be there";
         }

         if (!mobileno) {
             isValid = false;
             errors["mobileno"] = "This field cannot be empty";
         }

         if (!accountHolderName) {
             isValid = false;
             errors["accountHolderName"] = "This field cannot be empty";
         }

         if (!accountno) {
            isValid = false;
             errors["accountno"] = "This field cannot be empty";
           }
      
         this.setState({
          errors: errors
        });
    
         return isValid;
     }

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
                    {
                    this.props.customer !== undefined &&
                    
                    <Alert severity="success">
                        <AlertTitle>Success</AlertTitle>
                        You have successfully created an account!
                    </Alert>
                    }

                    <Box m={5}/>
                    <TextField
                        variant="outlined"
                        required
                        fullWidth
                        type="text"
                        id="firstname"
                        label="First Name"
                        name="firstname"
                        autoComplete="fname"
                        value={this.state.firstname}
                        onChange={this.handleInputChange}
                        autoFocus
                    />
                    <Box p={2} />

                    <TextField
                        variant="outlined"
                        required
                        fullWidth
                        type="text"
                        id="lastname"
                        label="Last Name"
                        name="lastname"
                        autoComplete="lname"
                        value={this.state.lastname} 
                        onChange={this.handleInputChange}
                        autoFocus
                    />
                    <Box p={2} />
                    <TextField
                        variant="outlined"
                        required
                        fullWidth
                        type="number"
                        id="aadharno"
                        label="Aadhar Number"
                        name="aadharno"
                        autoComplete="aadhar"
                        value={this.state.aadharno} 
                        onChange={this.handleInputChange}
                        autoFocus
                    />
                    <Box p={2} />
                    <TextField
                        variant="outlined"
                        required
                        fullWidth
                        type="number"
                        id="mobileno"
                        label="Mobile Number"
                        name="mobileno"
                        autoComplete="mobile"
                        value={this.state.mobileno} 
                        onChange={this.handleInputChange}
                        autoFocus
                    />
                    <Box p={2} />
                    <TextField
                        variant="outlined"
                        required
                        fullWidth
                        type="password"
                        id="password"
                        name="password"
                        label="Password"
                        autoComplete="current-password"
                        value={this.state.password} 
                        onChange={this.handleInputChange}
                        autoFocus
                    />
                    <Box p={2} />
                    <TextField
                        variant="outlined"
                        required
                        fullWidth
                        type="number"
                        id="accountno"
                        label="Account Number"
                        name="accountno"
                        autoComplete="accno"
                        value={this.state.accountno} 
                        onChange={this.handleInputChange}
                        autoFocus
                    />
                    <Box p={2} />
                    <TextField
                        variant="outlined"
                        required
                        fullWidth
                        type="text"
                        id="accountHolderName"
                        label="Account Holder Name"
                        name="accountHolderName"
                        autoComplete="accname"
                        value={this.state.accountHolderName} 
                        onChange={this.handleInputChange}
                        autoFocus
                    />

                    <Box p={2} />
                    <InputLabel htmlFor="accountType-native-simple">Account Type</InputLabel>
                    <Select
                        variant="outlined"
                        required
                        fullWidth
                        autoComplete="accounType"
                        value={this.state.accountType}
                        onChange={this.handleInputChange}
                        inputProps={{
                            name: 'accountType',
                            id: 'accountType',
                        }}
                        autoFocus
                        >
                        <option value="CURRENT">CURRENT</option>
                        <option value="SAVINGS">SAVINGS</option>
                        <option value="SALARY">SALARY</option>
                        <option value="FIXED DEPOSIT">FIXED DEPOSIT</option>
                        <option value="NRI">NRI</option>
                    </Select>

                    <Box p={2} />

                    <FormControlLabel
                        control={<Checkbox value="agree" color="primary" />}
                        label="I agree to all the terms and conditions"
                    />

                    <Button variant="contained" color="secondary" onClick={this.createCustomer}>
                        Submit
                    </Button>
                   
                    <Box p={1} />
                    <Grid container spacing={3} direction="row" justify="space-evenly" alignItems="center">
                        <Grid item padding={5} fontSize={20}>
                            <Link href="/login" variant="body2">
                                {"Already have an account? Sign in"}
                            </Link>
                        </Grid>
                    </Grid>
                </div>
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