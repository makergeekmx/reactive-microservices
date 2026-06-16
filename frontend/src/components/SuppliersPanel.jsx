import { useEffect, useState } from 'react';
import { Card, CardContent, CardHeader, List, ListItem, ListItemText, Typography } from '@mui/material';
import axios from 'axios';

function SuppliersPanel() {
  const [suppliers, setSuppliers] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8083/api/suppliers').then((response) => setSuppliers(response.data));
  }, []);

  return (
    <Card sx={{ mb: 3 }}>
      <CardHeader title="Suppliers" />
      <CardContent>
        {suppliers.length === 0 ? (
          <Typography>No suppliers available.</Typography>
        ) : (
          <List>
            {suppliers.map((supplier) => (
              <ListItem key={supplier.id}>
                <ListItemText primary={supplier.name} secondary={supplier.contactEmail} />
              </ListItem>
            ))}
          </List>
        )}
      </CardContent>
    </Card>
  );
}

export default SuppliersPanel;
