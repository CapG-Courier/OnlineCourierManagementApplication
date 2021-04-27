import React from 'react';
import { Redirect } from 'react-router-dom';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as homeActions from '../store/actions/HomeActions';

import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import Link from '@material-ui/core/Link';
import Paper from '@material-ui/core/Paper';
import Box from '@material-ui/core/Box';
import Grid from '@material-ui/core/Grid';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import Typography from '@material-ui/core/Typography';

class CustomerLoginComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            customerid: 0,
            password: '',
            errors: {}
        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.doLogin = this.doLogin.bind(this);

    }

    handleInputChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    doLogin(e) {

        e.preventDefault();
        const payload = {
            customerid: this.state.customerid,
            password: this.state.password
        }

        if (this.validate()) {
            this.props.homeActions.doLogin(payload);
        }

    }

    validate() {

        let customerid = this.state.customerid;
        let password = this.state.password;
        let errors = {};
        let isValid = true;

        if (!customerid) {
            isValid = false;
            errors["customerid"] = "Please enter a valid Customer Id.";
        }

        if (!password) {
            isValid = false;
            errors["password"] = "Incorrect Password!";
        }

        this.setState({
            errors: errors
        });

        return isValid;
    }

    render() {

        const { isAuthCustomer } = this.props;

        if (isAuthCustomer) {

            let cid = parseInt(this.state.customerid)
            return <Redirect to={`/customer/customerid=${cid}/Home`} />;
        }

        return (

            <div>
                {
                    (this.props.isAuthCustomer === false) && <div>Invalid Login Credentials!</div>
                }

            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              type="number"
              id="customerid"
              label="Customer Id"
              name="customerid"
              autoComplete="customerid"
              value={this.state.customerid} 
              onChange={this.handleInputChange}
              autoFocus
            />

            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              id="password"
              value={this.state.password} 
              onChange={this.handleInputChange}
              autoComplete="password"
            />

            <FormControlLabel
              control={<Checkbox value="remember" color="primary" />}
              label="Remember me"
            />

            <Button
              type="submit"
              fullWidth
              variant="contained"
              color="primary"
              onClick={this.doLogin}
            >
              Log In
            </Button>

            <Grid container>
              <Grid item>
                <Link href="/register" variant="body2">
                  {"Don't have an account? Sign Up"}
                </Link>
              </Grid>
            </Grid>

                {/* <p>
                    <input type="number" placeholder="Customer Id" name="customerid" id="customerid" value={this.state.customerid} onChange={this.handleInputChange}></input>
                    <div className="text-danger">{this.state.errors.customerid}</div>
                </p> */}
                {/* <p>
                    <input type="password" placeholder="Password" name="password" id="password" value={this.state.password} onChange={this.handleInputChange}></input>
                    <div className="text-danger">{this.state.errors.password}</div>
                </p> */}
                {/* <p>
                    <button onClick={this.doLogin}>Login</button>
                </p> */}
            </div>

        )
    }
}

function mapStateToProps(state) {

    return {
        loginMessage: state.homeReducer.loginMessage,
        isAuthCustomer: state.homeReducer.isAuthCustomer
    }
}

function mapDispatchToProps(dispatch) {
    return {
        homeActions: bindActionCreators(homeActions, dispatch)
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(CustomerLoginComponent);