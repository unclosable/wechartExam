var HtmlWebpackPlugin = require('html-webpack-plugin');
var CleanWebpackPlugin = require('clean-webpack-plugin');
var webpack = require('webpack');
var path = require('path');
// var chunksSortFunc = function(chunk1, chunk2) {
// re = chunk1.names[0] == 'base' ? -1 : chunk2.names[0] == 'base' ? 1 : 0;
// return re;
// }

module.exports = [new HtmlWebpackPlugin({
  chunks: ['index', ],
  xhtml: false,
  inject: true,
  template: path.resolve(__dirname, "../") + "/src/main/resources/static/temp/index.html",
  filename: path.resolve(__dirname, "../") + "/src/main/resources/templates/index.html",
}), new webpack.DefinePlugin({
  'process.env': {
    NODE_ENV: JSON.stringify('production')
  }
}), new webpack.optimize.UglifyJsPlugin({
  compress: {
    warnings: false
  }
}), new webpack.HotModuleReplacementPlugin(), new webpack.ProvidePlugin({
  React: "react",
  ReactDOM: "react-dom"
})];
