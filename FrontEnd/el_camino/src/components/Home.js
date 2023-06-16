import React from 'react';
import WeekSummary from './WeekSummary';

const Home = () => {
  const weekSummaries = [
    {
      weekNumber: 1,
      summary: 'Introducción al camino del artista y la importancia de la autenticidad.'
    },
    {
      weekNumber: 2,
      summary: 'Exploración de las creencias limitantes y la recuperación de la confianza creativa.'
    },
    // Agrega más objetos para cada semana con su número y resumen correspondiente
  ];

  return (
    <section>
      <h2>Bienvenido al Camino del Artista</h2>
      <div className="week-summaries">
        {weekSummaries.map((week) => (
          <WeekSummary
            key={week.weekNumber}
            weekNumber={week.weekNumber}
            summary={week.summary}
          />
        ))}
      </div>
    </section>
  );
};

export default Home;
