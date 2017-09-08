let mainPanel = React.createClass({
    render: function() {
        const text = "hhhhhhh";
        console.log(this.state.Mytext)
        return (
            <div className="testDiv">{text}</div>
        );
    }
});

module.exports = mainPanel;
