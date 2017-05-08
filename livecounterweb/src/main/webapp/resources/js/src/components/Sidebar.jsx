import React from 'react';

export default class Sidebar extends React.Component {
    render() {
        const menuItems = this.props.menuItems || {};
        let menuHtml = Object.keys(menuItems).map((key) => {
            let item = menuItems[key];
            return <li><a href={item.link}>{item.title}</a></li>
        });
        return (
            <div className="col-sm-3 col-md-2 sidebar">
                <ul className="nav nav-sidebar">
                    {/*<li className="active"><a href="#">Overview <span className="sr-only">(current)</span></a></li>*/}
                    {menuHtml}
                </ul>
            </div>
        );
    }
}