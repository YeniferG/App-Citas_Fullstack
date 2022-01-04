import './App.css';
import { Provider } from 'react-redux';
import store from './store';
import { Container } from './components/Container';

function App() {
  return (
    <Provider store={store}>
      <Container />
    </Provider>
  );
}

export default App;
