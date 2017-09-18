import MainPanel from './main/mainPanel.jsx';
import MainMenu from './menu/main.jsx';
import TestTable from './baseComponent/testTable.jsx';
import Route from 'react-router-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';

const initFunc = function() {

  ReactDOM.render(
    <MainPanel menu={< MainMenu />}/>, document.body);
}

export default initFunc;
