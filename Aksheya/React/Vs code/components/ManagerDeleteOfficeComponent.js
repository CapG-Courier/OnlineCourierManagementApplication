import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import { Redirect } from 'react-router-dom';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as managerActions from '../store/actions/ManagerActions';

class ManagerDeleteOfficeComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            officeid: 0,
            managerid: 0,
        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.doDeleteOffice = this.doDeleteOffice.bind(this);

    }

    handleInputChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    doDeleteOffice(e) {

        e.preventDefault();
        const payload = {
            officeid: this.state.officeid,
            managerid: this.state.managerid
        }

        this.props.managerActions.doDeleteOffice(payload);

    }

    render() {

        const { isAuthDeleteOffice } = this.props;

        if (isAuthDeleteOffice) {

            const { match } = this.props;
            return <Redirect to={`/manager/managerid=${Number(match.params.managerid)}/Home`} />;
        }

        return (

            <div>
                {
                    (this.props.isAuthDeleteOffice === false) && <div>Could Not Delete Office!</div>
                }

                <p>
                    <label>Re-enter Manager Id:</label>
                    <input type="number" placeholder="Manager Id" name="managerid" id="managerid" value={this.state.managerid} onChange={this.handleInputChange}></input>

                </p>
                <p>
                    <label>Office to Delete:</label>
                    <input type="number" placeholder="Office Id" name="officeid" id="officeid" value={this.state.officeid} onChange={this.handleInputChange}></input>

                </p>
                <p>
                    <button onClick={this.doDeleteOffice}>Delete</button>

                </p>
            </div>

        )
    }
}

function mapStateToProps(state) {

    return {
        deleteMessage: state.managerReducer.deleteMessage,
        isAuthDeleteOffice: state.managerReducer.isAuthDeleteOffice
    }
}

function mapDispatchToProps(dispatch) {
    return {
        managerActions: bindActionCreators(managerActions, dispatch)
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(ManagerDeleteOfficeComponent);