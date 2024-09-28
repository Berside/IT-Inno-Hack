import { useState, useEffect } from 'react';
import Button from 'react-bootstrap/Button';
import Offcanvas from 'react-bootstrap/Offcanvas';
import { Navbar, Nav, Container } from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Routes, Route, useLocation } from 'react-router-dom';
import WorkPlaces from '../../pages/WorkPlaces';
import Login from '../../pages/Login';

function Example() {
  const [show, setShow] = useState(false);
  const [currentPath, setCurrentPath] = useState('');
  const location = useLocation();

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  useEffect(() => {
    setCurrentPath(location.pathname);
  }, [location]);

  return (
    <>
      {currentPath !== '/exit' && (
        <Navbar collapseOnSelect expand="md" bg="black" variant="dark">
          <Container>
            <Navbar.Brand> IT Inno Hack </Navbar.Brand>
            <Nav className="ml-auto">
              <Nav.Item>
                <Nav.Link >Nickname</Nav.Link>
                <Nav.Link onClick={handleShow}>Options</Nav.Link>
              </Nav.Item>
            </Nav>
          </Container>
        </Navbar>
      )}

      <Offcanvas show={show} onHide={handleClose} placement='end' className="bg-black text-white" style={{ '--bs-offcanvas-width': '10%' }}>
        <Offcanvas.Header closeButton>
          <Offcanvas.Title>Options</Offcanvas.Title>
        </Offcanvas.Header>
        <Offcanvas.Body>
          <Nav.Link href="/WorkPlaces">WorkPlaces</Nav.Link>
          <Nav.Link href="/about">Recent</Nav.Link>
          <Nav.Link href="/Contacts">Create</Nav.Link>
          <Nav.Link href="/profile">Profile</Nav.Link>
          <Nav.Link href="/exit">Exit</Nav.Link>
        </Offcanvas.Body>
      </Offcanvas>
      <main>
        <Routes>
          <Route path="/WorkPlaces" element={<WorkPlaces />} />
          <Route path="/exit" element={<Login />} />
        </Routes>
      </main>
    </>
  );
}

export default function App() {
  return (
    <Router>
      <Example />
    </Router>
  );
}