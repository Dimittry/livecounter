var React = require('react');
var ReactRouter = require('react-router-dom');
var Route = ReactRouter.Route;

import Navigation from './Navigation.jsx';


const Layout = ({component: Component, ...rest}) => {
    return (
        <Route {...rest} render={matchProps => (
            <div className="DefaultLayout">
                <Navigation/>
                <Component {...matchProps} />
            </div>
        )} />
    )
};

module.exports = Layout;
