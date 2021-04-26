import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import Box from '@material-ui/core/Box';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import Grid from '@material-ui/core/Grid';
import { Link } from 'react-router-dom';
import { useParams } from 'react-router-dom';

const useStyles = makeStyles({
  root: {
    flexGrow: 1,
  },
});

export default function ImgMediaCard() {

    let { customerid } = useParams()
    Number(customerid);

  const classes = useStyles();

  return (
    <div className={classes.root}>
    <Grid container component="main" spacing={3} direction="row" justify="space-evenly" alignItems="center"> 
        <Grid item xs={6} sm={3}>
      <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Profile"
          height="200"
          image="https://alejandrocremades.com/wp-content/uploads/2020/09/Screen-Shot-2020-09-18-at-3.47.00-PM.png"
          title="Customer Profile"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Customer Profile
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Check and Update your profile here.
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      <Link to={`/profile/${customerid}`}><Button size="large" color="primary">
          Profile
        </Button></Link>
        {/* <Button size="small" color="primary">
          Learn More
        </Button> */}
      </CardActions>
    </Card>
    </Grid>

      <Grid item xs={6} sm={3}>
      <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Get Couriers"
          height="200"
          image="https://thumbs.dreamstime.com/b/happy-excited-pug-dog-delivery-box-204689445.jpg"
          title="Get Couriers"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Get All Couriers
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Get a list of all your registered couriers here.
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      <Link to={`/getCouriers/${customerid}`}><Button size="large" color="primary">
          List Couriers
        </Button></Link>
        {/* <Button size="small" color="primary">
          Learn More
        </Button> */}
      </CardActions>
    </Card>
    </Grid>

    <Grid item xs={6} sm={3}>
      <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Get Complaints"
          height="200"
          image="https://image.shutterstock.com/image-illustration/complaints-concept-word-on-folder-260nw-269047922.jpg"
          title="Get Complaints"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Get All Complaints
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Get a list of all your registered complaints here.
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      <Link to={`/getComplaints/${customerid}`}><Button size="large" color="primary">
          List Complaints
        </Button></Link>
        {/* <Button size="small" color="primary">
          Learn More
        </Button> */}
      </CardActions>
    </Card>
    </Grid>
    </Grid><Box m={10}></Box>

    <Grid container component="main" spacing={3} direction="row" justify="space-evenly" alignItems="center"> 
        <Grid item xs={14} sm={3}>
      <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Register Courier"
          height="200"
          image="https://image.freepik.com/free-vector/order-delivery-service-online-background_73174-203.jpg"
          title="Register Courier"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Initiate Courier
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Send or initiate the courier process here.
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      <Link to={`/newCourier`}><Button size="large" color="primary">
          Send Courier
        </Button></Link>
        {/* <Button size="small" color="primary">
          Learn More
        </Button> */}
      </CardActions>
    </Card>
    </Grid>
    <Grid item xs={14} sm={3}>
      <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Register Complaint"
          height="200"
          image="https://media.istockphoto.com/vectors/concept-of-complaint-vector-id858082574?k=6&m=858082574&s=612x612&w=0&h=dUnskAWJYPPk-ZSqgBWkz4w-2iV28r9XQi_kUAHxuco="
          title="Register Complaint"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Register a Complaint
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Leave a detailed complaint regarding your courier here.
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      <Link to={`/registerComplaint`}><Button size="large" color="primary">
          Register Complaint
        </Button></Link>
        {/* <Button size="small" color="primary">
          Learn More
        </Button> */}
      </CardActions>
    </Card>
    </Grid>
    </Grid>

    </div>
    
  );
}