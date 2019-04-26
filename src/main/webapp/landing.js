window.onload = () => {
	if(jobID == 2){
		getAllItems();
		getAllEmployees();
	}
	else{
		getItemsById();
	}
	disableDisplays();
	console.log(employeeID);
}

var employeeID = 0;
var jobID = 0;
var byStatusID = 0;

var  dEID, dFN, dLN, dEM, dJID, dUN, dPW

const setData = (iEID, iFN, iLN, iEM, iJID, iUN,iPW ) =>{
	dEID = iEID;
	dFN = iFN;
	dLN = iLN;
	dEM = iEM;
	dJID = iJID;
	dUN = iUN;
	dPW = iPW;
}

const setEmployeeId = (id) =>{
	employeeID = id;
}

const setPositionID = (id) =>{
	jobID = id;
}

const getAllEmployees = () => {
	const xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			const responseJson = xhr.responseText;
			clearTable();
			
			if(jobID == 2){
				populateEmployees(JSON.parse(responseJson));
			}
		}
	}
	xhr.open("POST", "http://localhost:8088/ERS/Employees");
	xhr.send();
}

const getAllItems = () => {
	const xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			const responseJson = xhr.responseText;
			clearTable();
			if(jobID == 2){
				populateAllReimbursements(JSON.parse(responseJson));

			}
			else{
				populateMyReimbursements(JSON.parse(responseJson));
			}
		}
	}
	xhr.open("POST", "http://localhost:8088/ERS/Reimbursement");
	xhr.send();
}

const getItemsById = () => {
	const xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			const responseJson = xhr.responseText;
			clearTable();
			populateMyReimbursements(JSON.parse(responseJson));
		}
	}
	xhr.open("POST", "http://localhost:8088/ERS/Reimbursement");
	xhr.send();
}

const getItemsById2 = () => {
	const xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			const responseJson = xhr.responseText;
			clearTable();
			populateReimbursementByID(JSON.parse(responseJson));
		}
	}
	xhr.open("POST", "http://localhost:8088/ERS/Reimbursement");
	xhr.send();
}

const getItemsByStatus = (statusID) => {
	byStatusID = statusID;
	const xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			const responseJson = xhr.responseText;
			clearTable();
			populateByStatus(JSON.parse(responseJson));
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
			clearTable();
			getAllItems();
		}
	}
	xhr.open("POST", "http://localhost:8088/ERS/CreateReimbursement");
	xhr.send(JSON.stringify(formData));
}

const submitReimbursement = () => {
	const usernameText = employeeID;
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
	var addRe = document.getElementById("AddReimbursementNav");
	var reimbNav = document.getElementById("ReimbursementNav");
	var myReimb = document.getElementById("MyReimbursements");
	var myProfile = document.getElementById("MyProfile");
	var empTable = document.getElementById("EmployeeNav");
	
	if(addRe){
		addRe.style.display = 'none';
	}
	
	if(reimbNav){
		reimbNav.style.display = 'none';
	}
	
	if(myReimb){
		myReimb.style.display = 'none';
	}
	
	if(myProfile){
		myProfile.style.display = 'none';
	}
	
	if(empTable){
		
		empTable.style.display = 'none';
	}
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
	var table;
	
	if(jobID == 2)
		{
		table = document.getElementById("itemTable");
		// document.getElementById("EmployeeTable").innerHTML = "";
		}
	else{
		table = document.getElementById("myReimbursementTable");

	}
	
	if(table){
		table.innerHTML = "";
	}
}

