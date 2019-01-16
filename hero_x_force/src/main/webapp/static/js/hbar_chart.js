
  function drawHorizontalBarChart(data){

  var d = data;
  var allAxis = (d[0].map(function(i, j){return i.area}));
  var values = (d[0].map(function(i, j){return i.value}));
  console.log(allAxis);
  console.log(values);
  new Chart(document.getElementById("horizontalBar"), {
    "type": "horizontalBar",
    "data": {
      "labels": allAxis,
      "datasets": [{
        "data": values,
        "fill": false,
        "backgroundColor": ["rgba(255, 99, 132, 0.2)", "rgba(255, 159, 64, 0.2)",
          "rgba(255, 205, 86, 0.2)", "rgba(75, 192, 192, 0.2)", "rgba(54, 162, 235, 0.2)",
          "rgba(153, 102, 255, 0.2)", "rgba(201, 203, 207, 0.2)"
        ],
        "borderColor": ["rgb(255, 99, 132)", "rgb(255, 159, 64)", "rgb(255, 205, 86)",
          "rgb(75, 192, 192)", "rgb(54, 162, 235)", "rgb(153, 102, 255)", "rgb(201, 203, 207)"
        ],
        "borderWidth": 1
      }]
    },
    options: {
         legend: {
            display: false
         },
      "scales": {
          xAxes: [{ 
       gridLines: { 
        display:false 
       },
        ticks: {
              beginAtZero: true
          }
      }], 
       yAxes: [{ 
       gridLines: { 
        display:false 
       } 
      }] 
    } 
     }
  });

}