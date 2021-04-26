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
          alt="Add Manager"
          height="200"
          image="https://alejandrocremades.com/wp-content/uploads/2020/09/Screen-Shot-2020-09-18-at-3.47.00-PM.png"
          title="Add Manager"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Add Manager
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Add a new manager here.
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      <Link to={`/addManager/${managerid}`}><Button size="large" color="primary">
          New Manager
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
          alt="Add Staff"
          height="200"
          image="https://alejandrocremades.com/wp-content/uploads/2020/09/Screen-Shot-2020-09-18-at-3.47.00-PM.png"
          title="Add Staff"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Add Staff
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Add a new Staff member here.
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      <Link to={`/addStaff/${managerid}`}><Button size="large" color="primary">
          New Staff
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
          alt="Add Office"
          height="200"
          image="https://alejandrocremades.com/wp-content/uploads/2020/09/Screen-Shot-2020-09-18-at-3.47.00-PM.png"
          title="Add Office"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Add Office
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Add a new Courier Office Outlet here.
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      <Link to={`/addOffice/${managerid}`}><Button size="large" color="primary">
          New Office
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
          image="https://alejandrocremades.com/wp-content/uploads/2020/09/Screen-Shot-2020-09-18-at-3.47.00-PM.png"
          title="Get Complaints"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Get All Complaints
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            View all customer complaints here.
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      <Link to={`/getAllComplaints/${managerid}`}><Button size="large" color="primary">
          Get Complaints
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