const populateAllReimbursements = (itemList) => {
	
	for (let item of itemList) {
		const tdId = document.createElement("td");
		const tdEId = document.createElement("td");
		const tdDesc = document.createElement("td");
		const tdAmt = document.createElement("td");
		const tdRDate = document.createElement("td");
		const tdDDate = document.createElement("td");
		const tdManager = document.createElement("td");
		const tdStatus = document.createElement("td");
			
		setTimeout(3000);

		const reqDate = Date(item.request_date);
		const decDate = Date(item.decision_date);
		
		tdId.innerHTML = item.id;
		tdEId.innerHTML = item.employee_id;
		tdDesc.innerHTML = item.description;
		tdAmt.innerHTML = "$" + item.amount;
		tdRDate.innerHTML =  reqDate;
		tdDDate.innerHTML = decDate;
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
			tdStatus.innerHTML = item.status_id+ "<button style='background-color: #131313; color: gray;' onclick='approveReimbursement("+ item.id+","+ employeeID 
			+ ")'>Y</button><button style='background-color: #131313; color: gray;' onclick='denyReimbursement("+ item.id+","+ employeeID + ")'>N</button>";
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

const populateMyReimbursements = (itemList) =>{

	for (let item of itemList) {
		
		if(item.employee_id != employeeID){
			continue;
		}
		
		const tdId = document.createElement("td");
		const tdEId = document.createElement("td");
		const tdDesc = document.createElement("td");
		const tdAmt = document.createElement("td");
		const tdRDate = document.createElement("td");
		const tdDDate = document.createElement("td");
		const tdManager = document.createElement("td");
		const tdStatus = document.createElement("td");
			
		setTimeout(3000);

		const reqDate = Date(item.request_date);
		const decDate = Date(item.decision_date);
		
		tdId.innerHTML = item.id;
		tdEId.innerHTML = item.employee_id;
		tdDesc.innerHTML = item.description;
		tdAmt.innerHTML = "$" + item.amount;
		tdRDate.innerHTML =  reqDate;
		tdDDate.innerHTML = decDate;
		tdManager.innerHTML = item.manager_id;
		
		if(item.status_id == 1){ item.status_id = "Pending "; }
		else if(item.status_id == 2) { item.status_id = "Approved ";}
		else if(item.status_id == 3) { item.status_id = "Declined ";}
		tdStatus.innerHTML = item.status_id;

		const row = document.createElement("tr");
		
		row.appendChild(tdId);
		row.appendChild(tdEId);
		row.appendChild(tdDesc);
		row.appendChild(tdAmt);
		row.appendChild(tdRDate);
		row.appendChild(tdDDate);
		row.appendChild(tdManager);
		row.appendChild(tdStatus);
		
		document.getElementById("myReimbursementTable").appendChild(row);
	}
}

const populateReimbursementByID= (itemList) =>{

	console.log("supposebly fetching: " + document.getElementById("EID").value);
	for (let item of itemList) {
		
		if(item.employee_id != document.getElementById("EID").value){
			continue;
		}
		
		const tdId = document.createElement("td");
		const tdEId = document.createElement("td");
		const tdDesc = document.createElement("td");
		const tdAmt = document.createElement("td");
		const tdRDate = document.createElement("td");
		const tdDDate = document.createElement("td");
		const tdManager = document.createElement("td");
		const tdStatus = document.createElement("td");
			
		setTimeout(3000);

		const reqDate = Date(item.request_date);
		const decDate = Date(item.decision_date);
		
		tdId.innerHTML = item.id;
		tdEId.innerHTML = item.employee_id;
		tdDesc.innerHTML = item.description;
		tdAmt.innerHTML = "$" + item.amount;
		tdRDate.innerHTML =  reqDate;
		tdDDate.innerHTML = decDate;
		tdManager.innerHTML = item.manager_id;
		
		if(item.status_id == 1){ item.status_id = "Pending "; }
		else if(item.status_id == 2) { item.status_id = "Approved ";}
		else if(item.status_id == 3) { item.status_id = "Declined ";}
		tdStatus.innerHTML = item.status_id;

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
const populateByStatus = (itemList) =>{

	for (let item of itemList) {
		
		if(item.employee_id != employeeID
				|| item.status_id != byStatusID ){
			continue;
		}
		
		const tdId = document.createElement("td");
		const tdEId = document.createElement("td");
		const tdDesc = document.createElement("td");
		const tdAmt = document.createElement("td");
		const tdRDate = document.createElement("td");
		const tdDDate = document.createElement("td");
		const tdManager = document.createElement("td");
		const tdStatus = document.createElement("td");
			
		const reqDate = Date(item.request_date);
		const decDate = Date(item.decision_date);
		
		tdId.innerHTML = item.id;
		tdEId.innerHTML = item.employee_id;
		tdDesc.innerHTML = item.description;
		tdAmt.innerHTML = "$" + item.amount;
		tdRDate.innerHTML =  reqDate;
		tdDDate.innerHTML = decDate;
		tdManager.innerHTML = item.manager_id;
		
		if(item.status_id == 1){ item.status_id = "Pending "; }
		else if(item.status_id == 2) { item.status_id = "Approved ";}
		else if(item.status_id == 3) { item.status_id = "Declined ";}
		tdStatus.innerHTML = item.status_id;

		const row = document.createElement("tr");
		
		row.appendChild(tdId);
		row.appendChild(tdEId);
		row.appendChild(tdDesc);
		row.appendChild(tdAmt);
		row.appendChild(tdRDate);
		row.appendChild(tdDDate);
		row.appendChild(tdManager);
		row.appendChild(tdStatus);
		
		document.getElementById("myReimbursementTable").appendChild(row);
	}
}

const populateEmployees = (listOfEmployees) =>{
console.log(listOfEmployees);
	for (let emp of listOfEmployees) {
		const tdEId = document.createElement("td");
		const tdUn = document.createElement("td");
		const tdFn = document.createElement("td");
		const tdLn = document.createElement("td");
		const tdEm = document.createElement("td");
		
		tdEId.innerHTML = emp.employee_id;
		tdUn.innerHTML = emp.username;
		tdFn.innerHTML = emp.first_name;
		tdLn.innerHTML = emp.last_name;
		tdEm.innerHTML =  emp.email;
		
		const row = document.createElement("tr");
		
		row.appendChild(tdEId);
		row.appendChild(tdUn);
		row.appendChild(tdFn);
		row.appendChild(tdLn);
		row.appendChild(tdEm);
		
		document.getElementById("EmployeeTable").appendChild(row);
	}
}

const approveReimbursement = (rid, mid) =>{
	console.log("Approved Pressed for request #" + rid + " by " + mid);
	
	const xhr = new XMLHttpRequest();
	const formData = decisionForm(rid, mid);
	
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			setTimeout(3000);
			getAllItems();
		}
	}
	xhr.open("POST", "http://localhost:8088/ERS/ApproveRe");
	xhr.send(JSON.stringify(formData));
}

const denyReimbursement = (rid, mid) => {
	console.log("Deny Pressed for request #" + rid + " by " + mid);
	
	const xhr = new XMLHttpRequest();	
	const formData = decisionForm(rid, mid);
	
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			setTimeout(3000);
			getAllItems();
		}
	}
	xhr.open("POST", "http://localhost:8088/ERS/DenyRe");
	xhr.send(JSON.stringify(formData));
}

