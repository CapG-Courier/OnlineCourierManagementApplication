import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as managerActions from '../store/actions/ManagerActions';
 
class ManagerStaffComponent extends Component {

    componentDidMount() {  
        
        const { managerActions, match } = this.props;
        managerActions.fetchStaff(match.params.managerid, match.params.empid);    
        
    }

    render() {
        const { employee } = this.props;
        return (
            <div class="container">
                <h2>Staff Details</h2>
                {
                     employee !== undefined ?
 
                        <table class="table table-dark table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Employee ID</th>
                                    <th>Employee Name</th>
                                    <th>Role</th>
                                    <th>Office ID</th>
                                    <th>Office Opening Time.</th>
                                    <th>Office Closing Time</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                        <tr>
                                            <td>{employee.empid}</td>
                                            <td>{employee.name}</td>
                                            <td>{employee.role}</td>
                                            <td>{employee.officeid}</td>
                                            <td>{employee.openingTime}</td>
                                            <td>{employee.closingTime}</td>
                                        </tr>
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
 
    return { employee: state.managerReducer.employee }
}  
 
function mapDispatchToProps (dispatch) {
   return {
      managerActions : bindActionCreators(managerActions,dispatch)      
   }   
  };
 
export default connect(mapStateToProps,mapDispatchToProps) (ManagerStaffComponent);