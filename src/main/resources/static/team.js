
const getteams = async () => {
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

    tRow.appendChild(generateCell(team.teamId));
    tRow.appendChild(generateCell(team.teamName));
    // tRow.appendChild(generateCell(team.teamIGN));
    // tRow.appendChild(generateCell(team.role));
    // tRow.appendChild(update(team));


    tBody.appendChild(tRow);
}

const generateCell = (data) => {
    const tCell = document.createElement("td");
    tCell.innerText = data;
    tCell.className = "align-middle";
    return tCell;

}

getteams();
//create
document.getElementById("createTeam").addEventListener("submit", function (event) {
    event.preventDefault();

    const data = {

        teamName: this.teamName.value,
        //role: this.role.value,

    }

    axios.post("/fantasyteams/create", data)
        .then(res => {
            getteams();
            this.reset();
            this.teamName.focus();
        }).catch(err => console.log(err));

    console.log(this);
});