const decisionForm = (rid, mid) =>{
	return {
		id : rid,
		manager_id : mid
	}
}

const ProfileUpdateFormShow = () =>{
	document.getElementById("changeEmail").style.display = 'block';
	document.getElementById("ConfirmUpdate").style.display = 'block';
	document.getElementById("CancelUpdate").style.display = 'block';

	document.getElementById("UpdateButton").style.display = 'none';

}
const ProfileUpdateFormHide = () =>{
	document.getElementById("changeEmail").style.display = 'none';
	document.getElementById("ConfirmUpdate").style.display = 'none';
	document.getElementById("CancelUpdate").style.display = 'none';

	document.getElementById("UpdateButton").style.display = 'block';

}

const CancelUpdateProfile = () =>{
	document.getElementById("changeEmail").value = "";
	ProfileUpdateFormHide();
}

const SubmitForm = () =>{
	
	var value = document.getElementById("changeEmail").value;
	
	console.log("email value to change: " + value);
	return{
		employee_id : dEID,
		first_name : dFN,
		last_name : dLN,
		email : value,
		job_id : dJID,
		username : dUN,
		password : dPW
	}
}

const UpdateUser = () => {
	const xhr = new XMLHttpRequest();	
	const formData = SubmitForm();
	console.log("Updating user: " + dFN);
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			setTimeout(3000);

		}
	}
	xhr.open("POST", "http://localhost:8088/ERS/EUpdate");
	xhr.send(JSON.stringify(formData));
	
	location.reload();

}

