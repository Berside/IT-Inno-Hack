import { HiMoon } from 'react-icons/hi';
import { FaSun } from 'react-icons/fa';

import * as S from './styles';

interface ThemeTogglerProps {
  themeToggler: () => void;
}

function TogglerButton({ themeToggler }: ThemeTogglerProps) {
  const currentTheme = window.localStorage.getItem('theme') || 'dark';

  return (
    <S.Container>
      <label htmlFor="checkbox" className="switch">
        <input
          id="checkbox"
          type="checkbox"
          onClick={themeToggler}
          onChange={() => false}
          checked={currentTheme === 'light'}
        />
        <S.Icons className="slider round">
          {currentTheme === 'light' ? (
            <>
              <HiMoon style={{ marginLeft: '6.3px', height: '10px' }} />
            </>
          ) : (
            <>
              <FaSun size={0} style={{ marginLeft: '41px', height: '10px' }} />
            </>
          )}
        </S.Icons>
        <span className="theme-name">{currentTheme.charAt(0).toUpperCase() + currentTheme.slice(1)}</span>
      </label>
    </S.Container>
  );
}

export default TogglerButton;
