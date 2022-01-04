import { combineReducers } from 'redux';
import citaReducer from './citaReducer';

const reducer = combineReducers({
  cita: citaReducer
});

export default reducer;
