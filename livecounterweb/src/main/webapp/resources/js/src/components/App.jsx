import React from 'react';
import { Button } from 'react-bootstrap';
import Navigation from './Navigation.jsx';
import Sidebar from './Sidebar.jsx';
import MainView from './MainView.jsx';


export default class App extends React.Component {

    render() {
        return (
            <div>
                <Navigation />
                <div className="container-fluid">
                    <div className="row">
                        <Sidebar />
                        <MainView />
                    </div>
                </div>
            </div>

        );
    }
}