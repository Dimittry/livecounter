import React from 'react';
import ReactDOM from 'react-dom';
import App from './src/components/App.jsx';

require('../css/style.css');
require("bootstrap/dist/css/bootstrap.css")
require("jquery")
require("bootstrap/dist/js/bootstrap.min.js")

ReactDOM.render(<App />, document.getElementById('root'));