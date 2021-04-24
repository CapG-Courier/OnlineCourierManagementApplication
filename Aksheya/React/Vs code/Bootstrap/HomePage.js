import React, { Component } from 'react';
import Carousel from 'react-bootstrap/Carousel'

export default class HomePage extends Component {

    render(){

        return (

            <Carousel fade>
                <Carousel.Item>
                    <img
                    className="d-block w-100"
                    src="https://image.freepik.com/free-vector/delivery-service-24-7-illustration-logistics-shipping-tracking-technology_33099-644.jpg"
                    alt="First slide"
                    />
                    <Carousel.Caption>
                    <h3>24 Hour Delivery</h3>
                    <p>We offer courier services around the clock!</p>
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
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                    className="d-block w-100"
                    src="https://www.sevenhillscourier.com/wp-content/uploads/2019/02/FMT-New-Banner-Courier-1-1010x312.png"
                    alt="Third slide"
                    />

                    <Carousel.Caption>
                    <h3>Customer Satisfaction</h3>
                    <p>Our Complaint services are the best in the world and customer satisfaction is our primary goal!</p>
                    </Carousel.Caption>
                </Carousel.Item>
                </Carousel>
            

        );

    }


}