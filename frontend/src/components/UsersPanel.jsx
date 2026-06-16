import { useEffect, useState } from 'react';
import { Card, CardContent, CardHeader, List, ListItem, ListItemText, Typography } from '@mui/material';
import axios from 'axios';

function UsersPanel() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8084/api/users').then((response) => setUsers(response.data));
  }, []);

  return (
    <Card sx={{ mb: 3 }}>
      <CardHeader title="Users" />
      <CardContent>
        {users.length === 0 ? (
          <Typography>No users available.</Typography>
        ) : (
          <List>
            {users.map((user) => (
              <ListItem key={user.id}>
                <ListItemText primary={user.username} secondary={user.email} />
              </ListItem>
            ))}
          </List>
        )}
      </CardContent>
    </Card>
  );
}

export default UsersPanel;
