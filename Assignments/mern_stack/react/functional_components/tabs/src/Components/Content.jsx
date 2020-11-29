import React, { useState } from 'react';

const Content = props =>{

    return(
        <div className="border w-100 p-2"> {props.currentValue} content is showing here.</div>
    );
}
export default Content;