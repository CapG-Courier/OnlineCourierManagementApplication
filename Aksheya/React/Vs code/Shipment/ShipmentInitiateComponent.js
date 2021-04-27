import React from 'react';
import { Redirect } from 'react-router-dom';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Alert from '@material-ui/lab/Alert';
import AlertTitle from '@material-ui/lab/AlertTitle';
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

            // const { match } = this.props.isAuthInitiate;
            // return <Redirect to={`/${Number(match.managerid)}/Shipment`} />

            return <Alert severity="success">
                        <AlertTitle>Success</AlertTitle>
                     You have successfully initiated the courier!
            </Alert>
        }

        return (

            <div>
                {
                    (this.props.isAuthInitiate === false) && <div>Could Not Initiate Courier!</div>
                }

                <TextField
                    variant="outlined"
                    required
                    fullWidth
                    type="number"
                    id="managerid"
                    label="Re-enter Manager Id"
                    name="managerid"
                    autoComplete="managerid"
                    value={this.state.managerid}
                    onChange={this.handleInputChange}
                    autoFocus
                />
                <Box m={2} />

                <TextField
                    variant="outlined"
                    required
                    fullWidth
                    type="number"
                    id="courierid"
                    label="Courier Id"
                    name="courierid"
                    autoComplete="courierid"
                    value={this.state.courierid}
                    onChange={this.handleInputChange}
                    autoFocus
                />
                <Box m={2} />

                <Button variant="contained" color="secondary" onClick={this.doInitiate}>
                    Initiate
                </Button>
                
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
