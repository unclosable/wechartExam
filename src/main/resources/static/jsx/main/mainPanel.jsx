import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import MyAwesomeReactComponent from '../baseComponent/testComponent.jsx';

const App = () => (
  <MuiThemeProvider>
    <MyAwesomeReactComponent/>
  </MuiThemeProvider>
);

export default App;
