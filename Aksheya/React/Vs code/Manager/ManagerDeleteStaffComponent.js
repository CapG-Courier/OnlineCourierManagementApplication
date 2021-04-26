import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import Box from '@material-ui/core/Box';
import { Redirect } from 'react-router-dom';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import Alert from '@material-ui/lab/Alert';
import AlertTitle from '@material-ui/lab/AlertTitle';
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

            // let mid = parseInt(this.state.managerid)
            // return <Redirect to={`/manager/managerid=${mid}/Home`} />;

            return <Alert severity="success">
                        <AlertTitle>Success</AlertTitle>
                     You have successfully deleted the staff member!
            </Alert>
        }

        return (

            <div>
                {
                    (this.props.isAuthDelete === false) && <div>Could Not Delete Employee!</div>
                }

                <TextField
                    variant="outlined"
                    required
                    fullWidth
                    type="number"
                    id="managerid"
                    label="Re-enter Manager Id."
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
                    id="empid"
                    label="Employee to Delete"
                    name="empid"
                    autoComplete="empid"
                    value={this.state.empid}
                    onChange={this.handleInputChange}
                    autoFocus
                />
                <Box m={2} />

                <Button variant="contained" color="secondary" onClick={this.doDelete}>
                    Delete
                </Button>

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