import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import TestNav2Manager from '../Bootstrap/TestNav2Manager';
import Box from '@material-ui/core/Box';
import * as managerActions from '../store/actions/ManagerActions';
import { Link } from 'react-router-dom';
import ManagerOfficesPage from '../Bootstrap/ManagerOfficesPage';
 
class ManagerAllOfficeComponent extends Component {
 
    componentDidMount() {    

        const { managerActions, match } = this.props;
        managerActions.fetchAllOffice(match.params.managerid);  
        
    }
    render() {

        const { match } = this.props;
        let managerid = Number(match.params.managerid);  

        return (
            <div class="container">
                <Box m={15}/>
              <ManagerOfficesPage/>
                <TestNav2Manager/>
                <Box m={5}/>
                {
                     this.props.offices !== undefined ?
 
                        <table class="table table-dark table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Office ID</th>
                                    <th>Opening Time</th>
                                    <th>Closing Time</th>
                                    <th>Update Address</th>
                                    <th>Delete Office</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.props.offices.map((office, index) =>
                                        <tr>
                                            <td>{office.officeid}</td>
                                            <td>{office.openingTime}</td>
                                            <td>{office.closingTime}</td>
                                           <td><Link to={`/addAddress/${match.params.managerid}/office/${office.officeid}`}>Update</Link></td>
                                           <td><Link to={`/deleteOffice/${match.params.managerid}/office/${office.officeid}`}>Delete</Link></td>
                                        </tr>)
                                }
                            </tbody>
                        </table>
                        :
                        <h3>No Offices to show!</h3>
                }
            </div>
        );
    }
}
 
function mapStateToProps(state) {
 
    return { offices: state.managerReducer.offices }
}  
 
function mapDispatchToProps (dispatch) {
   return {
      managerActions : bindActionCreators(managerActions,dispatch)      
   }   
  };
 
export default connect(mapStateToProps,mapDispatchToProps) (ManagerAllOfficeComponent);