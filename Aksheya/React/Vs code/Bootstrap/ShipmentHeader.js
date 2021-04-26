import React, { Component } from 'react';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardMedia from '@material-ui/core/CardMedia';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles({
    root: {
      maxWidth: 1000,
    },
  });

export default function ShipmentHeader () {
    const classes = useStyles();

        return (

            <Card>
            <CardActionArea>
                <CardMedia
                component="img"
                alt="Loading"
                height="200"
                image="https://blog.roambee.com/hubfs/Blog%20Post%20Images/6%20Reasons%20You%20Should%20Set%20Up%20Your%20Own%20Air%20Cargo%20Tracking%20System/Air-Cargo-Tracking-System.gif"
                title="Loading"
                />
            </CardActionArea>
            </Card>

        )
}