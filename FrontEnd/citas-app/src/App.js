import React, { useState, useEffect } from 'react';

function App() {
  const [quote, setQuote] = useState(null);
  const [modalVisible, setModalVisible] = useState(false);

  useEffect(() => {
    fetchNewQuote();
  }, []);

  const openModal = () => {
    setModalVisible(true);
  };

  const closeModal = () => {
    setModalVisible(false);
  };

  const API_URL = 'http://localhost:3333/quotes/random';

  const fetchNewQuote = async () => {
    try {
      const response = await fetch(API_URL);
      const data = await response.json();
      if (response.ok) {
        setQuote(data); // Actualiza el estado 'quote' con la nueva cita obtenida
      } else {
        console.error('Error al obtener la cita:', data.error);
      }
    } catch (error) {
      console.error('Error de red:', error);
    }
  };

  const fetchAnotherQuote = () => {
    setQuote(null); // Reinicia la cita actual
    fetchNewQuote(); // Obtiene una nueva cita
  };

  return (
    <div className="App">
      <h1>Citas Inspiradoras</h1>
      {quote && (
        <>
          <p>{quote.text}</p>
          <p>- {quote.author}</p>
          <button onClick={fetchAnotherQuote}>Nueva Cita</button>
        </>
      )}
      {modalVisible && (
        <div className="modal">
          <div className="modal-content">
            <span className="close" onClick={closeModal}>
              &times;
            </span>
            <h2>{quote.author}</h2>
            <p>{quote.text}</p>
          </div>
        </div>
      )}
    </div>
  );
}

export default App;
