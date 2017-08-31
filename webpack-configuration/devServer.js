module.exports = {
	port : 3000,
	proxy : {
		'**' : {
			target : 'http://localhost:8202',
			secure : false,
			prependPath : false
		}
	},
	publicPath : 'http://localhost:3000/',
	historyApiFallback : true
};