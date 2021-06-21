//'use strict';


const getPlayers = async () => {
    const tBody = document.querySelector("tbody");
    tBody.innerHTML = "";
    const res = await axios.get("/players/");
    // output.innerHTML = "";
    res.data.forEach(player => {
        renderPlayers(player)
    });
}

// const getTeams = async () => {
//     // const tBody = document.querySelector("tbody");
//     // tBody.innerHTML = "";
//     const team = await axios.get("/fantasyteams/");
//     // output.innerHTML = "";
//     // team.data.forEach(player => {
//     //     renderPlayers(player)
//     // });
// }

const renderPlayers = player => {
    const tBody = document.querySelector("tbody");
    const tRow = document.createElement("tr");

    tRow.appendChild(update(player));
    tRow.appendChild(generateCell(player.playerId));
    tRow.appendChild(generateCell(player.playerIGN));
    tRow.appendChild(generateCell(player.role));
    // tRow.appendChild(update(player));
    tRow.appendChild(deletePlayer(player.playerId))

    tBody.appendChild(tRow);
}

const generateCell = (data) => {
    const tCell = document.createElement("td");
    tCell.innerText = data;
    tCell.className = "align-middle";
    return tCell;

}

const update = (player) => {
    const tCell = document.createElement("td");
    const updatePlayer = document.createElement("button");
    updatePlayer.innerText = "update";
    updatePlayer.className = "btn btn-primary";
    updatePlayer.setAttribute("type", "button");
    updatePlayer.setAttribute("data-bs-toggle", "modal");
    updatePlayer.setAttribute("data-bs-target", "#uPlayerModal")
    updatePlayer.addEventListener("click", function (event) {
        document.getElementById("updatePlayerIGN").value = player.playerIGN;
        document.getElementById("updateRole").value = player.role;
        document.getElementById("updatePlayerButton").setAttribute("playerID", player.playerId);
    });
    tCell.appendChild(updatePlayer);
    return tCell;
}

const deletePlayer = (playerId) => {
    const tCell = document.createElement("td");
    const deleteBPlayer = document.createElement("button");
    deleteBPlayer.innerText = "delete";
    deleteBPlayer.className = 'btn btn-danger';
    deleteBPlayer.setAttribute("type", "submit");
    deleteBPlayer.addEventListener("click", function () {
        deletePlayers(playerId);
    });

    tCell.appendChild(deleteBPlayer);
    return tCell;



}

// getTeams(teamId);
getPlayers();
//create
document.getElementById("createPlayer").addEventListener("submit", function (event) {
    event.preventDefault();
    let updateModal = document.getElementById('playerModal');
    let modal = bootstrap.Modal.getInstance(updateModal);
    modal.hide();

    const data = {

        playerIGN: this.playerIGN.value,
        role: this.role.value,

    }
    console.log(data);

    axios.post(`/players/create/${teamId}`, data)
        .then(res => {
            console.log(res);
            getPlayers();
            this.reset();
            this.make.focus();
        }).catch(err => console.log(err));

    console.log(this);
});

document.getElementById("updatePlayer").addEventListener("submit", function (event) {
    event.preventDefault();
    let updateModal = document.getElementById('uPlayerModal');
    let modal = bootstrap.Modal.getInstance(updateModal);
    modal.hide();

    const playerID = document.getElementById("updatePlayerButton").getAttribute("playerID")
    const data = {

        playerIGN: this.updatePlayerIGN.value,
        role: this.updateRole.value

    }

    axios.put(`/players/update/${playerID}`, data)
        .then(res => {
            getPlayers();
            this.reset();
            this.make.focus();
        }).catch(err => console.log(err));

    console.log(this);
});

const deletePlayers = async (playerId) => {
    const res = await axios.delete(`/players/remove/${playerId}`);
    getPlayers();
};


