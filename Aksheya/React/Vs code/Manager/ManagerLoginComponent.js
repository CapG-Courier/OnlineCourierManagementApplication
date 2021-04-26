import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import Button from '@material-ui/core/Button';
import Grid from '@material-ui/core/Grid';
import Link from '@material-ui/core/Link';
import {Redirect} from 'react-router-dom';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as homeActions from '../store/actions/HomeActions';
 
class ManagerLoginComponent extends React.Component {
 
    constructor(props) {
        super(props);
        this.state = {
            empId:0,
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
            empId : this.state.empId,
            password : this.state.password
        }
     
        if(this.validate()) {
            this.props.homeActions.doLoginManager(payload);        
        }
      
    }
 
    validate(){

        let empId = this.state.empId;
        let password = this.state.password;
        let errors = {};
        let isValid = true;
    
        if (!empId) {
          isValid = false;
          errors["empId"] = "Please enter a valid Customer Id.";
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
 
        const { isAuthManager} = this.props;
 
        if(isAuthManager) {    

            let eid = parseInt(this.state.empId)
            return <Redirect to={`/manager/managerid=${eid}/Home`} />;
        }        
        
        return(

            <div>
                {
                    (this.props.isAuthManager === false ) && <div>Invalid Login Credentials!</div>
                }

            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              type="number"
              id="empId"
              label="Employee Id"
              name="empId"
              autoComplete="empId"
              value={this.state.empId} 
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
                <Link href="/" variant="body2">
                  {"Return to home"}
                </Link>
              </Grid>
            </Grid>

            {/* <p>
            
            <input type="number" placeholder="Employee Id" name="empId" id="empId" value={this.state.empId} onChange={this.handleInputChange}></input>
            <div className="text-danger">{this.state.errors.empId}</div>

            </p>
            <p>

                <input type="text" placeholder="Password" name="password" id="password" value={this.state.password} onChange={this.handleInputChange}></input>
                <div className="text-danger">{this.state.errors.password}</div>

             </p>
            <p>
                <button onClick={this.doLogin}>Login</button>
                
            </p> */}
          </div>

        )
    }
}
 
function mapStateToProps(state) {
 
    return { 
        loginMessage: state.homeReducer.loginMessage,
        isAuthManager : state.homeReducer.isAuthManager
     }
}
 
function mapDispatchToProps(dispatch) {
    return {
        homeActions: bindActionCreators(homeActions, dispatch)
    }
};
 
export default connect(mapStateToProps, mapDispatchToProps)(ManagerLoginComponent);