import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import Box from '@material-ui/core/Box';
import * as shipmentActions from '../store/actions/ShipmentActions';
import { Link } from 'react-router-dom';
import TestNav3Shipment from '../Bootstrap/TestNav3Shipment';
import ShipmentStatusesPage from '../Bootstrap/ShipmentStatusesPage';
 
class ShipmentStatusesComponent extends Component {
 
    componentDidMount() {    

        const { shipmentActions, match } = this.props;
        shipmentActions.fetchAllStatuses(match.params.managerid);  
        
    }
    render() {

        const { match } = this.props;
        let managerid = Number(match.params.managerid);  
        
        return (
            <div class="container">
            <Box m={15}/>
              <ShipmentStatusesPage/>
                <TestNav3Shipment/>
                <Box m={5}/>
            {
                 this.props.statuses !== undefined ?

                    <table class="table table-dark table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Courier ID</th>
                                <th>Customer ID</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.props.statuses.map((status, index) =>
                                    <tr>
                                        <td>{status.courierId}</td>
                                        <td>{status.customer.customerid}</td>
                                        <td>{status.status}</td>
                                    </tr>)
                            }
                        </tbody>
                    </table>
                    :
                    <h3>No Couriers!</h3>
            }
        </div>
        );
    }
}
 
function mapStateToProps(state) {
 
    return { statuses: state.shipmentReducer.statuses }
}  
 
function mapDispatchToProps (dispatch) {
   return {
      shipmentActions : bindActionCreators(shipmentActions,dispatch)      
   }   
  };
 
export default connect(mapStateToProps,mapDispatchToProps) (ShipmentStatusesComponent);