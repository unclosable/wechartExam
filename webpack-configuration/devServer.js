module.exports = {
	port : 3000,
	proxy : {
		'**' : {
			target : 'http://localhost:10002',
			secure : false,
			prependPath : false
		}
	},
	publicPath : 'http://localhost:10002/',
	historyApiFallback : true
};