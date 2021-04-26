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

export default function ManagerComplaintsPage () {
    const classes = useStyles();

        return (

            <Card>
            <CardActionArea>
                <CardMedia
                component="img"
                alt="Loading"
                height="200"
                image="https://i.gifer.com/PG23.gif"
                title="Loading"
                />
            </CardActionArea>
            </Card>

        )
}