import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import { Redirect } from 'react-router-dom';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as shipmentActions from '../store/actions/ShipmentActions';

class ShipmentRejectComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            courierid: 0,
            managerid: 0,
        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.doReject = this.doReject.bind(this);

    }

    handleInputChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    doReject(e) {

        e.preventDefault();
        const payload = {
            courierid: this.state.courierid,
            managerid: this.state.managerid
        }

        this.props.shipmentActions.doReject(payload);

    }

    render() {

        const { isAuthReject } = this.props;

        if (isAuthReject) {

            const { match } = this.props;
            return <Redirect to={`/${Number(match.params.managerid)}/Shipment`} />
        }

        return (

            <div>
                {
                    (this.props.isAuthReject === false) && <div>Could Not Reject Courier!</div>
                }

                <p>
                    <label>Re-enter Manager Id:</label>
                    <input type="number" placeholder="Manager Id" name="managerid" id="managerid" value={this.state.managerid} onChange={this.handleInputChange}></input>

                </p>
                <p>
                    <label>Courier to Reject:</label>
                    <input type="number" placeholder="Courier Id" name="courierid" id="courierid" value={this.state.courierid} onChange={this.handleInputChange}></input>

                </p>
                <p>
                    <button onClick={this.doReject}>Close</button>

                </p>
            </div>

        )
    }
}

function mapStateToProps(state) {

    return {
        rejectMessage: state.shipmentReducer.rejectMessage,
        isAuthReject: state.shipmentReducer.isAuthReject
    }
}

function mapDispatchToProps(dispatch) {
    return {
        shipmentActions: bindActionCreators(shipmentActions, dispatch)
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(ShipmentRejectComponent);