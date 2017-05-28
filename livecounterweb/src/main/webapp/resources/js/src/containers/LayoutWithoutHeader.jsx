var React = require('react');
var ReactRouter = require('react-router-dom');
var Route = ReactRouter.Route;

import Navigation from '../components/Navigation.jsx';


const LayoutWithoutHeader = ({component: Component, ...rest}) => {
    return (
        <Route {...rest} render={matchProps => (
            <div className="DefaultLayout">
                <Component {...matchProps} />
            </div>
        )} />
    )
};

module.exports = LayoutWithoutHeader;
