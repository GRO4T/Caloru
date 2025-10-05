// React import not required with new JSX transform
import Box from '@mui/material/Box'
import Button from '@mui/material/Button'
import Stack from '@mui/material/Stack'

const days = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']

export default function Weekdays() {
  return (
    <Box sx={{ px: 1 }}>
      <Stack direction="row" spacing={1} justifyContent="space-between" sx={{ overflowX: 'auto' }}>
        {days.map((d) => (
          <Button key={d} size="small" sx={{ flex: '1 0 auto', minWidth: 40 }}>
            {d}
          </Button>
        ))}
      </Stack>
    </Box>
  )
}
