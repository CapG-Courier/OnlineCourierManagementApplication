import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as shipmentActions from '../store/actions/ShipmentActions';
import '../Bootstrap/Design.css';
import Box from '@material-ui/core/Box';
import ShipmentStatusesPage from '../Bootstrap/ShipmentStatusesPage';
import TestNav3Shipment from '../Bootstrap/TestNav3Shipment';
 
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

                    <div class="container">
                        <br></br>
                        <br></br>
                        <h2>Courier Status</h2>
                        <br></br>
                        <ul class="responsive-table">
                            <li class="table-header">
                                <div class="col">Courier ID</div>
                                <div class="col">Customer ID</div>
                                <div class="col">Status</div>
                            </li>
                        </ul>
                        <ul>
                            {
                                this.props.statuses.map((status, index) =>
                                    <li class="table-row">
                                        <div class="col">{status.courierId}</div>
                                        <div class="col">{status.customer.customerid}</div>
                                        <div class="col">{status.status}</div>
                                    </li>)
                            }
                        </ul>
                    </div>
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