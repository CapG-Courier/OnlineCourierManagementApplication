import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as managerActions from '../store/actions/ManagerActions';
import { Link } from 'react-router-dom';
 
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
                <h2>Staff Details</h2>
                {
                     this.props.staffs !== undefined ?
 
                        <table class="table table-dark table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Employee ID</th>
                                    <th>Name</th>
                                    <th>Role</th>
                                    <th>Office ID</th>
                                    <th>View Staff</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.props.staffs.map((staff, index) =>
                                        <tr>
                                            <td>{staff.empid}</td>
                                            <td>{staff.name}</td>
                                            <td>{staff.role}</td>
                                            <td>{staff.office.officeid}</td>
                                           <td><Link to={`/getStaff/${managerid}/view/${staff.empid}`}>View</Link></td>
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
 
    return { staffs: state.managerReducer.staffs }
}  
 
function mapDispatchToProps (dispatch) {
   return {
      managerActions : bindActionCreators(managerActions,dispatch)      
   }   
  };
 
export default connect(mapStateToProps,mapDispatchToProps) (ManagerAllStaffComponent);