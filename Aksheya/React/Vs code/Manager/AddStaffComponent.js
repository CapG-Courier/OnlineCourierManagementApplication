import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { Redirect } from 'react-router-dom';
import * as managerActions from '../store/actions/ManagerActions';


class AddStaffComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {

            name: '',
            office: {
                officeid: 0,
            },
            role: ''

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
        managerActions.createStaff(payload, match.params.managerid);

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
            role: ''
        });
    }

    render() {

        if (this.props.staff !== undefined) {

            const { match } = this.props;
            let empid = parseInt(match.params.managerid)
            return <Redirect to={`/manager/managerid=${empid}/Home`} />;
        }

        return (
            <div>
                <h3>Add Staff</h3>
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
                </form>
                {/* 
                {
                    this.props.courier !== undefined &&
                    <Redirect to="/customer/Home" />
                } */}

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