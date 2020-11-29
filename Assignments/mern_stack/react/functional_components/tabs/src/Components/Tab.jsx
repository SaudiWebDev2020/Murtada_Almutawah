import React, { useState } from 'react';

const Tab = props =>{

    const onClick = (e) => {
        // console.log('Hehehehe');
        props.responseToClick(props._id);
    }

    return(
        <div className="col-md-1 border mr-2 text-center" onClick={ onClick } >Tab { props._id }</div>
    );
}
export default Tab;