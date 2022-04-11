import axios from "axios";

class loginservice {
    getCustomerId(email) {
        return new Promise((resolve) => {
            fetch(`http://localhost:8087/custMail/${email}`)
            .then((response) => {response.json().then((jsonRes)=>{resolve(jsonRes)});})
            .catch((error) => { throw error; });
        });

    }


    checkUserLogin(logData){
        return new Promise((resolve)=>{
            fetch(`http://localhost:8087/userLogin`, {
                method: "POST",
                body: JSON.stringify(logData),
                headers: {
                  "Content-Type": "application/json",
                },
              }).then((response) => {response.json().then((jsonRes)=>{resolve(jsonRes)});})
              .catch((error) => { throw error; });
        });
    }

}
export default new loginservice();
