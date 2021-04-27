import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import Grid from '@material-ui/core/Grid';
import VpnKeyTwoToneIcon from '@material-ui/icons/VpnKeyTwoTone';
import PersonAddTwoToneIcon from '@material-ui/icons/PersonAddTwoTone';
import { Link } from 'react-router-dom';

const useStyles = makeStyles({
  root: {
    maxWidth: 345,
  },
});

export default function ImgMediaCard() {
  const classes = useStyles();

  return (
    <Grid container component="main" spacing={24} direction="row" justify="center" alignItems="center"> 
        <Grid item md={3}>
      <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Customer Login"
          height="180"
          image="https://i.channeldailynews.com/wp-content/uploads/2016/11/CustomerWS-620x250.png"
          title="Customer Login"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Customer
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Customers please login here to start your journey
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      {/* <Link to={`/login`}><Button size="large" color="primary">
          Login
        </Button></Link> */}
        {/* <Button size="small" color="primary">
          Learn More
        </Button> */}
        <Button
        variant="outlined"
        color="primary"
        className={classes.button}
        startIcon={<VpnKeyTwoToneIcon />}
      >
        <Link to={`/login`}>Login</Link>
      </Button>
      </CardActions>
    </Card>
    </Grid>

      <Grid item md={3}>
      <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Manager Login"
          height="200"
          image="https://www.bluebeyondconsulting.com/wp-content/uploads/2019/11/Manager-Training-Infographic-Featured-Image.jpg"
          title="Manager Login"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Manager
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Managers can login here.
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      {/* <Link to={`/managerlogin`}><Button size="large" color="primary">
          Login
        </Button></Link> */}
        {/* <Button size="small" color="primary">
          Learn More
        </Button> */}
        <Button
        variant="outlined"
        color="primary"
        className={classes.button}
        startIcon={<VpnKeyTwoToneIcon />}
      >
        <Link to={`/managerlogin`}>Login</Link>
      </Button>
      </CardActions>
    </Card>
    </Grid>

    <Grid item md={3}>
      <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Customer Register"
          height="200"
          image="https://assets-news.housing.com/news/wp-content/uploads/2020/06/10201220/Frequently-asked-questions-on-property-registration-in-India-FB-1200x700-compressed.jpg"
          title="Customer Register"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Customer Register
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Customers register here to avail our services.
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      {/* <Link to={`/register`}><Button size="large" color="primary">
          Register
        </Button></Link> */}
        {/* <Button size="small" color="primary">
          Learn More
        </Button> */}
        <Button
        variant="outlined"
        color="primary"
        className={classes.button}
        startIcon={<PersonAddTwoToneIcon />}
      >
        <Link to={`/register`}>Register</Link>
      </Button>
      </CardActions>
    </Card>
    </Grid>
    
    </Grid>
    
  );
}