import {PropTypes, findDOMNode} from 'react';
import {connect} from 'react-redux';
import {addTodo, completeTodo, setVisibilityFilter, VisibilityFilters} from './todo.action.jsx';
class AddTodo extends React.Component {
  render() {
    return (< div > < input type = 'text' ref = 'input' / > < button onClick = {
      e => this.handleClick(e)
    } > Add < /button> <
      /div >);
  }

  handleClick(e) {
    const text = this.refs.input.value.trim();
    this.props.onAddClick(text);
    this.refs.input.value = '';
  }
}

class Todo extends React.Component {
  render() {
    return (
      <li onClick={this.props.onClick} style={{
        textDecoration: this.props.completed
          ? 'line-through'
          : 'none',
        cursor: this.props.completed
          ? 'default'
          : 'pointer'
      }}>
        {this.props.text}
      </li>
    );
  }
}

class TodoList extends React.Component {
  render() {
    return (
      <ul>
        {this.props.todos.map((todo, index) => <Todo {...todo} key={index} onClick={() => this.props.onTodoClick(index)}/>)}
      </ul>
    )
  }
}
class Footer extends React.Component {
  renderFilter(filter, name) {
    if (filter === this.props.filter) {
      return name;
    }

    return (
      <a href='#' onClick={e => {
        e.preventDefault();
        this.props.onFilterChange(filter);
      }}>
        {name}
      </a>
    )
  }

  render() {
    return (
      <p>
        Show: {' '}
        {this.renderFilter('SHOW_ALL', 'All')}
        {', '}
        {this.renderFilter('SHOW_COMPLETED', 'Completed')}
        {', '}
        {this.renderFilter('SHOW_ACTIVE', 'Active')}
        .
      </p>
    );
  }
}

export class App extends React.Component {
  render() {
    const {dispatch, visibleTodos, visibilityFilter} = this.props;
    return (
      <div>
        <AddTodo onAddClick={text => dispatch(addTodo(text))}/>
        <TodoList todos={this.props.visibleTodos} onTodoClick={index => dispatch(completeTodo(index))}/>
        <Footer filter='visibilityFilter' onFilterChange={nextFilter => dispatch(setVisibilityFilter(nextFilter))}/>
      </div>
    );
  }
}
function selectTodos(todos, filter) {
  switch (filter) {
    case VisibilityFilters.SHOW_ALL:
      return todos;
    case VisibilityFilters.SHOW_COMPLETED:
      return todos.filter(todo => todo.completed);
    case VisibilityFilters.SHOW_ACTIVE:
      return todos.filter(todo => !todo.completed);
  }
}

// 基于全局 state ，哪些是我们想注入的 props ?
// 注意：使用 https://github.com/reactjs/reselect 效果更佳。
function select(state) {
  return {
    visibleTodos: selectTodos(state.todos, state.visibilityFilter),
    visibilityFilter: state.visibilityFilter
  };
}

// 包装 component ，注入 dispatch 和 state 到其默认的 connect(select)(App) 中；
export default connect(select)(App);

Footer.propTypes = {
  onFilterChange: PropTypes.func.isRequired,
  filter: PropTypes.oneOf(['SHOW_ALL', 'SHOW_COMPLETED', 'SHOW_ACTIVE']).isRequired
};
AddTodo.propTypes = {
  onAddClick: PropTypes.func.isRequired
}
Todo.propTypes = {
  onClick: PropTypes.func.isRequired,
  text: PropTypes.string.isRequired,
  completed: PropTypes.bool.isRequired
};

TodoList.propTypes = {
  onTodoClick: PropTypes.func.isRequired,
  todos: PropTypes.arrayOf(PropTypes.shape({text: PropTypes.string.isRequired, completed: PropTypes.bool.isRequired}).isRequired).isRequired
}
