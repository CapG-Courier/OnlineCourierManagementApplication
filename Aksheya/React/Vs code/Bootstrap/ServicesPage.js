import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardMedia from '@material-ui/core/CardMedia';
import Typography from '@material-ui/core/Typography';
import Grid from '@material-ui/core/Grid';
import Carousel from 'react-bootstrap/Carousel';
import Box from '@material-ui/core/Box';
import Paper from '@material-ui/core/Paper';
import { CardContent } from '@material-ui/core';
import Navbar from './Navbar';
import Footer from './Footer';

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  paper: {
    padding: theme.spacing(5),
    textAlign: 'center',
    color: theme.palette.text.disabled,
    backgroundColor: 'grey'
  },
}));

export default function ImgMediaCard() {

  const classes = useStyles();

  return (

    <div className={classes.root}>
      <Navbar/>
      <Box m={2}/>
      <Typography color= "secondary" gutterBottom variant="h1" component="h2"> Our Services </Typography>
      <Box m={5}/>
      <Carousel fade>
                <Carousel.Item>
                  <Card>
                    <CardActionArea>
                      <CardMedia
                        component="img"
                        alt="Intelligent Routing"
                        height="400"
                        image="https://oceanicresources.com/wp-content/uploads/2017/04/5.jpg"
                        title="Intelligent Routing"
                      />
                      </CardActionArea>
                  </Card>
                    <Carousel.Caption>
                   Intelligent Routing
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                <Card>
                    <CardActionArea>
                      <CardMedia
                        component="img"
                        alt="Same Day Delivery"
                        height="400"
                        image="http://www.meratask.com/blog/wp-content/uploads/2016/08/same-day-delivery-2.jpg"
                        title="Same Day Delivery"
                      />
                    </CardActionArea>
                  </Card>

                    <Carousel.Caption>
                    Same Day Delivery 
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                <Card>
                    <CardActionArea>
                      <CardMedia
                        component="img"
                        alt="Express Delivery"
                        height="400"
                        image="https://graphicsfamily.com/wp-content/uploads/edd/2020/12/Free-Express-Delivery-Logo-Design-Psd-scaled.jpg"
                        title="Express Delivery"
                      />
                    </CardActionArea>
                  </Card>

                    <Carousel.Caption>
                    Express Delivery
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                <Card>
                    <CardActionArea>
                      <CardMedia
                        component="img"
                        alt="Best Price"
                        height="400"
                        image="https://mlqmtwka8c9g.i.optimole.com/gOh5_1g.Ga1T~1cfa5/w:auto/h:auto/q:75/https://www.competethemes.com/wp-content/uploads/2019/05/wordpress-price-comparison-plugins.png"
                        title="Best Price"
                      />
                    </CardActionArea>
                  </Card>

                    <Carousel.Caption>
                    Best Price
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                <Card>
                    <CardActionArea>
                      <CardMedia
                        component="img"
                        alt="Add-on Insurance"
                        height="400"
                        image="https://realtyplusmag.com/wp-content/uploads/2020/05/Fire-Property-Insurance-Coverage-Gets-Extension.jpg"
                        title="Add-on Insurance"
                      />
                    </CardActionArea>
                  </Card>

                    <Carousel.Caption>
                   Add-on Insurance
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                <Card>
                    <CardActionArea>
                      <CardMedia
                        component="img"
                        alt="Warehousing"
                        height="400"
                        image="https://www.thedollarbusiness.com/assets/magazines/thumb/31043_31043_1620.jpg"
                        title="Ware Housing"
                      />
                    </CardActionArea>
                  </Card>

                    <Carousel.Caption>
                    Warehousing
                    </Carousel.Caption>
                </Carousel.Item>

                </Carousel>

                <Box m={5}/>

                <Grid container component="main" spacing={3} direction="row" justify="space-around" alignItems="center">
      <Grid item xs>
      <Paper className={classes.paper}>
      <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Couriers"
          height="200"
          image="https://gsmtasks.com/wp-content/themes/gsm_task/images/courier-routes.png"
          title="Couriers"
        />
      </CardActionArea>
      <CardContent>
      Intelligent Routing
      <Typography variant="body2" color="textSecondary" component="p">
            We offer world class intelligent routing Services.
          </Typography>
      </CardContent>
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
          image="https://static.wixstatic.com/media/28da16_889494a709ef4f71b53f7b89adfa0d49~mv2.jpg/v1/fill/w_800,h_362,al_c,q_90/28da16_889494a709ef4f71b53f7b89adfa0d49~mv2.jpg"
          title="Manager Login"
        />
      </CardActionArea>
      <CardContent>
      Same Day Delivery
      <Typography variant="body2" color="textSecondary" component="p">
            Why worry when our same day delivery is here.
          </Typography>
      </CardContent>
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
          image="https://image.shutterstock.com/image-vector/sticker-label-express-delivery-timer-260nw-1589034418.jpg"
          title="Customer Register"
        />
      </CardActionArea>
      <CardContent>
        Express Delivery
        <Typography variant="body2" color="textSecondary" component="p">
            Urgent ?? use our courier services .
          </Typography>
      </CardContent>
    </Card>
    </Paper>
    </Grid>
    </Grid>
    <Box m={10}/>


    <Grid container component="main" spacing={3} direction="row" justify="space-around" alignItems="center">
      <Grid item xs>
      <Paper className={classes.paper}>
      <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Couriers"
          height="200"
          image="https://cdn4.vectorstock.com/i/1000x1000/70/43/best-price-and-special-offer-tag-discount-vector-27517043.jpg"
          title="Couriers"
        />
      </CardActionArea>
      <CardContent>
      Reasonable Price
      <Typography variant="body2" color="textSecondary" component="p">
            Lowest possible prices.
          </Typography>
      </CardContent>
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
          image="https://img.freepik.com/free-vector/insurance-concept-idea-security-protection-property-life-from-damage-illustration-cartoon-style_277904-4431.jpg?size=626&ext=jpg"
          title="Manager Login"
        />
      </CardActionArea>
      <CardContent>
      Extra Insurance Options
      <Typography variant="body2" color="textSecondary" component="p">
            Add-on insurance to ensure safety.
          </Typography>
      </CardContent>
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
          image="https://images.prismic.io/flowspace-marketing/214fc3a1-19d8-404d-bbb9-a0afbb791617_Warehouse+Storage+-+HOMEPAGE.svg?auto=compress,format"
          title="Customer Register"
        />
      </CardActionArea>
      <CardContent>
        WareHousing
        <Typography variant="body2" color="textSecondary" component="p">
            Safest courier storage facilities.
          </Typography>
      </CardContent>
    </Card>
    </Paper>
    </Grid>
    </Grid>
    <Box m={10}/>
    <Footer/>
    </div>

  );

}