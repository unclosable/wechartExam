import MainPanel from './main/mainPanel.jsx';
import {
  BrowserRouter as Router,
  Route,
  Link
} from 'react-router-dom'


const initFunc = function() {
  const BasicExample = () => (
  <Router>
    <div>
      <ul>
        <li><Link to="/">Home</Link></li>
        <li><Link to="/about">About</Link></li>
        <li><Link to="/topics">Topics</Link></li>
      </ul>

      <hr/>

      <Route exact path="/" component={MainPanel}/>
      <Route path="/about" component={MainPanel}/>
      <Route path="/topics" component={MainPanel}/>
    </div>
  </Router>
)

  ReactDOM.render(
    <BasicExample />, document.getElementById('teststtststsPanel'));
}

export default initFunc;
