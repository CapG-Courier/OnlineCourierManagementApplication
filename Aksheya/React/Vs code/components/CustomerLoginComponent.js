import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import {Redirect} from 'react-router-dom';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as homeActions from '../store/actions/HomeActions';
import CustomerComponent from './CustomerComponent';
 
class CustomerLoginComponent extends React.Component {
 
    constructor(props) {
        super(props);
        this.state = {
            customerid:0,
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
            customerid : this.state.customerid,
            password : this.state.password
        }
     
        if(this.validate()) {
            this.props.homeActions.doLogin(payload);        
        }
      
    }
 
    validate(){

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
 
        const { isAuthCustomer} = this.props;
 
        if(isAuthCustomer) {    
            
            return <Redirect to="/customer/Home" />;
        }        
        
        return(

            <div>
                {
                    (this.props.isAuthCustomer === false ) && <div>Invalid Login Credentials!</div>
                }

            <p>
            
            <input type="number" placeholder="Customer Id" name="customerid" id="customerid" value={this.state.customerid} onChange={this.handleInputChange}></input>
            <div className="text-danger">{this.state.errors.customerid}</div>

            </p>
            <p>

                <input type="text" placeholder="Password" name="password" id="password" value={this.state.password} onChange={this.handleInputChange}></input>
                <div className="text-danger">{this.state.errors.password}</div>

             </p>
            <p>
                <button onClick={this.doLogin}>Login</button>
                
            </p>
          </div>

        )
    }
}
 
function mapStateToProps(state) {
 
    return { 
        loginMessage: state.homeReducer.loginMessage,
        isAuthCustomer : state.homeReducer.isAuthCustomer
     }
}
 
function mapDispatchToProps(dispatch) {
    return {
        homeActions: bindActionCreators(homeActions, dispatch)
    }
};
 
export default connect(mapStateToProps, mapDispatchToProps)(CustomerLoginComponent);