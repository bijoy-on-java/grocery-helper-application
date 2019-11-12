import React, { Component } from 'react';
import ListGroceriesComponent from './ListGroceriesComponent';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import GroceryHelperComponent from './GroceryHelperComponent';

/** Grocery Helper App contains router information for listing groceries or fetching groceries based on id etc. */
class GroceryHelperApp extends Component {
    render() {
        return (
            <Router>
                <>
                    <h1>Grocery Helper Application</h1>
                    <Switch>
                        <Route path="/" exact component={ListGroceriesComponent} />
                        <Route path="/groceries" exact component={ListGroceriesComponent} />
                        <Route path="/groceries/:id" component={GroceryHelperComponent} />
                    </Switch>
                </>
            </Router>
        )
    }
}

export default GroceryHelperApp