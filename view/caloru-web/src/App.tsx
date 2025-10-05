import React from 'react'
import './App.css'
import { ThemeProvider, createTheme } from '@mui/material/styles'
import CssBaseline from '@mui/material/CssBaseline'
import Box from '@mui/material/Box'
import Container from '@mui/material/Container'
import AppBar from '@mui/material/AppBar'
import Toolbar from '@mui/material/Toolbar'
import Typography from '@mui/material/Typography'
import Paper from '@mui/material/Paper'

import Weekdays from './components/Weekdays'
import Meals from './components/Meals'
import FooterBar from './components/FooterBar'

const theme = createTheme({
  palette: {
    primary: {
      main: '#2e7d32', // green
      contrastText: '#fff',
    },
    background: {
      default: '#f2f5f2',
      paper: '#ffffff',
    },
  },
  components: {
    MuiAppBar: {
      defaultProps: {
        elevation: 0,
      },
    },
  },
})

function App() {
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Box sx={{ minHeight: '100vh', display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
        <AppBar position="static" color="primary">
          <Toolbar sx={{ justifyContent: 'center' }}>
            <Typography variant="h6" component="div" sx={{ fontWeight: 600 }}>
              Caloru
            </Typography>
          </Toolbar>
        </AppBar>

        <Container maxWidth="xs" sx={{ px: 0, mt: 1, pb: 10 }}>
          <Weekdays />

          <Paper elevation={1} sx={{ mt: 1, borderRadius: 2, overflow: 'hidden' }}>
            <Meals />
          </Paper>
        </Container>

        <FooterBar />
      </Box>
    </ThemeProvider>
  )
}

export default App
