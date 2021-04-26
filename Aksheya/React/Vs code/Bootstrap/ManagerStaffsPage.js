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

export default function ManagerStaffsPage () {
    const classes = useStyles();

        return (

            <Card>
            <CardActionArea>
                <CardMedia
                component="img"
                alt="Loading"
                height="200"
                image="https://assets.materialup.com/uploads/41c33108-8b6c-459e-99f5-cb7f2f3d4d4b/preview.gif"
                title="Loading"
                />
            </CardActionArea>
            </Card>

        )
}