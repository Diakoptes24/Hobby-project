'use strict';

// const output = document.getElementById("output");

// const getPlayers = async () => {
//     const res = await axios.get("/hwa/");
//     output.innerHTML = "";
//     res.data.forEach(player => renderPlayers(player));
// }

//read
const output = document.getElementById("output");

const getPlayers = async () => {
    const res = await axios.get("/players/");
    output.innerHTML = "";
    res.data.forEach(player => renderPlayers(player));
}

const renderPlayers = ({ player_id, playerIGN, role }) => {
    const column = document.createElement("div");
    column.className = "col";

    const card = document.createElement("div");
    card.className = "card";
    column.appendChild(card);

    const cardBody = document.createElement("div");
    cardBody.className = "card-body";
    card.appendChild(cardBody);

    const playerIGNText = document.createElement("p");
    playerIGNText.className = "card-text";
    playerIGNText.innerText = `playerIGN: ${playerIGN}`;
    cardBody.appendChild(playerIGNText);

    const roleText = document.createElement("p");
    roleText.className = "card-text";
    roleText.innerText = `role: ${role}`;
    cardBody.appendChild(roleText);

    const cardFooter = document.createElement("div");
    cardFooter.className = "card-footer";
    card.appendChild(cardFooter);

    const deleteButton = document.createElement("a");
    deleteButton.innerText = "Delete";
    deleteButton.className = "card-link";
    deleteButton.addEventListener("click", function () {
        deletePlayers(player_id);
    });
    cardFooter.appendChild(deleteButton);

    output.appendChild(column);
}

getPlayers();
//create
document.getElementById("createTeam").addEventListener("submit", function (event) {
    event.preventDefault();

    const data = {
        playerIGN: this.playerIGN.value,
        role: this.role.value,

    }

    axios.post("/players/create", data)
        .then(res => {
            getPlayers();
            this.reset();
            this.make.focus();
        }).catch(err => console.log(err));

    console.log(this);
});



const deletePlayers = async (id) => {
    const res = await axios.delete(`/players/remove/${player_id}`);
    getPlayers();
};


