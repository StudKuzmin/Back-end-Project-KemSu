let std1 = {
   id: 1,
   name: 'Иванов'
  };

let std2 = {
   id: 2,
   name: 'Петров'
  };
  
let std3 = {
   id: 3,
   name: 'Сидоров'
  };
  
let students = [std1,std2,std3];


function test() {             
  fetch('/fourth/api/test',{method: 'POST', headers: {'Content-Type': 'application/json;charset=utf-8'},body: JSON.stringify(students)})
  .then(function(response) {        
      if (response.ok) {
        return response.json();
	  }
      else {
		console.log(response);
	    throw response.text();
	  }	  	  
   })
  .then(function(data) {
	students = data;  
	let d = document.getElementById('divTest');      
    let t = d.firstChild;              
    t.nodeValue = JSON.stringify(students);
  })
  .catch(function(error) {
	console.log(error);
	alert("Error catch: " + error);  
  })
  ;
}



function ping() {                            
  var xhr = new XMLHttpRequest();
    
  var flagAsync = false;
  xhr.open("GET", "/fourth/api", flagAsync);
    
  xhr.send();
  
  
  if (xhr.status !== 200) {  
    alert( "Request error: " + xhr.status + ': ' + xhr.statusText );
  } 
  else { 
    var response = xhr.responseText;   
    var d = document.getElementById("divPing");      
    var t = d.firstChild;            
    t.nodeValue = t.nodeValue + " " + response;
   } 
}