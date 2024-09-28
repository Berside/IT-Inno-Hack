import React from 'react';
import { ThemeProvider } from 'styled-components';
import TogglerButton from './components/TogglerButton';
import GlobalStyle from './styles/global';
import ThemeContext from './contexts/ThemeContext';
import { lightTheme, darkTheme } from './styles/themes';
import useThemeMode from './hooks/useThemeMode';
import LoginForm from './components/LoginForm';
import RegForm from './components/RegForm';
import { HeaderContainerStyle, HeaderContentStyle } from './styles/header';
import Gheader from './components/GHeader';


function App() {
  const { theme, themeToggler } = useThemeMode();
  const themeMode = theme === 'light' ? lightTheme : darkTheme;

  return (
    <Gheader/>
  );
}

export default App;