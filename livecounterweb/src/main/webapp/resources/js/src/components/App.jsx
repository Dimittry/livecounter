import React from 'react';

import { Button } from 'react-bootstrap';
import HomePage from './HomePage.jsx';
import Profile from './Profile.jsx';
import Login from './Login.jsx';

var Layout = require('./Layout.jsx');
var LayoutWithoutHeader = require('./LayoutWithoutHeader.jsx');
var ReactRouter = require('react-router-dom');
var Router = ReactRouter.BrowserRouter;
var Switch = ReactRouter.Switch;

export default class App extends React.Component {

    render() {
        return (
            <Router>
                <Switch>
                    <Layout exact path="/" component={HomePage}/>
                    <Layout path="/profile" component={Profile}/>
                    <LayoutWithoutHeader path="/login" component={Login}/>
                </Switch>
            </Router>
        );
    }
}