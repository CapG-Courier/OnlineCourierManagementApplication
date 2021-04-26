import React from 'react';
import Avatar from '@material-ui/core/Avatar';
import CssBaseline from '@material-ui/core/CssBaseline';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import AddCircleIcon from '@material-ui/icons/AddCircle';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import Paper from '@material-ui/core/Paper';
import AddOfficeComponent from '../Manager/AddOfficeComponent';
import TestNav2Manager from './TestNav2Manager';
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
        backgroundImage: `url(https://i.pinimg.com/736x/d2/fd/ca/d2fdca8c981215fe1bf81def0ca3ffa3.jpg)`,
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
    <TestNav2Manager/>
    <Box m={15}/>
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <Box m={5}/>
      <Card>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Office"
          height="200"
          image="https://cdn.dribbble.com/users/2918596/screenshots/7770857/media/909acc7317ae2049404fa257d97a68b6.gif"
          title="Office"
        />
      </CardActionArea>
    </Card>
    <Box m={5}/>
      <div className={classes.paper}>
        <Avatar className={classes.avatar}>
          <AddCircleIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Office Registration
        </Typography>
        <form className={classes.form} noValidate>
            <Grid container component="main" spacing={24} direction="row" justify="center" alignItems="center">
                <AddOfficeComponent />
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