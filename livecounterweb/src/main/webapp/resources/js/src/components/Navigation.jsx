var React = require('react');

var ReactRouter = require('react-router-dom');
var Link = ReactRouter.Link;
var Auth = require('../utils/Auth');
export default class Navigation extends React.Component {
    render() {
        return (
            <nav className="navbar navbar-inverse navbar-fixed-top">
                <div className="container-fluid">
                    <div className="navbar-header">
                        <button type="button" className="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span className="sr-only">Toggle navigation</span>
                            <span className="icon-bar"></span>
                            <span className="icon-bar"></span>
                            <span className="icon-bar"></span>
                        </button>
                        <Link to="/" className="navbar-brand" >Live Counter</Link>
                    </div>
                    <div id="navbar" className="navbar-collapse collapse">
                        <ul className="nav navbar-nav navbar-right">
                            <li><a href="#">Dashboard</a></li>
                            <li><a href="/">Settings</a></li>
                            <li><Link to="/profile">Profile</Link></li>
                            {Auth.isLoggedIn() && (
                                <li><Link to="/" onClick={Auth.logout}>Logout</Link></li>
                            )}
                        </ul>
                        <form className="navbar-form navbar-right">
                            <input type="text" className="form-control" placeholder="Search..."/>
                        </form>
                    </div>
                </div>
            </nav>
        );
    }
}