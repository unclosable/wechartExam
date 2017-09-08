var path = require('path');

module.exports = {
    path: path.resolve(__dirname, "../") + "/src/main/resources/static/js/build/",
    filename: 'js/[name].js',
    chunkFilename: "[id].[hash].bundle.js",
    publicPath: "http://this.com:3000/"
};
