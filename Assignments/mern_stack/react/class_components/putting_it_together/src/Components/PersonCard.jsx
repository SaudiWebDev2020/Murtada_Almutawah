/* jshint esversion: 6 */

import React, { Component } from 'react';

class PersonCard extends Component {
    constructor(props) {
        super(props);
        this.state = {
            firstName: props.firstName,
            lastName: props.lastName,
            age: props.age,
            hairColor: props.hairColor,
        };
    }
    birthday = () => {
        // console.log(this.state);
        this.setState({ age: this.state.age + 1 });
    }
    render() {
        return (
            <div>
                <h1> {this.state.lastName}, {this.state.firstName}</h1>
                <p>Age: {this.state.age} </p>
                <p>Hair Color: {this.state.hairColor} </p>
                <button onClick={this.birthday}>Birthday button for {this.state.firstName} {this.state.lastName} </button>
            </div>
        );
    }
}
export default PersonCard;