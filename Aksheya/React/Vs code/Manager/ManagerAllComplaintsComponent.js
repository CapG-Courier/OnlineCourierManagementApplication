import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as managerActions from '../store/actions/ManagerActions';
import { Link } from 'react-router-dom';
import '../Bootstrap/Design.css';
import IconButton from '@material-ui/core/IconButton';
import Button from '@material-ui/core/Button';
import Box from '@material-ui/core/Box';
import ManagerComplaintsPage from '../Bootstrap/ManagerComplaintsPage';
import TestNav2Manager from '../Bootstrap/TestNav2Manager';
import PageviewTwoToneIcon from '@material-ui/icons/PageviewTwoTone';
 
class ManagerAllComplaintsComponent extends Component {
 
    componentDidMount() {    

        const { managerActions, match } = this.props;
        managerActions.fetchAllComplaints(match.params.managerid);  
        
    }
    render() {

        const { match } = this.props;
        let managerid = Number(match.params.managerid);  
        // <ComplaintsDesign />
        return (
            <div className="styles.ComplaintsDesign">
                <Box m={15}/>
              <ManagerComplaintsPage/>
                <TestNav2Manager/>
                <Box m={5}/>
            
            {
                this.props.complaints !== undefined ?

                    <div class="container">
                        <br></br>
                        <br></br>
                        <h2>Complaint Details</h2>
                        <br></br>
                        <ul class="responsive-table">
                            <li class="table-header">
                                <div class="col">Complaint ID</div>
                                <div class="col">Consignment No.</div>
                                <div class="col">Short Description</div>
                                <div class="col">Detailed Description</div>
                                <div class="col">View Customer</div>
                            </li>
                        </ul>
                        <ul class="responsive-table">
                            {
                                this.props.complaints.map((complaint, index) =>
                                    <li class= "table-row">
                                        <div class= "col">{complaint.complaintId}</div>
                                        <div class= "col">{complaint.consignmentNo}</div>
                                        <div class= "col">{complaint.shortDescription}</div>
                                        <div class= "col">{complaint.detailDescription}</div>
                                        <div class= "col">
                                        <IconButton size="large" color="secondary" >
                                        <Link to={`/getCustomer/${managerid}/view/${Number(complaint.customer.customerid)}`}>
                                            <PageviewTwoToneIcon fontSize="large" text-align="center" color="secondary" />
                                        </Link>
                                        </IconButton>
                                        </div>
                                    </li>)
                            }
                        </ul>
                    </div>
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
