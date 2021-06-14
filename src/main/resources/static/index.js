'use strict';

const output = document.getElementById("output");

const getFantasyTeams = async () => {
    const res = await axios.get("/hwa/");
    output.innerHTML = "";
    res.data.forEach(fantasyTeams => renderFantasyTeam(fantasyTeams));
}

// const renderFantasyTeam = ({ team_id, teamName, mainTank, offTank, hitscanDPS, flexDPS, mainSupport, flexSupport }) => {
//     const column = document.createElement("div");
//     column.className = "col";

//     const card = document.createElement("div");
//     card.className = "card";
//     column.appendChild(card);

//     const cardBody = document.createElement("div");
//     cardBody.className = "card-body";
//     card.appendChild(cardBody);

//     const teamNameText = document.createElement("p");
//     teamNameText.className = "card-text";
//     teamNameText.innerText = `TeamName: ${teamName}`;
//     cardBody.appendChild(teamNameText);

//     const mainTankText = document.createElement("p");
//     mainTankText.className = "card-text";
//     mainTankText.innerText = `MainTank: ${mainTank}`;
//     cardBody.appendChild(mainTankText);

//     const offTankText = document.createElement("p");
//     offTankText.className = "card-text";
//     offTankText.innerText = `OffTank: ${offTank}`;
//     cardBody.appendChild(offTankText);

//     const hitscanDPSText = document.createElement("p");
//     hitscanDPSText.className = "card-text";
//     hitscanDPSText.innerText = `HitscanDPS: ${hitscanDPS}`;
//     cardBody.appendChild(hitscanDPSText);

//     const flexDPSText = document.createElement("p");
//     flexDPSText.className = "card-text";
//     flexDPSText.innerText = `FlexDPS: ${flexDPS}`;
//     cardBody.appendChild(flexDPSText);

//     const mainSupportText = document.createElement("p");
//     mainSupportText.className = "card-text";
//     mainSupportText.innerText = `MainSupport: ${mainSupport}`;
//     cardBody.appendChild(mainSupportText);

//     const flexSupportText = document.createElement("p");
//     flexSupportText.className = "card-text";
//     flexSupportText.innerText = `FlexSupport: ${flexSupport}`;
//     cardBody.appendChild(flexSupportText);


//     const cardFooter = document.createElement("div");
//     cardFooter.className = "card-footer";
//     card.appendChild(cardFooter);

//     const deleteButton = document.createElement("a");
//     deleteButton.innerText = "Delete";
//     deleteButton.className = "card-link";
//     deleteButton.addEventListener("click", function () {
//         deleteFantasyTeam(id);
//     });
//     cardFooter.appendChild(deleteButton);

//     output.appendChild(column);
// }

getFantasyTeams();

document.getElementById("createTeam").addEventListener("submit", function (event) {
    event.preventDefault();

    const data = {
        teamName: this.teamName.value,
        mainTank: this.mainTank.value,
        offTank: this.offTank.value,
        hitscanDPS: this.hitscanDPS.value,
        flexDPS: this.flexDPS.value,
        mainSupport: this.mainSupport.value,
        flexSupport: this.flexSupport.value
    }

    axios.post("/fantasyteams/create", data)
        .then(res => {
            getFantasyTeams();
            this.reset();
            this.make.focus();
        }).catch(err => console.log(err));

    console.log(this);
});

const deleteFantasyTeam = async (id) => {
    const res = await axios.delete(`/fantasyteams/remove/${team_id}`);
    getFantasyTeams();
};