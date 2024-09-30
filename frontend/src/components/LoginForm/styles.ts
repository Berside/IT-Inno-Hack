import styled from 'styled-components';
const LoginFormContainer = styled.div`
  max-width: 400px;
  margin: 0 auto;
  padding: 2rem;
  background-color: ${props => props.theme.backgroundColor};
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.5),
           -4px 4px 6px rgba(0, 0, 0, 0.5);


`;

const FormTitle = styled.h2`
  text-align: center;
  margin-bottom: 1.5rem;
  color: ${({ theme }) => theme.text};
`;

const InputGroup = styled.div`
  margin-bottom: 1rem;
`;

const Label = styled.label`
  display: block;
  margin-bottom: 0.5rem;
  color: ${({ theme }) => theme.text};
`;

const Input = styled.input`
  width: 100%;
  padding: 0.75rem;
  font-size: 1rem;
  border: 1px solid ${props => props.theme.borderColor};
  border-radius: 4px;

  &:focus {
    width: 105%;
  }
`;

const SubmitButton = styled.button`
  width: 100%;
  padding: 0.75rem;
  font-size: 1rem;
  background-color: ${({ theme }) => theme.background};
  color: ${({ theme }) => theme.text};
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
  box-shadow: 0 0 2px ${({ theme }) => theme.text};

  &:hover {
    background-color: ${props => props.theme.hoverColor};
    transform: scale(1.05,1.05);
  }
`;

const ErrorMessage = styled.span`
  color: red;
  font-size: 0.9rem;
  margin-top: 0.5rem;
`;

export { LoginFormContainer, FormTitle, InputGroup, Label, Input, SubmitButton, ErrorMessage };
