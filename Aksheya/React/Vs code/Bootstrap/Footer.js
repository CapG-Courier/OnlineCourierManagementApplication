import React, { Component } from 'react';
import FacebookIcon from '@material-ui/icons/Facebook';
import InstagramIcon from '@material-ui/icons/Instagram';
import TwitterIcon from '@material-ui/icons/Twitter';
import LinkedInIcon from '@material-ui/icons/LinkedIn';
import GitHubIcon from '@material-ui/icons/GitHub';
import { makeStyles } from '@material-ui/core/styles';
import Alert from '@material-ui/lab/Alert';
import IconButton from '@material-ui/core/IconButton';
import Collapse from '@material-ui/core/Collapse';
import Button from '@material-ui/core/Button';
import CloseIcon from '@material-ui/icons/Close';

const useStyles = makeStyles((theme) => ({
  root: {
    width: '100%',
    '& > * + *': {
      marginTop: theme.spacing(2),
    },
  },
}));

export default function Footer () {

  const classes = useStyles();
  const [open, setOpen] = React.useState(false);

    return (

      <div>
        <footer class="bg-dark text-center text-white">
          <div class="container p-4">
            <section class="mb-4">
              <a class="btn btn-outline-light btn-floating m-1" href="https://www.facebook.com/Capgemini/" role="button"
              ><FacebookIcon></FacebookIcon></a>
              <a class="btn btn-outline-light btn-floating m-1" href="https://twitter.com/Capgemini?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor" role="button">
              <TwitterIcon></TwitterIcon></a>
              <a class="btn btn-outline-light btn-floating m-1" href="https://www.instagram.com/capgeminiindia/" role="button">
              <InstagramIcon></InstagramIcon></a>
              <a class="btn btn-outline-light btn-floating m-1" href="https://www.linkedin.com/company/capgemini" role="button"> 
              <LinkedInIcon></LinkedInIcon></a>
              <a class="btn btn-outline-light btn-floating m-1" href="https://github.com/AnkitaSagar/OnlineCourierManagementApp" role="button">
              <GitHubIcon></GitHubIcon></a>
            </section>
            <section class="">
              <form action="">
                <div class="row d-flex justify-content-center">
                  <div class="col-auto">
                    <p class="pt-2">
                      <strong>Sign up for our newsletter: </strong>
                    </p>
                  </div>
                  <div class="col-md-5 col-12">
                    <div class="form-outline form-white mb-4">
                      <input type="email" placeholder="Email Address" id="form5Example2" class="form-control" />
                      {/* <label class="form-label" for="form5Example2">Email address</label> */}
                    </div>
                  </div>
                  <div class="col-auto">
                  <Collapse in={open}>
                      <Alert
                        action={
                          <IconButton
                            aria-label="close"
                            color="inherit"
                            size="small"
                            onClick={() => {
                              setOpen(false);
                            }}
                          >
                            <CloseIcon fontSize="inherit" />
                          </IconButton>
                        }
                      >
                        You have subscribed to our email chain! Thank you for your patronage.
                      </Alert>
                    </Collapse><br></br>
                    <button disabled={open} onClick={() => {
                        setOpen(true);
                      }} type="submit" class="btn btn-outline-light mb-4">
                      Subscribe
                     </button>
                  </div>
                </div>
              </form>
            </section>
            <section class="mb-4">
              <p>
              These Terms and Conditions constitute a legally binding agreement made between you, whether personally or on behalf of an entity (“you”) and [OnlineCourierManagement] (“we,” “us” or “our”), concerning your access to and use of the [onlinecouriermanagement.com] website as well as any other media form, media channel, mobile website or mobile application related, linked, or otherwise connected thereto (collectively, the “Site”).
              </p>
            </section>
          </div>
          <div class="text-center p-3">
            © 2021 Copyright: 
            <a class="text-white" href="/">OnlineCourierManagement</a>
          </div>
        </footer>
      </div>
    );
}