import React from 'react'

const Boxes = props => {
    console.log('List',props.boxesList);

    return(
        <>
            { props.boxesList.map((color,index) => {
                return <div className="m-2 box" style={{backgroundColor:color}}> {index}</div>;
            })}
        </>
    );
};

export default Boxes