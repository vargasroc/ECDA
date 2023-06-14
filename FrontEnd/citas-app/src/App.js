import React, { useState } from 'react';
import './App.css';

const App = () => {
  const [quoteModalOpen, setQuoteModalOpen] = useState(false);
  const [quote, setQuote] = useState(null);

  const openQuoteModal = () => {
    fetch('API_URL') // Reemplaza 'API_URL' con la URL real de tu API
    .then(response => response.json())
    .then(data => setQuote(data))
    .catch(error => console.error(error));
    const randomQuote = // Lógica para obtener la cita aleatoria
    setQuote(randomQuote);
    setQuoteModalOpen(true);
  };

  const closeQuoteModal = () => {
    setQuoteModalOpen(false);
  };

  return (
    <div className="App">
      <button onClick={openQuoteModal}>Mostrar Cita</button>
      {quoteModalOpen && (
        <div className="modal">
          <div className="modal-content">
            <span className="close" onClick={closeQuoteModal}>
              &times;
            </span>
            <h2>{quote.title}</h2>
            <p>{quote.content}</p>
            <p>{quote.author}</p>
          </div>
        </div>
      )}
    </div>
  );
};

export default App;
