
const ReadInput = props => {

    return (
        <>
        { isNaN(`${props.inp}`) ? 
        <h1 className='centered'> The word is: {props.inp}</h1>
        :
        <h1 className='centered'> The number is: {props.inp}</h1>
        }
        </>
    );
}

export default ReadInput;