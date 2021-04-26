import React, { Component } from 'react';
import Carousel from 'react-bootstrap/Carousel'

export default class HomePage extends Component {

    render(){

        return (

            <Carousel fade>
                <Carousel.Item>
                    <img
                    className="d-block w-100"
                    src="https://shipox.com/wp-content/uploads/2020/06/blogimage-foster.jpg"
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
                    src="https://img.freepik.com/free-vector/courier-carrying-order-illustration_335657-479.jpg?size=626&ext=jpg"
                    alt="Third slide"
                    />

                    <Carousel.Caption>
                    <h3 style={{color:"black"}}>Customer Satisfaction</h3>
                    <p style={{color:"black"}}>Our Complaint services are the best in the world and customer satisfaction is our primary goal!</p>
                    </Carousel.Caption>
                </Carousel.Item>
                </Carousel>
            

        );

    }


}