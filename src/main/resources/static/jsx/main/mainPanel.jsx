import React from 'react';

class MainPanel extends React.Component {
  constructor(props) {
    super(props);
    this.state = props;
  }

  render() {
    const text = "hhhhhhh";
    console.log(this.state);
    return (
      <div className="testDiv">{this.state.Mytext}</div>
    );
  }
}

export default MainPanel;
