import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';

const Films = props => {
    return (
        <div>
            <h1 className="my-5">{props.information.title} </h1>
            <p><strong>Director:</strong> {props.information.director}</p>
            <p><strong>Producer:</strong> {props.information.producer}</p>
            <p><strong>Release Date:</strong> {props.information.release_date} </p>
            <p><strong>Opening Paragraph:</strong> {props.information.opening_crawl}</p>
        </div>
    );
}

export default Films;