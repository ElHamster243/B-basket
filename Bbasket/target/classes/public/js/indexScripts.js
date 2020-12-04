

function acceso(){
    import axios from 'axios';

const BASE_URL = '/acceso';

const getTodos = async () => {
  try {
    const res = await axios.get(${BASE_URL});

    const todos = res.data;

    console.log(`GET: Here's the list of todos`, todos);

    return todos;
  } catch (e) {
    console.error(e);
  }
};

}