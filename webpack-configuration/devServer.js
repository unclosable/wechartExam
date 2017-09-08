module.exports = {
    port: 3000,
    host: "this.com",
    proxy: {
        '**': {
            target: 'http://this.com:10002',
            secure: false,
            prependPath: false
        }
    },
    publicPath: 'http://this.com:10002/',
    historyApiFallback: true,
    disableHostCheck: false
};
