var path = require('path');
var ExtractTextPlugin = require("extract-text-webpack-plugin");
var webpack = require("webpack");
module.exports = {
    entry : path.join(__dirname, 'src/main/webapp/resources/js/main'),
    output: {
        path: path.join(__dirname, 'src/main/webapp/resources/vendor/js'),
        filename: 'bundle.js'
    },
    module: {
        loaders: [
            {
                test: /\.(js|jsx)$/,
                loader: 'babel-loader',
                exclude: /node_modules/,
                query : {
                    presets : ['react', 'es2015']
                }
            },
            {
                test: /\.css$/,
                // exclude: /node_modules/,
                // loaders: ['style-loader', 'css-loader']
                use: ExtractTextPlugin.extract({
                    fallback: "style-loader",
                    use: "css-loader"
                })
            },
            {
                test: /\.(ttf|eot|svg|woff(2)?)(\?[a-z0-9]+)?$/,
                loader: 'file-loader',
            }
        ]
    },
    plugins: [
        new ExtractTextPlugin("../css/style1.css"),
        new webpack.ProvidePlugin({
            $: "jquery",
            jQuery: "jquery"
        })
    ]
}