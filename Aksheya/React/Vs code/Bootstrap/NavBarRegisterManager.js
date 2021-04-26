import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import IconButton from '@material-ui/core/IconButton';
import AccountCircle from '@material-ui/icons/AccountCircle';
import ArrowBackIcon from '@material-ui/icons/ArrowBack';
import MenuItem from '@material-ui/core/MenuItem';
import Menu from '@material-ui/core/Menu';
import ListItem from '@material-ui/core/ListItem';
import { Link } from 'react-router-dom';
import { useParams } from 'react-router-dom';

const useStyles = makeStyles((theme) => ({
    root: {
      flexGrow: 1,
    },
    menuButton: {
      marginRight: theme.spacing(2),
    },
    title: {
      flexGrow: 1,
    },
    largeIcon: {
        width: 60,
        height: 60,
      },
  }));

function ListItemLink(props) {
  return <ListItem button component="a" {...props} />;
}

export default function NavbarBarLogin () {

    let { managerid } = useParams()
    Number(managerid);

    const classes = useStyles();
    const [auth, setAuth] = React.useState(true);
    const [anchorEl, setAnchorEl] = React.useState(null);
    const open = Boolean(anchorEl);

    const handleChange = (event) => {
        setAuth(event.target.checked);
      };
    
      const handleMenu = (event) => {
        setAnchorEl(event.currentTarget);
      };
    
      const handleClose = () => {
        setAnchorEl(null);
      };

        return(

            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                {/* <IconButton edge="start" className={classes.menuButton} color="secondary" aria-label="menu">
                <Link to={`/`}><ArrowBackIcon /></Link>
                </IconButton> */}
                {/* <List component="nav" aria-label="secondary mailbox folders">
                    <ListItem button>
                    <ListItemText primary="Trash" />
                    </ListItem>
                    <ListItemLink href="#simple-list">
                    <ListItemText primary="Spam" />
                    </ListItemLink>
                </List> */}

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="/">Home<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/AboutUs">About Us<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/Services">Services<span class="sr-only">(current)</span></a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <IconButton
                            iconStyle={classes.largeIcon}
                            aria-label="account of current user"
                            aria-controls="menu-appbar"
                            aria-haspopup="true"
                            aria-setsize="large"
                            onClick={handleMenu}
                            color="secondary"
                        >
                        <AccountCircle />
                        </IconButton>
                        <Menu
                            id="menu-appbar"
                            anchorEl={anchorEl}
                            anchorOrigin={{
                            vertical: 'top',
                            horizontal: 'right',
                            }}
                            keepMounted
                            transformOrigin={{
                            vertical: 'top',
                            horizontal: 'right',
                            }}
                            open={open}
                            onClose={handleClose}
                        >
                        <Link to={`/`}><MenuItem>Logout</MenuItem></Link>
                        <Link to={`/manager/managerid=${managerid}/Home`}><MenuItem>Return Home</MenuItem></Link>
                        </Menu>
                    </form>
                </div>
            </nav>

        );

}