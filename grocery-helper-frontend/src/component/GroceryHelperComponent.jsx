import React, { Component } from 'react'
import { Formik, Form, Field, ErrorMessage } from 'formik';
import GroceryDataService from '../service/GroceryDataService';

const CATEGORY = 'Beverages'

/** Helper component which is responsible to retrieve grocery item(s) based on actions from user. */
class GroceryHelperComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            description: ''
        }

        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)

    }

    componentDidMount() {

        console.log(this.state.id)

        // eslint-disable-next-line
        if (this.state.id == -1) {
            return
        }

        GroceryDataService.retrieveGrocery(CATEGORY, this.state.id,)
            .then(response => this.setState({
                description: response.data.description
            }))
    }

    validate(values) {
        let errors = {}
        if (!values.description) {
            errors.description = 'Enter a Description'
        } else if (values.description.length < 5) {
            errors.description = 'Enter atleast 5 Characters in Description'
        }

        return errors

    }

    onSubmit(values) {
        let categoryname = CATEGORY

        let grocery = {
            id: this.state.id,
            category: values.category,
            description: values.description,
            targetDate: values.targetDate
        }

        if (this.state.id == "-1") {
            GroceryDataService.createGrocery(categoryname, grocery)
                .then(() => this.props.history.push('/groceries'))
        } else {
            GroceryDataService.updateGrocery(categoryname, this.state.id, grocery)
                .then(() => this.props.history.push('/groceries'))
        }

        console.log(values);
    }

    render() {

        let { description, category, id } = this.state

        return (
            <div>
                <h3>Grocery</h3>
                <div className="container">
                    <Formik
                        initialValues={{ id, category, description }}
                        onSubmit={this.onSubmit}
                        validateOnChange={false}
                        validateOnBlur={false}
                        validate={this.validate}
                        enableReinitialize={true}
                    >
                        {
                            (props) => (
                                <Form>
                                    <ErrorMessage name="description" component="div"
                                        className="alert alert-warning" />
                                    <fieldset className="form-group">
                                        <label>Id</label>
                                        <Field className="form-control" type="text" name="id" disabled />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Category</label>
                                        <Field className="form-control" type="text" name="category" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Description</label>
                                        <Field className="form-control" type="text" name="description" />
                                    </fieldset>
                                    <button className="btn btn-success" type="submit">Save</button>
                                </Form>
                            )
                        }
                    </Formik>

                </div>
            </div>
        )
    }
}

export default GroceryHelperComponent