window.onload = () => {
	getAllTodos();
}

const getAllTodos = () => {
	const xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			const responseJson = xhr.responseText;
			populateTable(JSON.parse(responseJson));
		}
	}
	
	xhr.open("GET", "http://localhost:8080/BetterServletExample/api/todos");
	
	xhr.send();
}

const populateTable = listOfTodos => {
	
	for (let todo of listOfTodos) {
		const tdId = document.createElement("td");
		const tdTitle = document.createElement("td");
		const tdDescription = document.createElement("td");
		
		// Set the value of each cell
		tdId.textContent = todo.id;
		tdTitle.textContent = todo.title;
		tdDescription.textContent = todo.description;
		
		// Create a row to be appended onto our table
		const row = document.createElement("tr");
		
		// Set the td's to the corresponding order of our table header
		row.appendChild(tdId);
		row.appendChild(tdTitle);
		row.appendChild(tdDescription);
		
		
		// Append our row onto our table of todos
		document.getElementById("todoTable").appendChild(row);
	}
}