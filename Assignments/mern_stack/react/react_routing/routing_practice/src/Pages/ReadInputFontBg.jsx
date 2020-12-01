
const ReadInputFontBg = props => {

    return (
        <>
        { isNaN(`${props.inp}`) ? 
        <h1 className='centered' style={{color: props.fontColor, backgroundColor: props.bgColor}}> The word is: {props.inp}</h1>
        :
        <h1 className='centered' style={{color: props.fontColor, backgroundColor: props.bgColor}} > The number is: {props.inp}</h1>
        }
        </>
    );
}

export default ReadInputFontBg;