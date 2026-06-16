import { useEffect, useState } from 'react';
import { Box, Card, CardContent, CardHeader, List, ListItem, ListItemText, Typography } from '@mui/material';
import axios from 'axios';

function InventoryPanel() {
  const [inventory, setInventory] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8082/api/inventory').then((response) => setInventory(response.data));
  }, []);

  return (
    <Card sx={{ mb: 3 }}>
      <CardHeader title="Inventory" />
      <CardContent>
        {inventory.length === 0 ? (
          <Typography>No inventory records available.</Typography>
        ) : (
          <List>
            {inventory.map((item) => (
              <ListItem key={item.id}>
                <ListItemText primary={`Product ${item.productId}: ${item.quantity}`} secondary={`Location: ${item.location}`} />
              </ListItem>
            ))}
          </List>
        )}
      </CardContent>
    </Card>
  );
}

export default InventoryPanel;
