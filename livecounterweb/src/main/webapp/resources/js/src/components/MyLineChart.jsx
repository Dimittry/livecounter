import React from 'react';
import axios from 'axios';
// var LineChart = require("react-chartjs").Line;
require("chart.js");

export default class MyLineChart extends React.Component {
    constructor(props) {
        super(props);
        this.state = {chart: {}};
    }

    componentDidMount() {
        // var  ctx = document.getElementById("myChart");
        let chartCanvas = this.refs.chart;

        axios.get('http://localhost:8080/tests')
            .then(res => {
                console.log(res);
                // const posts = res.data.data.children.map(obj => obj.data);
                // this.setState({ posts });
                let type = 5;
                let datasets = [];
                let labels = [];
                res.data.map(source => {
                    let dataset = {
                        'label' : source.checkName,
                        'data' : source.sourceData.filter(elem => (elem.type == type)).map(elem => elem.value)
                    };
                    datasets.push(dataset);
                    if(labels.length === 0) {
                        labels = source.sourceData.filter(elem => (elem.type == type)).map(elem => {
                            console.log(elem);
                            return elem.day.dayOfMonth + " " + elem.day.monthValue;
                        });
                    }
                });
                console.log(datasets);
                console.log(labels);
                var myChart = new Chart(chartCanvas, {
                    type: 'line',
                    data: {
                        labels: labels,
                        datasets: datasets
                            // [
                        // {
                        //     label: 'apples',
                        //     data: [12, 19, 3, 17, 6, 3, 7],
                        //     backgroundColor: "rgba(153,255,51,0.4)"
                        // }, {
                        //     label: 'oranges',
                        //     data: [2, 29, 5, 5, 2, 3, 10],
                        //     backgroundColor: "rgba(255,153,0,0.4)"
                        // }
                        // ]
                    }
                });
                this.setState({chart: myChart});
            });


    }

    render() {
        return <canvas ref={'chart'} height={'400'} width={'600'}></canvas>
    }
}