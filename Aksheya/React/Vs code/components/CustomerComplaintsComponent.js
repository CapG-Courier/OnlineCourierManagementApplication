import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as customerActions from '../store/actions/CustomerActions';
import { Link } from 'react-router-dom';
 
class GetAllComplaintsComponent extends Component {
 
    componentDidMount() {    

        const { customerActions, match } = this.props;
        customerActions.fetchAllComplaints(match.params.customerid);  
        
    }

    render() {
        return (
            <div class="container">
                <h2>Complaint Details</h2>
                {
                     this.props.complaints !== undefined ?
 
                        <table class="table table-dark table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Complaint ID</th>
                                    <th>Consignment No.</th>
                                    <th>Detailed Description</th>
                                    <th>Short Description</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.props.complaints.map((complaint, index) =>
                                        <tr>
                                            <td>{complaint.complaintId}</td>
                                            <td>{complaint.consignmentNo}</td>
                                            <td>{complaint.detailDescription}</td>
                                            <td>{complaint.shortDescription}</td>
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
 
    return { complaints: state.customerReducer.complaints }
}  
 
function mapDispatchToProps (dispatch) {
   return {
      customerActions : bindActionCreators(customerActions,dispatch)      
   }   
  };
 
export default connect(mapStateToProps,mapDispatchToProps) (GetAllComplaintsComponent);