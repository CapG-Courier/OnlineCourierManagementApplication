import React from 'react';
import Avatar from '@material-ui/core/Avatar';
import CssBaseline from '@material-ui/core/CssBaseline';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import CancelIcon from '@material-ui/icons/Cancel';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import Paper from '@material-ui/core/Paper';
import ShipmentRejectComponent from '../Shipment/ShipmentRejectComponent';
import TestNav3Shipment from './TestNav3Shipment';
import Footer from './Footer';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardMedia from '@material-ui/core/CardMedia';

function Copyright() {
  return (
    <Typography position= "fixed-bottom" variant="body2" color="textSecondary" align="center">
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
        backgroundImage: `url(https://st4.depositphotos.com/12501784/23802/v/600/depositphotos_238020828-stock-video-abstract-pattern-black-white-texture.jpg)`,
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
    <TestNav3Shipment/>
    <Box m={15}/>
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <Box m={5}/>
      <Card>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Reject"
          height="200"
          image="https://i.pinimg.com/originals/9b/36/7c/9b367cb0eb8efdcae58e62422e2233d8.gif"
          title="Reject"
        />
      </CardActionArea>
    </Card>
    <Box m={5}/>
      <div className={classes.paper}>
        <Avatar className={classes.avatar}>
          <CancelIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Reject Courier
        </Typography>
        <form className={classes.form} noValidate>
            <Grid container component="main" spacing={24} direction="row" justify="center" alignItems="center">
                <ShipmentRejectComponent />
            </Grid>
        </form>
      </div>
     
     <Box p={2.5} />
      <Box mt={8}>
        <Copyright />
      </Box>
    </Container>
    <Footer/>
    </Paper>
  );
}