function createChart(canvasId, label, consumed, target) {
  const chartSpec = {
    type: "bar",
    options: {
      scales: {
        x: {
          grid: {
            display: false,
          },
          border: {
            display: false,
          },
        },
        y: {
          display: false,
          grid: {
            display: false,
          },
        },
      },
      plugins: {
        legend: {
          display: false,
        },
      },
    },
    plugins: [ChartDataLabels],
    data: {
      labels: [label],
      datasets: [
        {
          label: "Consumed",
          data: [consumed],
          backgroundColor: ["rgb(255, 179, 41, 1.0)"],
        },
        {
          label: "Target",
          data: [target],
          backgroundColor: ["rgb(255, 179, 41, 0.25)"],
        },
      ],
    },
  };
  return new Chart(document.getElementById(canvasId), chartSpec);
}
