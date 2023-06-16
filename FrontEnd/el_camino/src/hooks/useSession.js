import React from 'react';
import { SessionProvider as CustomSessionProvider } from './useSession';
import App from '../App';

export function useSession() {
  return (
    <CustomSessionProvider>
      <App />
    </CustomSessionProvider>
  );
}

export function SessionProvider() {
  // ... lógica del componente SessionProvider
}

export default useSession;

