import React, { Component } from 'react';
import Carousel from 'react-bootstrap/Carousel';
import Box from '@material-ui/core/Box';

export default class HomePage extends Component {

    render(){

        return (
            <Carousel fade>
                <Carousel.Item>
                    <img
                    className="d-block w-100"
                    src="https://img.freepik.com/free-vector/delivery-man-riding-scooter-with-delivery-case-box-road-downtown-area-night-delivery-service-business_34259-583.jpg?size=626&ext=jpg"
                    alt="First slide"
                    />
                    <Carousel.Caption>
                    <h3>24 Hour Delivery</h3>
                    <p>We offer courier services around the clock around the world!</p>
                    <Box m={10} />
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                    className="d-block w-100"
                    src="https://d2kh7o38xye1vj.cloudfront.net/wp-content/uploads/2019/01/2019-01-28.jpg"
                    alt="Second slide"
                    />

                    <Carousel.Caption>
                    <h3>Fastest Delivery Service in India!</h3>
                    <p>Our services have been awarded the Fastest Delivery Service award!</p>
                    <Box m={10} />
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                    className="d-block w-100"
                    src="https://cdn.shopify.com/s/files/1/0070/7032/files/HolidayDelivery-illustration.jpg?v=1602854666"
                    alt="Third slide"
                    />

                    <Carousel.Caption>
                    <h3>Customer Satisfaction</h3>
                    <p>Our Complaint services are the best in the world and customer satisfaction is our primary goal!</p>
                    <Box m={10} />
                    </Carousel.Caption>
                </Carousel.Item>
                </Carousel>
            

        );

    }


}