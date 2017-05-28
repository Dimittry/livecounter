import React from 'react'
import {
    Route,
    Link,
    Redirect,
    withRouter
} from 'react-router-dom'

var Auth = require("../utils/Auth");

const PrivateRoute = ({component : Component, ...rest}) => {
    console.log('PrivateRoute step 1');
    return (<Route {...rest} render={props => (
        Auth.isLoggedIn() ? (
            <Component {...props}/>
        ) : (
            <Redirect to={{
                pathname: "/login",
                state: {from: props.location}
            }}/>
        )
    )}/>)
}

module.exports = PrivateRoute;
