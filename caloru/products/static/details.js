/* globals Chart:false, feather:false */

(() => {
    'use strict'

    feather.replace({ 'aria-hidden': 'true' })

    // Graphs
    const ctx = document.getElementById('myChart')
    // eslint-disable-next-line no-unused-vars
    const myChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
            labels: [
                'Protein',
                'Carbohydrates',
                'Fat',
            ],
            datasets: [{
                data: [
                    100.5,
                    70,
                    50
                ],
                backgroundColor: [
                    'rgb(255, 99, 132)',
                    'rgb(54, 162, 235)',
                    'rgb(255, 205, 86)'
                ],
            }]
        }
    })
})()
