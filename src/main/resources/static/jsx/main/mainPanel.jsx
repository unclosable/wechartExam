import {BrowserRouter as Router, Route} from 'react-router-dom'
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import TestTable from '../baseComponent/testTable.jsx';
/**
定义整个框架
*/
class App extends React.Component {
  constructor(props) {
    super();
    this.state = {
      menu: props.menu,
      themain: props.themain
    }
  }
  render() {
    return (
      <Router>
        <div id="mainDIV">
          <div id="menuDIV" className="left">
            <MuiThemeProvider>
              {this.state.menu}
            </MuiThemeProvider>
          </div>
          <div id="contentDIV" className="rigth">
            <MuiThemeProvider>
              <Route path="/table" component={TestTable}/>
            </MuiThemeProvider>
          </div>
        </div>
      </Router>
    );
  }
}

export default App;
