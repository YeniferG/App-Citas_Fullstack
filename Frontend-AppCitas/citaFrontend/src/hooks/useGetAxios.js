import { useEffect, useState } from 'react';
import axios from 'axios';
import { URL_BASE } from '../config';

export const useGetAxios = (url) => {
  const [data, setData] = useState([]);
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    const get = async () => {
      try {
        let res = await axios.get(`${URL_BASE}${url}`),
          json = await res.data;
        setData(json);
      } catch (error) {
        setError(error);
      } finally {
        setLoading(false);
      }
    };

    get();
  }, [url]);

  return { data, error, loading };
};
