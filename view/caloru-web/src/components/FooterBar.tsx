// React import not required with new JSX transform
import Paper from '@mui/material/Paper'
import Box from '@mui/material/Box'
import Typography from '@mui/material/Typography'

export default function FooterBar() {
  // placeholder totals
  const totals = { kcal: 1415, protein: 82, fats: 48, carbs: 152 }

  return (
    <Paper
      elevation={6}
      square
      sx={{
        position: 'fixed',
        bottom: 0,
        left: 0,
        right: 0,
        bgcolor: 'background.paper',
        borderTopLeftRadius: 12,
        borderTopRightRadius: 12,
        px: 2,
        py: 1,
      }}
    >
      <Box sx={{ maxWidth: 480, mx: 'auto', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
        <Box sx={{ textAlign: 'left' }}>
          <Typography variant="caption">Consumed</Typography>
          <Typography variant="subtitle1" sx={{ fontWeight: 700 }}>{totals.kcal} kcal</Typography>
        </Box>

        <Box sx={{ display: 'flex', gap: 2 }}>
          <Box sx={{ textAlign: 'center' }}>
            <Typography variant="caption">Protein</Typography>
            <Typography variant="subtitle2" sx={{ fontWeight: 700 }}>{totals.protein} g</Typography>
          </Box>
          <Box sx={{ textAlign: 'center' }}>
            <Typography variant="caption">Fats</Typography>
            <Typography variant="subtitle2" sx={{ fontWeight: 700 }}>{totals.fats} g</Typography>
          </Box>
          <Box sx={{ textAlign: 'center' }}>
            <Typography variant="caption">Carbs</Typography>
            <Typography variant="subtitle2" sx={{ fontWeight: 700 }}>{totals.carbs} g</Typography>
          </Box>
        </Box>
      </Box>
    </Paper>
  )
}
