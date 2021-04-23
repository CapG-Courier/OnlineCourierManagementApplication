import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as managerActions from '../store/actions/ManagerActions';
import { Link } from 'react-router-dom';
 
class ManagerAllComplaintsComponent extends Component {
 
    componentDidMount() {    

        const { managerActions, match } = this.props;
        managerActions.fetchAllComplaints(match.params.managerid);  
        
    }
    render() {

        const { match } = this.props;
        let managerid = Number(match.params.managerid);  
        
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
                                <th>Short Description</th>
                                <th>Detailed Description</th>
                                <th>Customer ID</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.props.complaints.map((complaint, index) =>
                                    <tr>
                                        <td>{complaint.complaintId}</td>
                                        <td>{complaint.consignmentNo}</td>
                                        <td>{complaint.shortDescription}</td>
                                        <td>{complaint.detailDescription}</td>
                                        <td>{complaint.customer.customerid}</td>
                                        <td><Link to={`/getCustomer/${managerid}/view/${Number(complaint.customer.customerid)}`}>View</Link></td>
                                    </tr>)
                            }
                        </tbody>
                    </table>
                    :
                    <h3>No Complaints!</h3>
            }
        </div>
        );
    }
}
 
function mapStateToProps(state) {
 
    return { complaints: state.managerReducer.complaints }
}  
 
function mapDispatchToProps (dispatch) {
   return {
      managerActions : bindActionCreators(managerActions,dispatch)      
   }   
  };
 
export default connect(mapStateToProps,mapDispatchToProps) (ManagerAllComplaintsComponent);