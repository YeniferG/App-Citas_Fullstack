import { GETALL, GETBYID } from '../types';

export const citaInitialState = {
  citas: []
};

export default function citaReducer(state = citaInitialState, action) {
  switch (action.type) {
    case GETALL:
      console.log('redall', action.payload);
      return { ...state, citas: action.payload };
    case GETBYID:
      console.log('redbyid', action.payload);
      return { ...state, citas: action.payload };
    default:
      return state;
  }
}
