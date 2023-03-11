/*
Team 1
  Chih-Yin Chen
  Mathew Harbour-Nagy
  Yuanbo Yang
*/


const HOST = "http://localhost:8085";


// post
const createLibrary = () => {
  const name = document.querySelector("#nameInput").value;
  const address = document.querySelector("#addressInput").value;
  const zip = document.querySelector("#zipInput").value;
  const phoneNum = document.querySelector("#phoneNumInput").value;

  $.ajax({
    method: "POST",
    url: `${HOST}/montreal/libraries`,
    data: JSON.stringify({
      "name": name,
      "address": address,
      "zipCode": zip,
      "phoneNumber": phoneNum
    }),
    headers: {
      'Accept': "application/json",
      'Content-type': "application/json"
    },
  })
    .done((response) => alert("Succesful Insert"))
    .fail((obj, textStatus) => {
    if ((obj)) {
      alert(obj.statusText);
    }
  });
}

const btnSubmit = document.querySelector("#submit");
btnSubmit.addEventListener("click", createLibrary);



// get
const loadLibrary = () => {
  $.ajax({
    method: "GET",
    url: `${HOST}/montreal/libraries`
  })
  .done((response) => {
    for(const obj of response){
      document.querySelector("#loadData").innerHTML += '<label>' + obj.name + '</label>' + ' '
    }
  })
  .fail((obj, textStatus) => {
    if ((obj)) {
      alert(obj.statusText);
    }
  });  
}

const btnSearch = document.querySelector("#search");
btnSearch.addEventListener("click", loadLibrary);
