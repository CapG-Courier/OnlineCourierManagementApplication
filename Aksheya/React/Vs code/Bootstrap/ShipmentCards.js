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

export default function ShipmentCards() {

    let { managerid } = useParams()
    Number(managerid);

  const classes = useStyles();

  return (
    <div className={classes.root}>
    <Grid container component="main" spacing={3} direction="row" justify="space-evenly" alignItems="center"> 
        <Grid item xs={6} sm={3}>
      <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Initiate Process"
          height="200"
          image="https://thumbs.dreamstime.com/b/initiate-text-written-red-speech-bubble-stamp-213649963.jpg"
          title="Initiate Process"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Initiate Process
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Initiate the courier process here.
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      <Link to={`/initiateCourier/${managerid}`}><Button size="large" color="primary">
          Initiate
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
          alt="Close Process"
          height="200"
          image="https://c8.alamy.com/comp/HDXTRH/delivered-stamp-sign-seal-HDXTRH.jpg"
          title="Close Process"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Close Courier
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Close the courier process here.
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      <Link to={`/closeCourier/${managerid}`}><Button size="large" color="primary">
          Close
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
          alt="Reject Courier"
          height="200"
          image="https://poetsandquants.com/wp-content/uploads/sites/5/2019/10/reject1.jpg"
          title="Reject Courier"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Reject Courier
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Reject the courier process here.
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      <Link to={`/rejectCourier/${managerid}`}><Button size="large" color="primary">
          Reject
        </Button></Link>
        {/* <Button size="small" color="primary">
          Learn More
        </Button> */}
      </CardActions>
    </Card>
    </Grid>
    </Grid>

    <Box m={5}/>
    <Grid container component="main" spacing={3} direction="row" justify="space-evenly" alignItems="center"> 
    <Grid item xs={6} sm={3}>
      <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Get Status"
          height="200"
          image="https://media.istockphoto.com/photos/status-word-written-in-wooden-cube-newspaper-picture-id1142949938?k=6&m=1142949938&s=170667a&w=0&h=PscW5X2dh1pjmbjzs8u2XtDOZhK7X4TD-Ckd4AR30sc="
          title="Get Status"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Get Status
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            View all courier statuses here.
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      <Link to={`/getStatus/${managerid}`}><Button size="large" color="primary">
          Check Status
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