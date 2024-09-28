
import { CSSProperties } from 'react';

const headerStyles: CSSProperties = {
  position: 'fixed',
  top: '10px',
  right: '10px',
  zIndex: 1000,
};

export const HeaderContainerStyle: CSSProperties = {
  ...headerStyles,
  display: 'flex' as const,
  alignItems: 'center' as const,
};

export const HeaderContentStyle: CSSProperties = {
  position: 'absolute',
  top: '10px',
  right: '10px',
};
