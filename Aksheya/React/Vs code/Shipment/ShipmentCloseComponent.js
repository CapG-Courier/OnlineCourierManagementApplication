import React from 'react';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import Box from '@material-ui/core/Box';
import { Redirect } from 'react-router-dom';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import Alert from '@material-ui/lab/Alert';
import AlertTitle from '@material-ui/lab/AlertTitle';
import * as shipmentActions from '../store/actions/ShipmentActions';

class ShipmentCloseComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            courierid: 0,
            managerid: 0,
        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.doClose = this.doClose.bind(this);

    }

    handleInputChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    doClose(e) {

        e.preventDefault();
        const payload = {
            courierid: this.state.courierid,
            managerid: this.state.managerid
        }

        this.props.shipmentActions.doClose(payload);

    }

    render() {

        const { isAuthClose } = this.props;

        if (isAuthClose) {

            // const { match } = this.props.isAuthClose;
            // return <Redirect to={`/${Number(match.managerid)}/Shipment`} />

            return <Alert severity="success">
                        <AlertTitle>Success</AlertTitle>
                     You have successfully closed the courier!
            </Alert>
        }

        return (

            <div>
                {
                    (this.props.isAuthClose === false) && <div>Could Not Close Courier!</div>
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

                <Button variant="contained" color="secondary" onClick={this.doClose}>
                    Close
                </Button>
                
            </div>

        )
    }
}

function mapStateToProps(state) {

    return {
        closeMessage: state.shipmentReducer.closeMessage,
        isAuthClose: state.shipmentReducer.isAuthClose
    }
}

function mapDispatchToProps(dispatch) {
    return {
        shipmentActions: bindActionCreators(shipmentActions, dispatch)
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(ShipmentCloseComponent);