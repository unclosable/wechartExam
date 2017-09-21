import MainPanel from './main/mainPanel.jsx';
import MainMenu from './menu/main.jsx';
import TestTable from './baseComponent/testTable.jsx';
import Route from 'react-router-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import TodoApp from './test/todo.jsx';

const initFunc = function() {

  ReactDOM.render(
    <MainPanel menu={< TodoApp />}/>, document.body);
}

export default initFunc;
