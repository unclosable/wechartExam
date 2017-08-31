var path = require('path');
var node_modules_dir = path.join(__dirname, 'node_modules');
var argv = require('yargs').argv;

// var baseList = [ 'jquery', 'bootstrap/dist/css/bootstrap.min.css',
// 'bootstrap/dist/js/bootstrap.min.js' ];
var baseList = [];

var isLocalTest = argv.env.action === 'localTest' ? true : false;

var entry = isLocalTest ? require('./webpack-configuration/entry.localtest.js') : require('./webpack-configuration/entry.js');

for (key in entry) {
	if (entry[key] instanceof Array) {
		entry[key] = baseList.concat(entry[key]);
	} else {
		entry[key] = baseList.concat([ entry[key] ]);
	}
}

var outPut = isLocalTest ? require('./webpack-configuration/outputer.localtest.js') : require('./webpack-configuration/outputer.build.js');

var loaders = require('./webpack-configuration/loaders.js');

var plugins = isLocalTest ? require('./webpack-configuration/plugins.localtest.js') : require('./webpack-configuration/plugins.build.js');

var devServer = isLocalTest ? require('./webpack-configuration/devServer.js') : {};

module.exports = {
	entry : entry,
	output : outPut,
	module : {
		loaders : loaders
	},
	plugins : plugins,
	devServer : devServer
};
