import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import { Redirect } from 'react-router-dom';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as managerActions from '../store/actions/ManagerActions';

class ManagerDeleteStaffComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            empid: 0,
            managerid: 0,
        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.doDelete = this.doDelete.bind(this);

    }

    handleInputChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    doDelete(e) {

        e.preventDefault();
        const payload = {
            empid: this.state.empid,
            managerid: this.state.managerid
        }

        this.props.managerActions.doDelete(payload);

    }

    render() {

        const { isAuthDelete } = this.props;

        if (isAuthDelete) {

            let mid = parseInt(this.state.managerid)
            return <Redirect to={`/manager/managerid=${mid}/Home`} />;
        }

        return (

            <div>
                {
                    (this.props.isAuthDelete === false) && <div>Could Not Delete Employee!</div>
                }

                <p>
                    <label>Re-enter Manager Id:</label>
                    <input type="number" placeholder="Manager Id" name="managerid" id="managerid" value={this.state.managerid} onChange={this.handleInputChange}></input>

                </p>
                <p>
                    <label>Employee to Delete:</label>
                    <input type="number" placeholder="Employee Id" name="empid" id="empid" value={this.state.empid} onChange={this.handleInputChange}></input>

                </p>
                <p>
                    <button onClick={this.doDelete}>Delete</button>

                </p>
            </div>

        )
    }
}

function mapStateToProps(state) {

    return {
        deleteMessage: state.managerReducer.deleteMessage,
        isAuthDelete: state.managerReducer.isAuthDelete
    }
}

function mapDispatchToProps(dispatch) {
    return {
        managerActions: bindActionCreators(managerActions, dispatch)
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(ManagerDeleteStaffComponent);