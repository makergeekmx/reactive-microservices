import { Container, Typography, Box } from '@mui/material';
import ProductsPanel from './components/ProductsPanel';
import InventoryPanel from './components/InventoryPanel';
import SuppliersPanel from './components/SuppliersPanel';
import UsersPanel from './components/UsersPanel';

function App() {
  return (
    <Container maxWidth="lg">
      <Box sx={{ my: 4 }}>
        <Typography variant="h3" component="h1" gutterBottom>
          Reactive Microservices Dashboard
        </Typography>
        <ProductsPanel />
        <InventoryPanel />
        <SuppliersPanel />
        <UsersPanel />
      </Box>
    </Container>
  );
}

export default App;
