import React from 'react';
import Avatar from '@material-ui/core/Avatar';
import CssBaseline from '@material-ui/core/CssBaseline';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import ContactMailIcon from '@material-ui/icons/ContactMail';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import CustomerAddressComponent from '../Customer/CustomerAddressComponent';
import TestNav2 from './TestNav2';
import Paper from '@material-ui/core/Paper';

function Copyright() {
  return (
    <Typography variant="body2" color="textSecondary" align="center">
      {'Copyright © '}
      <Link color="inherit" href="/">
        Online Courier Management
      </Link>{' '}
      {new Date().getFullYear()}
      {'.'}
    </Typography>
  );
}

const useStyles = makeStyles((theme) => ({
    paperContainer: {
        backgroundImage: `url(https://cdn.statically.io/img/venngage-wordpress.s3.amazonaws.com/uploads/2018/09/Simple-White-Pattern-Background-Image.jpg)`,
        backgroundRepeat: 'no-repeat',
        backgroundSize: 'cover',
    },
    paper: {
        marginTop: theme.spacing(0),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        
    },
    avatar: {
        margin: theme.spacing(1),
        backgroundColor: theme.palette.secondary.main,
    },
    form: {
        width: '100%', // Fix IE 11 issue.
        marginTop: theme.spacing(5),
       
    },
    submit: {
        margin: theme.spacing(0, 0 ,0),
    },
    // formControl: {
    //   margin: theme.spacing(1),
    //   minWidth: 120,
    // },
    selectEmpty: {
      marginTop: theme.spacing(2),
    },
}));

export default function SignIn() {
  const classes = useStyles();

  return (
    <Paper className={classes.paperContainer}>
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <Box m={8}/>
      <TestNav2/>
      <div className={classes.paper}>
        <Avatar className={classes.avatar}>
          <ContactMailIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Customer Address Registration
        </Typography>
        <form className={classes.form} noValidate>
            <Grid container component="main" spacing={24} direction="row" justify="center" alignItems="center">
                <CustomerAddressComponent />
            </Grid>
        </form>
      </div>
     
     <Box p={2.5} />
      <Box mt={8}>
        <Copyright />
      </Box>
    </Container>
    </Paper>
  );
}