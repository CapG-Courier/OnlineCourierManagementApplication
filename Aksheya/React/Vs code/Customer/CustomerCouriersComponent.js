import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as customerActions from '../store/actions/CustomerActions';
import { Link } from 'react-router-dom';
 
class GetAllCouriersComponent extends Component {
 
    componentDidMount() {    

        const { customerActions, match } = this.props;
        customerActions.fetchAllCouriers(match.params.customerid);  
        
    }
    render() {
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
                                           {/* <td><Link to={`/customerid=${courier.customer.customerid}/checkStatus/${courier.consignmentNo}`}>Check Status</Link></td> */}
                                        </tr>)
                                }
                            </tbody>
                        </table>
                        :
                        <h3>Loading....</h3>
                }
            </div>
        );
    }
}
 
function mapStateToProps(state) {
 
    return { couriers: state.customerReducer.couriers }
}  
 
function mapDispatchToProps (dispatch) {
   return {
      customerActions : bindActionCreators(customerActions,dispatch)      
   }   
  };
 
export default connect(mapStateToProps,mapDispatchToProps) (GetAllCouriersComponent);