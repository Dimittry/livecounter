import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import App from './src/components/App.jsx';
// import routes from "./src/routers/routers";

require('../css/style.css');
require("bootstrap/dist/css/bootstrap.css")
require("jquery")
require("bootstrap/dist/js/bootstrap.min.js")

ReactDOM.render(
    <Router>
        <Route path="/" component={App}/>
    </Router>
    , document.getElementById('root'));
// ReactDOM.render(<App />, document.getElementById('root'));