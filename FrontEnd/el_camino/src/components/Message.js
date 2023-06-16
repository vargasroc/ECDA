import { Link } from "react-router-dom";

export function Message({ status, setStatus, message, textButton, link = "" }) {
  const messageClassName = status ? "d-flex" : "d-none";

  return (
    <div className={`page ${messageClassName}`}>
      <div className="container">
        <div className="box_message">
          <p className="title">¡Muchas gracias!</p>
          <p className="frase">{message}</p>
        </div>

        {link ? (
          <Link to={link}>
            <button className="boton" onClick={() => setStatus(false)}>
              {textButton}
            </button>
          </Link>
        ) : (
          <button className="boton" onClick={() => setStatus(false)}>
            {textButton}
          </button>
        )}
      </div>
    </div>
  );
}
