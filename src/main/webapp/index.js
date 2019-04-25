window.onload = () => {
	getAllItems();
}

const getAllItems = () => {
	
	const xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			const responseJson = xhr.responseText;
			clearTable();
			populateTable(JSON.parse(responseJson));
		}
	}
	
	xhr.open("POST", "http://localhost:8088/ERS/Reimbursement");

	xhr.send();
}

const clearTable = () => {
	var table = document.getElementById("itemTable");
	table.innerHTML = "";
}

const populateTable = itemList => {
	
	for (let item of itemList) {
		const tdId = document.createElement("td");
		const tdEId = document.createElement("td");
		const tdDesc = document.createElement("td");
		const tdAmt = document.createElement("td");
		const tdRDate = document.createElement("td");
		const tdDDate = document.createElement("td");
		const tdManager = document.createElement("td");
		const tdStatus = document.createElement("td");

		// Set the value of each cell
		tdId.textContent = item.id;
		tdEId.textContent = item.employee_id;
		tdDesc.textContent = item.description;
		tdAmt.textContent = item.amount;
		tdRDate.textContent = item.request_date;
		tdDDate.textContent = item.decision_date;
		tdManager.textContent = item.manager_id;
		tdStatus.textContent = item.status_id;

		const row = document.createElement("tr");
		
		row.appendChild(tdId);
		row.appendChild(tdEId);
		row.appendChild(tdDesc);
		row.appendChild(tdAmt);
		row.appendChild(tdRDate);
		row.appendChild(tdDDate);
		row.appendChild(tdManager);
		row.appendChild(tdStatus);
		
		document.getElementById("itemTable").appendChild(row);
	}
}