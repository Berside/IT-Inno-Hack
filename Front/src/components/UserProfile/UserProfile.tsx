import React, { useState } from 'react';
import { Container, Row, Col, Image, Card, Button } from 'react-bootstrap';

interface UserProfileProps {
  name: string;
  age: number;
  occupation: string;
  avatarUrl?: string;
}

const UserProfile: React.FC<UserProfileProps> = ({ name, age, occupation, avatarUrl = '/default-avatar.png' }) => {
  const [isDarkMode, setIsDarkMode] = useState(false);

  const toggleDarkMode = () => {
    setIsDarkMode(prevMode => !prevMode);
  };

  return (
    <Container className={`mt-5 ${isDarkMode ? 'bg-dark text-light' : ''}`}>
      <Row>
        <Col xs={12} md={6} className="mb-4 mb-md-0">
          <Image src={avatarUrl} alt={`${name}'s avatar`} fluid roundedCircle />
        </Col>
        <Col xs={12} md={6}>
          <Card>
            <Card.Body>
              <Card.Title>{name}</Card.Title>
              <Card.Text>
                Возраст: {age} лет
              </Card.Text>
              <Card.Text>
                Профессия: {occupation}
              </Card.Text>
            </Card.Body>
          </Card>
        </Col>
      </Row>

      <Button variant={isDarkMode ? "light" : "dark"} onClick={toggleDarkMode}>
        {isDarkMode ? 'Переключить на светлый режим' : 'Переключить на темный режим'}
      </Button>
    </Container>
  );
};

export default UserProfile;
