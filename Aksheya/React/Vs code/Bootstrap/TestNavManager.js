import React from 'react';
import clsx from 'clsx';
import { makeStyles, useTheme } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import List from '@material-ui/core/List';
import CssBaseline from '@material-ui/core/CssBaseline';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft';
import ChevronRightIcon from '@material-ui/icons/ChevronRight';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import LocalShippingIcon from '@material-ui/icons/LocalShipping';
import MailIcon from '@material-ui/icons/Mail';
import InfoIcon from '@material-ui/icons/Info';
import ExitToAppIcon from '@material-ui/icons/ExitToApp';
import BusinessIcon from '@material-ui/icons/Business';
import ClearAllIcon from '@material-ui/icons/ClearAll';
import FormatListBulletedIcon from '@material-ui/icons/FormatListBulleted';
import PersonAddIcon from '@material-ui/icons/PersonAdd';
import GroupAddIcon from '@material-ui/icons/GroupAdd';
import AddLocationIcon from '@material-ui/icons/AddLocation';
import PersonAddDisabledIcon from '@material-ui/icons/PersonAddDisabled';
import SupervisedUserCircleIcon from '@material-ui/icons/SupervisedUserCircle';
import { Link } from 'react-router-dom';
import { useParams } from 'react-router-dom';

const drawerWidth = 240;

