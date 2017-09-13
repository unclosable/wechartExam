import MainPanel from './main/mainPanel.jsx';
import MainMenu from './menu/main.jsx';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import {
  BrowserRouter as Router,
  Route,
  Link
} from 'react-router-dom'


const initFunc = function() {
//   const BasicExample = () => (
//   <Router>
//     <div>
//       <ul>
//         <li><Link to="/">Home</Link></li>
//         <li><Link to="/about">About</Link></li>
//         <li><Link to="/topics">Topics</Link></li>
//       </ul>
//
//       <hr/>
//
//       <Route exact path="/" component={MainPanel}/>
//       <Route path="/about" component={MainPanel}/>
//       <Route path="/topics" component={MainPanel}/>
//     </div>
//   </Router>
// )

const App = () => (
  <MuiThemeProvider>
    <MainMenu/> 
  </MuiThemeProvider>
);
  ReactDOM.render(
    <App/>, document.getElementById('teststtststsPanel'));
}

export default initFunc;
