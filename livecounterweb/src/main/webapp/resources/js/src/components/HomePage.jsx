import React from 'react';
import Sidebar from './Sidebar.jsx';
import MainView from './MainView.jsx';

export default class HomePage extends React.Component {
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
