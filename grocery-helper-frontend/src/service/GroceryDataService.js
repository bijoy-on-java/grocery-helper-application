import axios from 'axios'

const GROCERY_API_URL = 'http://localhost:9000'
const CATEGORY_API_URL_ALL = `${GROCERY_API_URL}/grocery-helpers/groceries`

/** Service class provide mechanism to retrieve all groceries or delete/create/update grocery item(s) based on user action */
class GroceryDataService {

    retrieveAllGroceries(name) {
        //console.log('executed service')
        return axios.get(`${CATEGORY_API_URL_ALL}`);
    }

    retrieveGrocery(name, id, category) {
        return axios.get(`${GROCERY_API_URL}/grocery-helpers/grocery/${id}`, category);
    }

    deleteGrocery(name, id) {
        //console.log('executed service')
        return axios.delete(`${GROCERY_API_URL}/grocery-helpers/groceries/${id}/delete`);
    }

    updateGrocery(name, id, grocery) {
        //console.log('executed service')
        return axios.put(`${GROCERY_API_URL}/grocery-helpers/groceries/${id}/update`, grocery);
    }

    createGrocery(name, grocery) {
        //console.log('executed service')
        return axios.post(`${GROCERY_API_URL}/grocery-helpers/grocery/create/`, grocery);
    }
}

export default new GroceryDataService()