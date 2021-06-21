
const getTeams = async () => {
    const tBody = document.querySelector("tbody");
    tBody.innerHTML = "";
    const res = await axios.get("/fantasyteams/");
    // output.innerHTML = "";
    res.data.forEach(team => {
        renderTeam(team)
    });
}

const renderTeam = team => {
    const tBody = document.querySelector("tbody");
    const tRow = document.createElement("tr");

    tRow.appendChild(update(team));
    tRow.appendChild(generateCell(team.teamId));
    tRow.appendChild(generateCell(team.teamName));
    // tRow.appendChild(generateCell(team.teamIGN));
    // tRow.appendChild(generateCell(team.role));
    // tRow.appendChild(update(team));
    tRow.appendChild(deleteTeam(team.teamId));


    tBody.appendChild(tRow);
}

const generateCell = (data) => {
    const tCell = document.createElement("td");
    tCell.innerText = data;
    tCell.className = "align-middle";
    return tCell;

}

const update = (team) => {
    const tCell = document.createElement("td");
    const updateTeam = document.createElement("button");
    updateTeam.innerText = "update";
    updateTeam.className = "btn btn-primary";
    updateTeam.setAttribute("type", "button");
    updateTeam.setAttribute("data-bs-toggle", "modal");
    updateTeam.setAttribute("data-bs-target", "#uTeamModal")
    updateTeam.addEventListener("click", function (event) {
        document.getElementById("updateTeamName").value = team.teamName;
        // document.getElementById("updateRole").value = team.role;
        document.getElementById("updateTeamButton").setAttribute("teamID", team.teamId);
    });
    tCell.appendChild(updateTeam);
    return tCell;
}

const deleteTeam = (teamId) => {
    const tCell = document.createElement("td");
    const deleteBTeam = document.createElement("button");
    deleteBTeam.innerText = "delete";
    deleteBTeam.className = 'btn btn-danger';
    deleteBTeam.setAttribute("type", "submit");
    deleteBTeam.addEventListener("click", function () {
        deleteteams(teamId);
    });

    tCell.appendChild(deleteBTeam);
    return tCell;



}

getTeams();
//create
document.getElementById("createTeam").addEventListener("submit", function (event) {
    event.preventDefault();
    let updateModal = document.getElementById('teamModal');
    let modal = bootstrap.Modal.getInstance(updateModal);
    modal.hide();

    const data = {

        teamName: this.teamName.value,
        //role: this.role.value,

    }

    axios.post("/fantasyteams/create", data)
        .then(res => {
            getTeams();
            this.reset();
            this.teamName.focus();
        }).catch(err => console.log(err));

    console.log(this);
});

document.getElementById("updateTeam").addEventListener("submit", function (event) {
    event.preventDefault();
    let updateModal = document.getElementById('uTeamModal');
    let modal = bootstrap.Modal.getInstance(updateModal);
    modal.hide();

    const teamID = document.getElementById("updateTeamButton").getAttribute("teamID")
    const data = {

        teamName: this.updateTeamName.value,
        //role: this.updateRole.value

    }

    axios.put(`/fantasyteams/update/${teamID}`, data)
        .then(res => {
            getTeams();
            this.reset();
            // this.teamName.focus();
        }).catch(err => console.log(err));

    console.log(this);
});

const deleteteams = async (teamId) => {
    const res = await axios.delete(`/fantasyteams/remove/${teamId}`);
    getTeams();
};