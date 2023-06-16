import React, { useEffect, useState } from 'react';

const WeekDetails = () => {
  const [weeks, setWeeks] = useState([]);

  const URL_DE_TU_API = 'https://localhost:3334/semana'

  useEffect(() => {
    // Función para realizar la solicitud a la API
    const fetchData = async () => {
      try {
        const response = await fetch(URL_DE_TU_API);
        const data = await response.json();
        setWeeks(data); // Actualiza el estado con los datos de la API
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData(); // Llama a la función para obtener los datos al cargar el componente
  }, []);

  return (
    <div>
      {weeks.map((week) => (
        <div key={week.id}>
          <h2>Semana {week.weekNumber}</h2>
          <p>{week.summary}</p>
        </div>
      ))}
    </div>
  );
};


export default WeekDetails;
