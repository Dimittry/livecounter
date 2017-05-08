import React from 'react';
import {Switch} from 'react-router';
import {Route} from 'react-router-dom';

import { Button } from 'react-bootstrap';
import Navigation from './Navigation.jsx';
import HomePage from './HomePage.jsx';



export default class App extends React.Component {

    render() {
        return (
            <div>
                <Navigation />
                <div className="container-fluid">
                    <div className="row">
                        <Switch>
                            <Route exact path="/" component={HomePage}/>
                        </Switch>
                    </div>
                </div>
            </div>

        );
    }
}