const useStyles = makeStyles((theme) => ({

  root: {
    display: 'flex',
  },
  appBar: {
    zIndex: theme.zIndex.drawer + 1,
    transition: theme.transitions.create(['width', 'margin'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
  },
  appBarShift: {
    marginLeft: drawerWidth,
    width: `calc(100% - ${drawerWidth}px)`,
    transition: theme.transitions.create(['width', 'margin'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  menuButton: {
    marginRight: 36,
  },
  hide: {
    display: 'none',
  },
  drawer: {
    width: drawerWidth,
    flexShrink: 0,
    whiteSpace: 'nowrap',
  },
  drawerOpen: {
    width: drawerWidth,
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  drawerClose: {
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
    overflowX: 'hidden',
    width: theme.spacing(7) + 1,
    [theme.breakpoints.up('sm')]: {
      width: theme.spacing(9) + 1,
    },
  },
  toolbar: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'flex-end',
    padding: theme.spacing(0, 1),
    // necessary for content to be below app bar
    ...theme.mixins.toolbar,
  },
  content: {
    flexGrow: 1,
    padding: theme.spacing(3),
  },
}));

export default function MiniDrawer() {

    let { managerid } = useParams()
    Number(managerid);

  const classes = useStyles();
  const theme = useTheme();
  const [open, setOpen] = React.useState(false);

  const handleDrawerOpen = () => {
    setOpen(true);
  };

  const handleDrawerClose = () => {
    setOpen(false);
  };

  return (
    <div className={classes.root}>
      <CssBaseline />
      <AppBar
      style={{ background: '#28282B' }}
        position="fixed"
        className={clsx(classes.appBar, {
          [classes.appBarShift]: open,
        })}
      >
        <Toolbar>
          <IconButton
          color="inherit"
            aria-label="open drawer"
            onClick={handleDrawerOpen}
            edge="start"
            className={clsx(classes.menuButton, {
              [classes.hide]: open,
            })}
          >
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" noWrap>
            Manager Home Page
          </Typography>
        </Toolbar>
      </AppBar>
      <Drawer
        variant="permanent"
        className={clsx(classes.drawer, {
          [classes.drawerOpen]: open,
          [classes.drawerClose]: !open,
        })}
        classes={{
          paper: clsx({
            [classes.drawerOpen]: open,
            [classes.drawerClose]: !open,
          }),
        }}
      >
        <div className={classes.toolbar}>
          <IconButton color="inherit" onClick={handleDrawerClose}>
            {theme.direction === 'rtl' ? <ChevronRightIcon /> : <ChevronLeftIcon />}
          </IconButton>
        </div>
        <Divider />
        <List>
          {['Add Manager'].map((text, index) => (
            <ListItem button key={text}>
              <ListItemIcon color="secondary">{index % 2 === 0 ? <Link to= {`/addManager/${managerid}`}><PersonAddIcon  color="secondary"/></Link>: <InfoIcon />}</ListItemIcon>
              <ListItemText primary={text} />
            </ListItem>
          ))}
        </List>
        <Divider />
        <List>
          {['Add Staff'].map((text, index) => (
            <ListItem button key={text}>
              <ListItemIcon color="secondary">{index % 2 === 0 ? <Link to= {`/addStaff/${managerid}`}><GroupAddIcon  color="secondary"/></Link>: <InfoIcon />}</ListItemIcon>
              <ListItemText primary={text} />
            </ListItem>
          ))}
        </List>
        <Divider />
        <List>
          {['Add Office'].map((text, index) => (
            <ListItem button key={text}>
              <ListItemIcon color="secondary">{index % 2 === 0 ? <Link to= {`/addOffice/${managerid}`}><AddLocationIcon  color="secondary"/></Link>: <InfoIcon />}</ListItemIcon>
              <ListItemText primary={text} />
            </ListItem>
          ))}
        </List>
        <Divider />
        <List>
          {['Delete Staff'].map((text, index) => (
            <ListItem button key={text}>
              <ListItemIcon color="secondary">{index % 2 === 0 ? <Link to= {`/deleteStaff/${managerid}`}><PersonAddDisabledIcon  color="secondary"/></Link>: <InfoIcon />}</ListItemIcon>
              <ListItemText primary={text} />
            </ListItem>
          ))}
        </List>
        <Divider />
        <List>
          {['Get All Couriers'].map((text, index) => (
            <ListItem button key={text}>
              <ListItemIcon color="secondary">{index % 2 === 0 ? <Link to= {`/getAllCouriers/${managerid}`}><FormatListBulletedIcon  color="secondary"/></Link>: <InfoIcon />}</ListItemIcon>
              <ListItemText primary={text} />
            </ListItem>
          ))}
        </List>
        <Divider />
        <List>
          {['Get All Complaints'].map((text, index) => (
            <ListItem button key={text}>
              <ListItemIcon color="secondary">{index % 2 === 0 ? <Link to= {`/getAllComplaints/${managerid}`}><ClearAllIcon  color="secondary"/></Link>: <InfoIcon />}</ListItemIcon>
              <ListItemText primary={text} />
            </ListItem>
          ))}
        </List>
        <Divider />
        <List>
          {['Get All Offices'].map((text, index) => (
            <ListItem button key={text}>
              <ListItemIcon color="secondary">{index % 2 === 0 ? <Link to= {`/getAllOffice/${managerid}`}><BusinessIcon  color="secondary"/></Link>: <InfoIcon />}</ListItemIcon>
              <ListItemText primary={text} />
            </ListItem>
          ))}
        </List>
        <Divider />
        <List>
          {['Get All Staffs'].map((text, index) => (
            <ListItem button key={text}>
              <ListItemIcon color="secondary">{index % 2 === 0 ? <Link to= {`/getAllStaff/${managerid}`}><SupervisedUserCircleIcon  color="secondary"/></Link>: <InfoIcon />}</ListItemIcon>
              <ListItemText primary={text} />
            </ListItem>
          ))}
        </List>
        <Divider />
        <List>
          {['Shipment'].map((text, index) => (
            <ListItem button key={text}>
              <ListItemIcon color="secondary">{index % 2 === 0 ? <Link to= {`/${managerid}/Shipment`}><LocalShippingIcon  color="secondary"/></Link>: <InfoIcon />}</ListItemIcon>
              <ListItemText primary={text} />
            </ListItem>
          ))}
        </List>
        <Divider />
        <List>
          {['Logout'].map((text, index) => (
            <ListItem button key={text}>
              <ListItemIcon>{index % 2 === 0 ? <Link to= {`/`}><ExitToAppIcon color="secondary"/></Link> : <MailIcon />}</ListItemIcon>
              <ListItemText primary={text} />
            </ListItem>
          ))}
        </List>
      </Drawer>
    </div>
  );
}