// React import not required with new JSX transform
import Box from '@mui/material/Box'
import List from '@mui/material/List'
import ListItem from '@mui/material/ListItem'
import ListItemText from '@mui/material/ListItemText'
import Divider from '@mui/material/Divider'
import Typography from '@mui/material/Typography'

const sample = [
  {
    meal: 'Breakfast',
    items: [
      { name: 'Oatmeal', kcal: 320, protein: 12 },
      { name: 'Banana', kcal: 105, protein: 1.3 },
    ],
  },
  {
    meal: 'Lunch',
    items: [
      { name: 'Grilled chicken', kcal: 420, protein: 35 },
      { name: 'Rice', kcal: 210, protein: 4 },
    ],
  },
  {
    meal: 'Dinner',
    items: [{ name: 'Salmon', kcal: 360, protein: 30 }],
  },
]

export default function Meals() {
  return (
    <Box sx={{ p: 2 }}>
      <List disablePadding>
        {sample.map((section, si) => (
          <Box key={section.meal} sx={{ mb: 1 }}>
            <Typography variant="subtitle1" sx={{ fontWeight: 600, mb: 0.5 }}>
              {section.meal}
            </Typography>
            <Box sx={{ bgcolor: 'background.paper', borderRadius: 1, boxShadow: 0 }}>
              {section.items.map((it, i) => (
                <>
                  <ListItem key={it.name + i} sx={{ py: 1 }}>
                    <ListItemText primary={it.name} secondary={`${it.kcal} kcal • ${it.protein} g protein`} />
                    <Typography variant="body2" sx={{ fontWeight: 600 }}>{it.kcal}</Typography>
                  </ListItem>
                  {i !== section.items.length - 1 && <Divider component="li" />}
                </>
              ))}
            </Box>
            {si !== sample.length - 1 && <Divider sx={{ my: 1 }} />}
          </Box>
        ))}
      </List>
    </Box>
  )
}
