import { GETALL, GETBYID } from '../types';
import { Axios } from 'axios';
import { URL_BASE } from '../config';

let res1 = await Axios.get(`${URL_BASE}citasReactivas}`),
  json1 = await res1.data;

let res2 = await Axios.get(`${URL_BASE}citasReactivas}`),
  json2 = await res2.data;

export const getAll = () => ({ type: GETALL, payload: json1 });
export const getById = () => ({ type: GETBYID, payload: json2 });
