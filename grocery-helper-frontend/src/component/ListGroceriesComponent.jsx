import React, { Component } from 'react'
import GroceryDataService from '../service/GroceryDataService';

const CATEGORY = 'Beverages'

/** This class responsible to list all items/delete/create/update item based on user action */
class ListGroceriesComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            groceries: [],
            message: null
        }
        this.deleteGroceryClicked = this.deleteGroceryClicked.bind(this)
        this.updateGroceryClicked = this.updateGroceryClicked.bind(this)
        this.addGroceryClicked = this.addGroceryClicked.bind(this)
        this.refreshGroceries = this.refreshGroceries.bind(this)
    }

    componentDidMount() {
        this.refreshGroceries();
    }

    refreshGroceries() {
        GroceryDataService.retrieveAllGroceries(CATEGORY)//HARDCODED
            .then(
                response => {
                    //console.log(response);
                    this.setState({ groceries: response.data })
                }
            )
    }

    deleteGroceryClicked(id) {
        GroceryDataService.deleteGrocery(CATEGORY, id)
            .then(
                response => {
                    this.setState({ message: `Delete of grocery ${id} Successful` })
                    this.refreshGroceries()
                }
            )

    }

    addGroceryClicked() {
        this.props.history.push(`/groceries/-1`)
    }

    updateGroceryClicked(id) {
        console.log('update ' + id)
        this.props.history.push(`/groceries/${id}`)
    }

    render() {
        console.log('render')
        return (
            <div className="container">
                <h3>All Groceries</h3>
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Grocery Id</th>
                                <th>Grocery Category</th>
                                <th>Grocery Description</th>
                                <th>Update Grocery Item</th>
                                <th>Delete Grocery Item</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.groceries.map(
                                    grocery =>
                                        <tr key={grocery.id}>
                                            <td>{grocery.id}</td>
                                            <td>{grocery.category}</td>
                                            <td>{grocery.description}</td>
                                            <td><button className="btn btn-success" onClick={() => this.updateGroceryClicked(grocery.id)}>Update</button></td>
                                            <td><button className="btn btn-warning" onClick={() => this.deleteGroceryClicked(grocery.id)}>Delete</button></td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                    <div className="row">
                        <button className="btn btn-success" onClick={this.addGroceryClicked}>Add</button>
                    </div>
                </div>
            </div>
        )
    }
}

export default ListGroceriesComponent