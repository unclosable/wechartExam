module.exports = [ // 加载器
    {
        test: /\.js$/,
        loader: "babel-loader",
        query: {
            // 兼容ES2015
            presets: ['es2015']
        }
    }, {
        test: /\.html$/,
        loader: 'ejs-loader',
        query: {
            // 改写了HTML的加载器，在HTML中用到WEBPACK的模版请使用{{((the value))}}
            interpolate: /{{\(\(([\s\S]+?)\)\)}}/g,
        }
    }, {
        test: /\.(css)$/,
        loader: 'style-loader!css-loader'
    }, {
        test: /\.(woff|woff2)(\?v=\d+\.\d+\.\d+)?$/,
        loader: 'url-loader?limit=10000&mimetype=application/font-woff'
    }, {
        test: /\.ttf(\?v=\d+\.\d+\.\d+)?$/,
        loader: 'url-loader?limit=10000&mimetype=application/octet-stream'
    }, {
        test: /\.eot(\?v=\d+\.\d+\.\d+)?$/,
        loader: 'file-loader'
    }, {
        test: /\.svg(\?v=\d+\.\d+\.\d+)?$/,
        loader: "url-loader?limit=10000&mimetype=image/svg+xml"
    }, {
        test: /\.less$/,
        loader: "style-loader!css-loader!less-loader"
    }
];
