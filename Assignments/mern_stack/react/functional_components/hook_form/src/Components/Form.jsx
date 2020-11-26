import React, { useState } from 'react';

import Bootstrap from 'bootstrap/dist/css/bootstrap.css';



const Form = props => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');


    return (
        <form className="text-center p-2">
            <div>
                <label className="col-3" htmlFor="firstName">First Name</label>
                <input className="col-3" type="text" id="firstName" onChange={e => { setFirstName(e.target.value) }} value={firstName} />
            </div>
            <div>
                <label className="col-3" htmlFor="lastName">Last Name</label>
                <input className="col-3" type="text" id="lastName" onChange={e => { setLastName(e.target.value) }} value={lastName} />
            </div>
            <div>
                <label className="col-3" htmlFor="email">Email</label>
                <input className="col-3" type="email" id="email" onChange={e => { setEmail(e.target.value) }} value={email} />
            </div>
            <div>
                <label className="col-3" htmlFor="password">Password</label>
                <input className="col-3" type="password" id="password" onChange={e => { setPassword(e.target.value) }} value={password} />
            </div>
            <div>
                <label className="col-3" htmlFor="confirm_password">Confirm Password</label>
                <input className="col-3" type="password" id="confirm_password" onChange={e => { setConfirmPassword(e.target.value) }} value={confirmPassword} />
            </div>

            <div className="row w-100 text-center p-4">
                <h4 className="text-center w-100">Your Form Data</h4>
                <table className="m-auto">
                    <tbody>
                        <tr>
                            <th>First Name:</th>
                            <th className="text-primary">{firstName}</th>
                        </tr>
                        <tr>
                            <th>Last Name:</th>
                            <th className="text-primary">{lastName}</th>
                        </tr>
                        <tr>
                            <th>Email:</th>
                            <th className="text-primary">{email}</th>
                        </tr>
                        <tr>
                            <th>Password:</th>
                            <th className="text-primary">{password}</th>
                        </tr>
                        <tr>
                            <th>Confirm Password:</th>
                            <th className="text-primary">{confirmPassword}</th>
                        </tr>
                    </tbody>
                </table>
            </div>
        </form>
    );
}
export default Form;