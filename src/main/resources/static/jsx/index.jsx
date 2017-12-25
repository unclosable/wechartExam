import MainPanel from './main/mainPanel.jsx';
import MainMenu from './menu/main.jsx';
import TestTable from './baseComponent/testTable.jsx';
import Route from 'react-router-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import TodoApp from './test/todo2.jsx';
import {createStore} from 'redux';
import todoApp from './test/todo.reducer.jsx';
import {Provider} from 'react-redux';

let store = createStore(todoApp)

const initFunc = function() {

  ReactDOM.render(
    <Provider store={store}>
    <MainPanel menu={< TodoApp />}/>
  </Provider>, document.body);
}

export default initFunc;
