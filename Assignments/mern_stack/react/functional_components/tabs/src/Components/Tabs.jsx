import React, { useState } from 'react';

const Tabs = props =>{

    const onClick = (e, item) => {
        // console.log('Hehehehe');
        props.responseToClick(item);
    }

    return props._array.map( (item,index) => {
        return  <div key={index} className={ props.selected ===  item ?  "col-md-1 border mr-2 text-center bg-dark text-light":"col-md-1 border mr-2 text-center"} onClick={ (e) => onClick(e, item) } > { item }</div>
    });
    
}
export default Tabs;