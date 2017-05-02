import React from 'react';
import MyLineChart from './MyLineChart.jsx';

export default class MainView extends React.Component{
    render() {
        return (
            <div className="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <h1 className="page-header">Dashboard</h1>
                <div>
                    {/*<canvas id="myChart" width="400" height="200"></canvas>*/}
                    <MyLineChart/>
                    <h1 className="clr">this is an index.</h1>
                    <h2>test</h2>


                    <input type="button" className="button" value="Logout" onclick="document.getElementById('logoutForm').submit();"/>
                    <div id="root"></div>

                </div>
            </div>
        );
    }
}