let mainPanel = require('./main/mainPanel.jsx');

let initFunc = function() {
    console.log(mainPanel);
    ReactDOM.render(
        <mainPanel myText="12呃呃vvvvfffdddd呃1ffsdfs呃ddd吗3"/>, document.getElementById('teststtststsPanel'));
}

module.exports = initFunc;
