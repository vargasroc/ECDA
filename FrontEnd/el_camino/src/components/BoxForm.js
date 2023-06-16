import React from 'react';
import { Card } from 'react-bootstrap';

function BoxForm({ handleSubmit, dataForm, children }) {
  return (
    <Card className="p-4">
      <form onSubmit={handleSubmit(dataForm)}>
        {children}
      </form>
    </Card>
  );
}

export default BoxForm;
