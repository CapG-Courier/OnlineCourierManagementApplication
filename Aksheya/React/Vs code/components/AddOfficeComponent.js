import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { Redirect } from 'react-router-dom';
import * as managerActions from '../store/actions/ManagerActions';


class AddOfficeComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {

            openingTime: '',
            closingTime: ''

        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.createOffice = this.createOffice.bind(this);
    }

    handleInputChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    createOffice(e) {
        e.preventDefault();

        let payload = {

            openingTime: this.state.openingTime,
            closingTime: this.state.closingTime

        }

        const { managerActions, match } = this.props;
        managerActions.createOffice(payload, match.params.managerid);

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
            openingTime: '',
            closingTime: ''
        });
    }

    render() {

        if (this.props.office !== undefined) {

            const { match } = this.props;
            let empid = parseInt(match.params.managerid)
            return <Redirect to={`/manager/managerid=${empid}/Home`} />;
        }

        return (
            <div>
                <h3>Add Office</h3>
                <form onSubmit={this.createOffice}>
                    <table>
                        <tbody>
                            <tr>
                                <td><label>Opening Time:</label></td>
                                <td><input type="time" name="openingTime" id="openingTime" value={this.state.openingTime} onChange={this.handleInputChange}></input></td>
                            </tr>
                            <tr>
                                <td><label>Closing Time:</label></td>
                                <td><input type="time" name="closingTime" id="closingTime" value={this.state.closingTime} onChange={this.handleInputChange}></input></td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="submit" value="Submit"></input>
                </form>
            </div >
        );
    }
}

function mapStateToProps(state) {

    return { office: state.managerReducer.office }
}

function mapDispatchToProps(dispatch) {
    return {
        managerActions: bindActionCreators(managerActions, dispatch)
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(AddOfficeComponent);