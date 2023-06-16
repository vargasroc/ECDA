import React from 'react';

function Input({ type, name, label, error, register }) {
  return (
    <div className="form-group">
      <label htmlFor={name}>{label}</label>
      <input
        type={type}
        name={name}
        id={name}
        className={`form-control ${error ? 'is-invalid' : ''}`}
        ref={register}
      />
      {error && <span className="invalid-feedback">{error.message}</span>}
    </div>
  );
}

export default Input;
