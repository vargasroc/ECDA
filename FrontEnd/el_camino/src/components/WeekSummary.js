import React from 'react';
import { Link } from 'react-router-dom';

const WeekSummary = ({ weekNumber, summary }) => {
  return (
    <div className="week-summary">
      <h3>Semana {weekNumber}</h3>
      <p>{summary}</p>
      <Link to={`/week/${weekNumber}`}>Ver más</Link>
    </div>
  );
};

export default WeekSummary;
