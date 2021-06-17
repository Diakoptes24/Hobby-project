
const getteams = async () => {
    const tBody = document.querySelector("tbody");
    tBody.innerHTML = "";
    const res = await axios.get("/fantasyteams/");
    // output.innerHTML = "";
    res.data.forEach(team => {
        renderteam(team)
    });
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
            this.make.focus();
        }).catch(err => console.log(err));

    console.log(this);
});


