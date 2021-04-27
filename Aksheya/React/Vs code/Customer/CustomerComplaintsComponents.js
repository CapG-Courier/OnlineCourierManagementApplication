import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as customerActions from '../store/actions/CustomerActions';
import Box from '@material-ui/core/Box';
import CustomerComplaintsPage from '../Bootstrap/CustomerComplaintsPage';
import TestNav2 from '../Bootstrap/TestNav2';
import '../Bootstrap/Design.css'; 

class GetAllComplaintsComponent extends Component {
 
    componentDidMount() {    

        const { customerActions, match } = this.props;
        customerActions.fetchAllComplaints(match.params.customerid);  
        
    }

    render() {
        return (
            <div class="container">
                <Box m={15}/>
                <CustomerComplaintsPage/>
                <TestNav2/>
                <Box m={5}/>
                {
                     this.props.complaints !== undefined ?
 
                        <div class="container">
                            <br></br>
                            <br></br>
                            <h2>Complaints!</h2>
                            <br></br>
                            <ul class="responsive-table">
                                <li class="table-header">
                                    <div class="col">Complaint ID</div>
                                    <div class="col">Consignment No.</div>
                                    <div class="col">Detailed Description</div>
                                    <div class="col">Short Description</div>
                                </li>
                            </ul>
                            <ul>
                                {
                                    this.props.complaints.map((complaint, index) =>
                                        <li class="table-row">
                                            <div class="col">{complaint.complaintId}</div>
                                            <div class="col">{complaint.consignmentNo}</div>
                                            <div class="col">{complaint.detailDescription}</div>
                                            <div class="col">{complaint.shortDescription}</div>
                                        </li>)
                                }
                            </ul>
                        </div>
                        :
                        <h3>Loading....</h3>
                }
            </div>
        );
    }
}
 
function mapStateToProps(state) {
 
    return { complaints: state.customerReducer.complaints }
}  
 
function mapDispatchToProps (dispatch) {
   return {
      customerActions : bindActionCreators(customerActions,dispatch)      
   }   
};

export default connect(mapStateToProps,mapDispatchToProps) (GetAllComplaintsComponent);