import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import { Redirect } from 'react-router-dom';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as shipmentActions from '../store/actions/ShipmentActions';

class ShipmentInitiateComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            courierid: 0,
            managerid: 0,
        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.doInitiate = this.doInitiate.bind(this);

    }

    handleInputChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    doInitiate(e) {

        e.preventDefault();
        const payload = {
            courierid: this.state.courierid,
            managerid: this.state.managerid
        }

        this.props.shipmentActions.doInitiate(payload);

    }

    render() {

        const { isAuthInitiate } = this.props;

        if (isAuthInitiate) {

            const { match } = this.props;
            return <Redirect to={`/${Number(match.params.managerid)}/Shipment`} />
        }

        return (

            <div>
                {
                    (this.props.isAuthInitiate === false) && <div>Could Not Initiate Courier!</div>
                }

                <p>
                    <label>Re-enter Manager Id:</label>
                    <input type="number" placeholder="Manager Id" name="managerid" id="managerid" value={this.state.managerid} onChange={this.handleInputChange}></input>

                </p>
                <p>
                    <label>Courier to Initiate:</label>
                    <input type="number" placeholder="Courier Id" name="courierid" id="courierid" value={this.state.courierid} onChange={this.handleInputChange}></input>

                </p>
                <p>
                    <button onClick={this.doInitiate}>Initiate</button>

                </p>
            </div>

        )
    }
}

function mapStateToProps(state) {

    return {
        initiateMessage: state.shipmentReducer.initiateMessage,
        isAuthInitiate: state.shipmentReducer.isAuthInitiate
    }
}

function mapDispatchToProps(dispatch) {
    return {
        shipmentActions: bindActionCreators(shipmentActions, dispatch)
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(ShipmentInitiateComponent);