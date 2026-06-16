import { useEffect, useState } from 'react';
import { Box, Card, CardContent, CardHeader, List, ListItem, ListItemText, Typography } from '@mui/material';
import apiClient from '../api/apiClient';

function ProductsPanel() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    apiClient.get('/products').then((response) => setProducts(response.data));
  }, []);

  return (
    <Card sx={{ mb: 3 }}>
      <CardHeader title="Products" />
      <CardContent>
        {products.length === 0 ? (
          <Typography>No products available.</Typography>
        ) : (
          <List>
            {products.map((product) => (
              <ListItem key={product.id}>
                <ListItemText primary={product.name} secondary={`Price: $${product.price}`} />
              </ListItem>
            ))}
          </List>
        )}
      </CardContent>
    </Card>
  );
}

export default ProductsPanel;
