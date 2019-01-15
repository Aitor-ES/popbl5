 function pieChart(wins, loses){
 var nwins = wins;
 var nloses = loses;
 var ctxP = document.getElementById("pieChart").getContext('2d');
  var myPieChart = new Chart(ctxP, {
    type: 'pie',
    data: {
      labels: ["Wins","Loses"],
      datasets: [{
        data: [wins, loses],
        backgroundColor: ["#F7464A", "#46BFBD"],
        hoverBackgroundColor: ["#FF5A5E", "#5AD3D1"]
      }]
    },
    options: {
      responsive: true
    }
  });
}