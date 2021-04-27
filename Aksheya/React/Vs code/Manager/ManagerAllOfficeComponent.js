import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as managerActions from '../store/actions/ManagerActions';
import { Link } from 'react-router-dom';
import '../Bootstrap/Design.css';
import Box from '@material-ui/core/Box';
import ManagerOfficesPage from '../Bootstrap/ManagerOfficesPage';
import TestNav2Manager from '../Bootstrap/TestNav2Manager';
import AddLocationTwoToneIcon from '@material-ui/icons/AddLocationTwoTone';
import DeleteTwoToneIcon from '@material-ui/icons/DeleteTwoTone';
import IconButton from '@material-ui/core/IconButton';
 
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
 
                        <div class="container">
                            <br></br>
                            <br></br>
                            <h2>Office Details</h2>
                            <br></br>
                            <ul class="responsive-table">
                                <li class="table-header">
                                    <div class="col">Office ID</div>
                                    <div class="col">Opening Time</div>
                                    <div class="col">Closing Time</div>
                                    <div class="col">Update Address</div>
                                    <div class="col">Delete Office</div>
                                </li>
                            </ul>
                            <ul>
                                {
                                    this.props.offices.map((office, index) =>
                                        <li class= "table-row">
                                            <div class="col">{office.officeid}</div>
                                            <div class="col">{office.openingTime}</div>
                                            <div class="col">{office.closingTime}</div>
                                            {/* <div class="col"><Link to={`/addAddress/${match.params.managerid}/office/${office.officeid}`}>Update</Link></div>
                                            <div class="col"><Link to={`/deleteOffice/${match.params.managerid}/office/${office.officeid}`}>Delete</Link></div> */}
                                            <div class= "col">
                                                <IconButton size="large" color="secondary" >
                                                <Link to={`/addAddress/${match.params.managerid}/office/${office.officeid}`}>
                                                    <AddLocationTwoToneIcon fontSize="large" text-align="center" color="secondary" />
                                                </Link>
                                                </IconButton>
                                            </div>
                                            <div class= "col">
                                                <IconButton size="large" color="secondary" >
                                                <Link to={`/deleteOffice/${match.params.managerid}/office/${office.officeid}`}>
                                                    <DeleteTwoToneIcon fontSize="large" text-align="center" color="secondary" />
                                                </Link>
                                                </IconButton>
                                            </div>
                                        </li>)
                                }
                            </ul>
                        </div>
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
