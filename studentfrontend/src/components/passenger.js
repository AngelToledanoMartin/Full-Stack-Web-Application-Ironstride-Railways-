import "./css/passenger.module.css";
import React, { useEffect, useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { Paper, Button } from "@mui/material";

import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { DatePicker } from "@mui/x-date-pickers/DatePicker";

export default function Passenger() {
  const paperStyle = {
    padding: "30px 30px",
    width: 600,
    margin: "40px auto",
    display: "flex",
    flexFlow: "column",
  };
  const boxForm = { margin: " auto auto 10px auto" };
  const Date = { margin: "auto auto auto auto" };
  const buttons = { margin: "10px auto auto auto" };
  
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [birthday, setbirthday] = useState("");

  const [passengers, setPassengers] = useState([]);

  const handleClick = (e) => {
    e.preventDefault();
    const passenger = { name, surname, birthday };
    console.log(passenger);
    console.log(birthday);
    fetch("http://localhost:8080/passenger/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(passenger),
    }).then(() => {
      console.log("New Passenger added");
    });
  };

  useEffect(() => {
    fetch("http://localhost:8080/passenger/getAll")
      .then((res) => res.json())
      .then((result) => {
        setPassengers(result);
      });
  }, []);

  return (
    <Box
      component="form"
      sx={{
        "& > :not(style)": { m: 1, width: "25ch" },
      }}
      noValidate
      autoComplete="off"
    >
      <Paper elevation={3} style={paperStyle}>
        <h2 className="passengerTitle">Add a passenger</h2>
        <TextField
          id="outlined-basic"
          label="Passenger name"
          variant="outlined"
          style={boxForm}
          fullWidth
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <TextField
          id="outlined-basic"
          label="Surname"
          variant="outlined"
          style={boxForm}
          fullWidth
          value={surname}
          onChange={(e) => setSurname(e.target.value)}
        />
        
        <TextField
          id="outlined-basic"
          label="Birthday"
          variant="outlined"
          style={boxForm}
          fullWidth
          value={birthday}
          onChange={(e) => setbirthday(e.target.value)}
        />
    {
        /*
        <LocalizationProvider dateAdapter={AdapterDayjs} style={Date} >
          <DatePicker  value={birthday} onChange={(e) => setbirthday(e.target.value)}/>
        </LocalizationProvider>
        */
    }

        <Button variant="contained" style={buttons} onClick={handleClick}>
          Submit
        </Button>
      </Paper>

      
      <Paper elevation={3} style={paperStyle}>
      <h2 className="passengerTitle">Passengers</h2>
        {passengers.map(passenger=>(
        <Paper elevation={3} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={passenger.idpassenger}>
          id: {passenger.idpassenger}<br/>
          name: {passenger.name}<br/>
          surname: {passenger.surname}<br/>
          birthday: {passenger.birthday}<br/>

        </Paper>
        ))}

      </Paper>

    </Box>
  );
}
