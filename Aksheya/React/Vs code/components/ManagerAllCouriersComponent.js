import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as managerActions from '../store/actions/ManagerActions';
import { Link } from 'react-router-dom';
 
class ManagerAllCouriersComponent extends Component {
 
    componentDidMount() {    

        const { managerActions, match } = this.props;
        managerActions.fetchAllCouriers(match.params.managerid);  
        
    }
    render() {

        const { match } = this.props;
        let managerid = Number(match.params.managerid);  
        
        return (
            <div class="container">
            <h2>Courier Details</h2>
            {
                 this.props.couriers !== undefined ?

                    <table class="table table-dark table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Courier ID</th>
                                <th>Consignment No.</th>
                                <th>Initiated Date</th>
                                <th>Delivered Date</th>
                                <th>Status</th>
                                <th>Customer ID</th>
                                <th>View Customer</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.props.couriers.map((courier, index) =>
                                    <tr>
                                        <td>{courier.courierId}</td>
                                        <td>{courier.consignmentNo}</td>
                                        <td>{courier.initiatedDate}</td>
                                        <td>{courier.deliveredDate}</td>
                                        <td>{courier.status}</td>
                                        <td>{courier.customer.customerid}</td>
                                        <td><Link to={`/getCustomer/${managerid}/view/${Number(courier.customer.customerid)}`}>View</Link></td>
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
 
    return { couriers: state.managerReducer.couriers }
}  
 
function mapDispatchToProps (dispatch) {
   return {
      managerActions : bindActionCreators(managerActions,dispatch)      
   }   
  };
 
export default connect(mapStateToProps,mapDispatchToProps) (ManagerAllCouriersComponent);