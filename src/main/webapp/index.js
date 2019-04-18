window.onload = () =>{
	document.getElementById()
	//getMyData();
}

const getMyData = () =>{
	
	const xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = () =>{
		if(xhr.status === 200 && xhr.readyState === 4){
			const json = xhr.responseText;
			console.log(json);		
			//populateStuff(JSON.parse(json));
		}
	};
	xhr.open("GET", "http://localhost:8088/Project1/api/employees")
	xhr.send();
}

/*
const populateStuff = (employees) =>{
	for(let employee of employees){
		const tdId = document
	}
}
*/