var React = require('react');
var Auth = require('../utils/Auth');
var ReactRouter = require('react-router');
var Redirect = ReactRouter.Redirect;

export default class Login extends React.Component {
    constructor(props) {
        super();
        this.state = {
            error : false,
            message : '',
            fireRedirect : false,
            pathToRedirect : '/'
        };
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        console.log(this.refs.email.value);
        console.log(this.refs.password.value);
        Auth.login(
            this.refs.email.value,
            this.refs.password.value,
            (isLoggedIn) => {
                console.log("login step 1");

                if(!isLoggedIn) {
                    return this.setState({error : true, message : "Wrong data 1"});
                }
                console.log("login step 2");

                const { from } = this.props.location.state || { from: { pathname: '/' } }
                console.log("login step 3");
                console.log(from);
                return this.setState({pathToRedirect : from, fireRedirect : true});
            }
        );
    }

    render() {
        return (
            <div className="container">
                <form className="form-signin" onSubmit={this.handleSubmit}>
                    <h2 className="form-signin-heading">Please sign in</h2>
                    <label htmlFor="inputEmail" className="sr-only">Email address</label>
                    <input ref='email' type="email" id="inputEmail" className="form-control" placeholder="Email address" required="" autoFocus=""/>
                    <label htmlFor="inputPassword" className="sr-only">Password</label>
                    <input ref='password' type="password" id="inputPassword" className="form-control" placeholder="Password" required=""/>
                    <div className="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me"/> Remember me
                        </label>
                    </div>
                    <button className="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                    {this.state.error && (
                        <p>{this.state.message}</p>
                    )}
                </form>
                {this.state.fireRedirect && (
                    <Redirect to="/"/>
                )}
            </div>

        )
    }
}