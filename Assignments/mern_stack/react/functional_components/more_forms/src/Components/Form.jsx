import React, { useState } from 'react';

import Bootstrap from 'bootstrap/dist/css/bootstrap.css';



const Form = props => {
    const [firstName, setFirstName] = useState('');
    const [firstNameError, setFirstNameError] = useState('');

    const [lastName, setLastName] = useState('');
    const [lastNameError, setLastNameError] = useState('');

    const [email, setEmail] = useState('');
    const [emailError, setEmailError] = useState('');


    const [password, setPassword] = useState('');
    const [passwordError, setPasswordError] = useState('');


    const [confirmPassword, setConfirmPassword] = useState('');
    const [confirmPasswordError, setConfirmPasswordError] = useState('');


    const handleFirstName = (e) => {
        setFirstName(e.target.value);

        if(e.target.value.length < 2){
            setFirstNameError('First Name must be at least 2 characters');
        } else{
            setFirstNameError('');
        }

    }
    const handleLastName = (e) => {
        setLastName(e.target.value);
        
        if(e.target.value.length<2){
            setLastNameError('Last Name must be at least 2 characters');
        } else{
            setLastNameError('');
        }
    }
    
    const handleEmail = (e) => {
        setEmail(e.target.value);

        if(e.target.value.length<5){
            setEmailError('Email must be at lease 5 characters');
        } else{
            setEmailError('');
        }
    }

    const handlePassword = (e) => {
        setPassword(e.target.value); 
        if(e.target.value.length<8){
            setPasswordError('Password must be at least 8 characters');
        } else{
            setPasswordError('');
        }
    
        if(e.target.value != confirmPassword){
            setConfirmPasswordError('Password must match');
        } else {
            setConfirmPasswordError('');
        }
    }

    const handleConfirmPassword = (e) => {
        setConfirmPassword(e.target.value);

        if(password != e.target.value){
            setConfirmPasswordError('Password must match');
        } else{
            setConfirmPasswordError('');
        }
    }
    

    return (
        <form className="text-center p-2">
            <div className="form-row">
                <div className="w-100">
                <label className="col-3" htmlFor="firstName">First Name</label>
                <input className="col-3" type="text" id="firstName" onChange={handleFirstName} value={firstName} />
                {
                    firstNameError ?
                        <p style={{ color: 'red' }}>{firstNameError}</p> : ''
                }
                </div>
            </div>
            <div className="form-row">
                <div className="w-100">
                <label className="col-3" htmlFor="lastName">Last Name</label>
                <input className="col-3" type="text" id="lastName" onChange={handleLastName} value={lastName} />
                {
                    lastNameError ?
                    <p style={{ color: 'red' }}>{lastNameError}</p> : ''
                }
                </div>
            </div>
            <div className="form-row">
            <div className="w-100">
                <label className="col-3" htmlFor="email">Email</label>
                <input className="col-3" type="email" id="email" onChange={handleEmail} value={email} />
                {
                    emailError ?
                    <p style={{ color: 'red' }}>{emailError}</p> : ''
                }
            </div>
            </div>
            <div className="form-row">
            <div className="w-100">
                <label className="col-3" htmlFor="password">Password</label>
                <input className="col-3" type="password" id="password" onChange={handlePassword} value={password} />
                {
                    passwordError ?
                    <p style={{ color: 'red' }}>{passwordError}</p> : ''
                }
            </div>
            </div>
            <div className="form-row">
            <div className="w-100">
                <label className="col-3" htmlFor="confirm_password">Confirm Password</label>
                <input className="col-3" type="password" id="confirm_password" onChange={handleConfirmPassword} value={confirmPassword} />
                {
                    confirmPasswordError ?
                    <p style={{ color: 'red' }}>{confirmPasswordError}</p> : ''
                }
            </div>
            </div>
        </form>
    );
}
export default Form;