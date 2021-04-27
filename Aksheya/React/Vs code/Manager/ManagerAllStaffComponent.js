import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as managerActions from '../store/actions/ManagerActions';
import { Link } from 'react-router-dom';
import Box from '@material-ui/core/Box';
import ManagerStaffsPage from '../Bootstrap/ManagerStaffsPage';
import TestNav2Manager from '../Bootstrap/TestNav2Manager';
import '../Bootstrap/Design.css';
 
class ManagerAllStaffComponent extends Component {
 
    componentDidMount() {    

        const { managerActions, match } = this.props;
        managerActions.fetchAllStaff(match.params.managerid);  
        
    }
    render() {

        const { match } = this.props;
        let managerid = Number(match.params.managerid);  

        return (
            <div class="container">
                <Box m={15}/>
                    <ManagerStaffsPage/>
                    <TestNav2Manager/>
                <Box m={5}/>
                {
                     this.props.staffs !== undefined ?
 
                        <div class="container">
                            <br></br>
                            <br></br>
                            <h2>Staff Details</h2>
                            <br></br>
                            <ul class="responsive-table">
                                <li class="table-header">
                                    <div class="col">Employee ID</div>
                                    <div class="col">Name</div>
                                    <div class="col">Role</div>
                                    <div class="col">Office ID</div>
                                    {/* <div class="col">View Staff</div> */}
                                </li>
                            </ul>
                            <ul>
                                {
                                    this.props.staffs.map((staff, index) =>
                                        <li class="table-row">
                                            <div class="col">{staff.empid}</div>
                                            <div class="col">{staff.name}</div>
                                            <div class="col">{staff.role}</div>
                                            <div class="col">{staff.office.officeid}</div>
                                           {/* <div class="col"><Link to={`/getStaff/${managerid}/view/${staff.empid}`}>View</Link></div> */}
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
 
    return { staffs: state.managerReducer.staffs }
}  
 
function mapDispatchToProps (dispatch) {
   return {
      managerActions : bindActionCreators(managerActions,dispatch)      
   }   
  };
 
export default connect(mapStateToProps,mapDispatchToProps) (ManagerAllStaffComponent);