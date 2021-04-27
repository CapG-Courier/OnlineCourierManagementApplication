import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardMedia from '@material-ui/core/CardMedia';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import Grid from '@material-ui/core/Grid';
import { Link } from 'react-router-dom';
import { useParams } from 'react-router-dom';
import Carousel from 'react-bootstrap/Carousel'
import Box from '@material-ui/core/Box';
import Paper from '@material-ui/core/Paper';

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  paper: {
    padding: theme.spacing(10),
    textAlign: 'center',
    color: theme.palette.text.disabled,
  },
}));

export default function ImgMediaCard() {

    let { managerid } = useParams()
    Number(managerid);

  const classes = useStyles();

  return (

    <div className={classes.root}>
      <Box m={10}/>
      <Typography color= "secondary" gutterBottom variant="h5" component="h2">Welcome Manager!</Typography>
      <Box m={5}/>
      <Carousel fade>
                <Carousel.Item>
                  <Card>
                    <CardActionArea>
                      <CardMedia
                        component="img"
                        alt="Manager"
                        height="400"
                        image="https://www.shyftcareers.com/wp-content/uploads/2017/10/bigstock-A-Concept-Of-Recruitment-Proce-98806625.jpg"
                        title="Manager"
                      />
                      </CardActionArea>
                  </Card>
                    <Carousel.Caption>
                    <Link to={`/addManager/${managerid}`}><Button size="large" variant="contained" color="secondary">
                      Add Manager
                    </Button></Link>
                    <Box m={10} />
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                <Card>
                    <CardActionArea>
                      <CardMedia
                        component="img"
                        alt="Office"
                        height="400"
                        image="https://i.pinimg.com/736x/c1/59/09/c15909bb1e8ff7196f816c528c976754.jpg"
                        title="Office"
                      />
                    </CardActionArea>
                  </Card>

                    <Carousel.Caption>
                    <Link to={`/addOffice/${managerid}`}><Button size="large" variant="contained" color="secondary">
                      Add Office
                    </Button></Link>
                    <Box m={10} />
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                <Card>
                    <CardActionArea>
                      <CardMedia
                        component="img"
                        alt="Staff"
                        height="400"
                        image="https://t4.ftcdn.net/jpg/01/89/84/71/360_F_189847147_Z3kExMXHgIWhAzqQ021olzbeGkryleCA.jpg"
                        title="Staff"
                      />
                    </CardActionArea>
                  </Card>

                    <Carousel.Caption>
                    <Link to={`/addStaff/${managerid}`}><Button size="large" variant="contained" color="secondary">
                      Add Staff
                    </Button></Link>
                    <Box m={10} />
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                <Card>
                    <CardActionArea>
                      <CardMedia
                        component="img"
                        alt="AllStaff"
                        height="400"
                        image="https://st4.depositphotos.com/15985744/25381/v/1600/depositphotos_253816984-stock-illustration-creative-team-characters-flat-vector.jpg"
                        title="AllStaff"
                      />
                    </CardActionArea>
                  </Card>

                    <Carousel.Caption>
                    <Link to={`/getAllStaff/${managerid}`}><Button size="large" variant="contained" color="secondary">
                      Get All Staff
                    </Button></Link>
                    <Box m={10} />
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                <Card>
                    <CardActionArea>
                      <CardMedia
                        component="img"
                        alt="AllCouriers"
                        height="400"
                        image="https://rurbanco.com/images/section-icons/courier-banner.jpg"
                        title="AllCouriers"
                      />
                    </CardActionArea>
                  </Card>

                    <Carousel.Caption>
                    <Link to={`/getAllCouriers/${managerid}`}><Button size="large" variant="contained" color="secondary">
                      Get All Couriers
                    </Button></Link>
                    <Box m={10} />
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                <Card>
                    <CardActionArea>
                      <CardMedia
                        component="img"
                        alt="AllComplaints"
                        height="400"
                        image="http://sakshamexp.com/wp-content/uploads/2016/02/Perfect-Courier-Banner-11441251290.png"
                        title="AllComplaints"
                      />
                    </CardActionArea>
                  </Card>

                    <Carousel.Caption>
                    <Link to={`/getAllComplaints/${managerid}`}><Button size="large" variant="contained" color="secondary">
                      Get All Complaints
                    </Button></Link>
                    <Box m={10} />
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                <Card>
                    <CardActionArea>
                      <CardMedia
                        component="img"
                        alt="AllOffices"
                        height="400"
                        image="https://thumbs.dreamstime.com/b/coworking-office-interior-modern-center-creative-workplace-environment-horizontal-banner-empty-workspace-flat-coworking-office-126961346.jpg"
                        title="AllOffices"
                      />
                    </CardActionArea>
                  </Card>

                    <Carousel.Caption>
                    <Link to={`/getAllOffice/${managerid}`}><Button size="large" variant="contained" color="secondary">
                      Get All Offices
                    </Button></Link>
                    <Box m={10} />
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                <Card>
                    <CardActionArea>
                      <CardMedia
                        component="img"
                        alt="Shipment"
                        height="400"
                        image="https://chitchats.com/blog/wp-content/uploads/2019/11/worldwide-shipping-banner-1.jpg"
                        title="Shipment"
                      />
                    </CardActionArea>
                  </Card>

                    <Carousel.Caption>
                    <Link to={`/${managerid}/Shipment`}><Button size="large"  variant="contained"color="secondary">
                      Go To Shipment
                    </Button></Link>
                    <Box m={10} />
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                <Card>
                    <CardActionArea>
                      <CardMedia
                        component="img"
                        alt="DeleteStaff"
                        height="400"
                        image="https://www.jmmnews.com/wp-content/uploads/2017/04/Why-do-Firms-Delete-Brands-banner-1140x410.jpg"
                        title="DeleteStaff"
                      />
                    </CardActionArea>
                  </Card>

                    <Carousel.Caption>
                    <Link to={`/deleteStaff/${managerid}`}><Button size="large" variant="contained" color="primary">
                      Delete Staff
                    </Button></Link>
                    <Box m={10} />
                    </Carousel.Caption>
                </Carousel.Item>
                </Carousel>
                <Grid container component="main" spacing={3} direction="row" justify="space-around" alignItems="center">
      <Grid item xs>
      <Paper className={classes.paper}>
      <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Couriers"
          height="200"
          image="https://www.parallax.lk/wp-content/uploads/2020/07/image_2020_07_15T18_22_19_818Z.png"
          title="Couriers"
        />
      </CardActionArea>
    </Card>
    </Paper>
    </Grid>

      <Grid item xs>
      <Paper className={classes.paper}>
      <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Manager Login"
          height="200"
          image="https://innovecs.com/wp-content/uploads/2019/08/package-delivery-worldwide.png"
          title="Manager Login"
        />
      </CardActionArea>
    </Card>
    </Paper>
    </Grid>

    <Grid item xs>
      <Paper className={classes.paper}>
      <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Customer Register"
          height="200"
          image="https://innovecs.com/wp-content/uploads/2019/07/share-of-delivery-cost-in-logistics.png"
          title="Customer Register"
        />
      </CardActionArea>
    </Card>
    </Paper>
    </Grid>
    </Grid>
    <Box m={10}/>
    </div>

  );

}