import React from 'react';
import Sidebar from './Sidebar.jsx';
import MainView from './MainView.jsx';

var Auth = require("../utils/Auth");
console.log('Auth');
console.log(Auth);


export default class HomePage extends React.Component {

    componentDidMount() {
        console.log("DID MOUNT");
        console.log(Auth.getUserAuthInfo());
        console.log(Auth.isLoggedIn());
    }

    render() {
        const menuItems = {
            "viewsPerDay" : {
                title : "Просмотров за день",
                link : "/views"
            },
            "visitorsPerDay" : {
                title : "Посетителей за день",
                link : "/visitors"
            }
        };
        return (<div>
            <Sidebar menuItems={menuItems} />
            <MainView />
        </div>);
    }
}
