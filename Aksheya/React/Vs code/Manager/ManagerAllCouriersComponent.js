import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as managerActions from '../store/actions/ManagerActions';
import { Link } from 'react-router-dom';
import '../Bootstrap/Design.css'; 
import IconButton from '@material-ui/core/IconButton';
import Button from '@material-ui/core/Button';
import Box from '@material-ui/core/Box';
import ManagerCouriersPage from '../Bootstrap/ManagerCouriersPage';
import TestNav2Manager from '../Bootstrap/TestNav2Manager';
import PageviewTwoToneIcon from '@material-ui/icons/PageviewTwoTone';

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
            {/* <h2>Couriers Details</h2> */}
            <Box m={15}/>
                <ManagerCouriersPage/>
                <TestNav2Manager/>
            <Box m={5}/>
            {
                 this.props.couriers !== undefined ?

                    <div class="container">
                        <br></br>
                        <br></br>
                        <h2>Couriers Details</h2>
                        <br></br>
                        <ul class="responsive-table">
                            <li class="table-header">
                                <div class="col">Courier ID</div>
                                <div class="col">Consignment No.</div>
                                <div class="col">Initiated Date</div>
                                <div class="col">Delivered Date </div>
                                <div class="col">Status</div>
                                <div class="col">Customer ID</div>
                                <div class="col">View Customer</div>
                            </li>
                        </ul>
                        <ul>
                            {
                                this.props.couriers.map((courier, index) =>
                                    <li class= "table-row">
                                        <div class="col">{courier.courierId}</div>
                                        <div class="col">{courier.consignmentNo}</div>
                                        <div class="col">{courier.initiatedDate}</div>
                                        <div class="col">{courier.deliveredDate}</div>
                                        <div class="col">{courier.status}</div>
                                        <div class="col">{courier.customer.customerid}</div>
                                        {/* <div class="col"><Link to={`/getCustomer/${managerid}/view/${Number(courier.customer.customerid)}`}>View</Link></div> */}
                                        <div class= "col">
                                        <IconButton size="large" color="secondary" >
                                        <Link to={`/getCustomer/${managerid}/view/${Number(courier.customer.customerid)}`}>
                                            <PageviewTwoToneIcon fontSize="large" text-align="center" color="secondary" />
                                        </Link>
                                        </IconButton>
                                        </div>
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
 
    return { couriers: state.managerReducer.couriers }
}  
 
function mapDispatchToProps (dispatch) {
   return {
      managerActions : bindActionCreators(managerActions,dispatch)      
   }   
  };
 
export default connect(mapStateToProps,mapDispatchToProps) (ManagerAllCouriersComponent);
