window.onload = () => {
	getAllItems();
	disableDisplays();
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

const create = () => {
	const xhr = new XMLHttpRequest();
	
	console.log("clicked create");
	const formData = submitReimbursement();
	
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			setTimeout(3000);
			getAllItems();
		}
	}
	xhr.open("POST", "http://localhost:8088/ERS/CreateReimbursement");
	xhr.send(JSON.stringify(formData));
}

const submitReimbursement = () => {
	const usernameText = document.getElementById("username").value;
	const amountText = document.getElementById("amount").value;
	const descText = document.getElementById("description").value;
	
	console.log("parse form:" + usernameText + "," + amountText + "," + descText);
	return {
		employee_id: usernameText,
		amount: amountText,
		description: descText
	}
}

const disableDisplays = () =>{
	document.getElementById("AddReimbursementNav").style.display = 'none';
	document.getElementById("ReimbursementNav").style.display = 'none';
}

const toggleDisplay = (id) =>{	
	
	var display = document.getElementById(id);	
		if(	display.style.display  == 'none'){
			display.style.display  = 'block';
		}else{
			display.style.display  = 'none';
		}
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
		
		tdId.innerHTML = item.id;
		tdEId.innerHTML = item.employee_id;
		tdDesc.innerHTML = item.description;
		tdAmt.innerHTML = item.amount;
		tdRDate.innerHTML = item.request_date;
		tdDDate.innerHTML = item.decision_date;
		tdManager.innerHTML = item.manager_id;
		
		if(item.status_id == 1){ item.status_id = "Pending "; }
		else if(item.status_id == 2) { item.status_id = "Approved ";}
		else if(item.status_id == 3) { item.status_id = "Declined ";}
		
		if(item.status_id == "Approved "){
			tdStatus.innerHTML = item.status_id;
		}
		else if(item.status_id == "Declined "){
			tdStatus.innerHTML = item.status_id;
		}
		else{
			tdStatus.innerHTML = item.status_id+ "<button style='background-color: #131313; color: gray;' onclick='approveReimbursement("+ item.id+")'>Y</button><button style='background-color: #131313; color: gray;' onclick='denyReimbursement("+ item.id+")'>N</button>";
		}

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

const approveReimbursement = (id) =>{
	console.log("Approved Pressed for request #" + id);
	
	const xhr = new XMLHttpRequest();
	const formData = decisionForm();
	
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			setTimeout(3000);
			getAllItems();
		}
	}
	xhr.open("POST", "http://localhost:8088/ERS/ApproveRe");
	xhr.send(JSON.stringify(formData));
}

const denyReimbursement = (id) => {
	console.log("Deny Pressed for request #" + id);
	
	const xhr = new XMLHttpRequest();	
	const formData = decisionForm();
	
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			setTimeout(3000);
			getAllItems();
		}
	}
	xhr.open("POST", "http://localhost:8088/ERS/DenyRe");
	xhr.send(JSON.stringify(formData));
}

const decisionForm = () =>{
	
}