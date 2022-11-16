
 
 window.onload = () =>{
	
	
	fetch("ListadoSim")
	
		.then(resp => resp.json())
		.then(data => pintarDatos(data))
	

 
 
 const pintarDatos = (data)=>{

	let div=document.querySelector("div")
	let table = document.createElement("TABLE");
	table.classList.add("borde")
	 
	
		  
	for(let datos of data){
		
		let row = document.createElement("TR");
		let id = document.createElement("TD");
		let nombre = document.createElement("TD");
		let edad= document.createElement("TD");
		let categoria = document.createElement("TD");
		
		
		id.textContent=datos.id;
		row.append(id);
		nombre.textContent=datos.nombre;
		row.append(nombre);
		edad.textContent=datos.edad;
		row.append(edad);
		categoria.textContent=datos.categoria;
		row.append(categoria);
		
		table.append(row);
		
		
	}	 
		
		div.append(table);
		
}



}	


		/*	
		
		let tabla = "<table border=1>";
		
		for(let i=0; i<datos.length; i++){
			
			tabla +="<tr><td>"  + datos[i].id
			
			      + "</td><td>"  + datos[i].nombre
			      
			      + "</td><td>"  + datos[i].categoria
			 
			      + "</td></tr>"
			
			
		}
		
		tabla += "</table>"
		
		const div=document.querySelector("div");
		
		div.innerHTML= tabla;
		
		*/

 
   
