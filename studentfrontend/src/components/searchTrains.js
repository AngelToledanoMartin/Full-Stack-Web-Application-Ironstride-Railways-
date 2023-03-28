import "./css/passenger.css";
import React, { useEffect, useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { Paper, Button } from "@mui/material";



export default function SearchTrains() {
  const paperStyle = {
    padding: "30px 30px",
    width: 600,
    margin: "40px auto",
    display: "flex",
    flexFlow: "column",
  };
  const boxForm = { margin: " auto auto 10px auto" };
  const buttons = { margin: "10px auto auto auto" };
  
  const [aStation, setAStation] = useState("");
  const [bStation, setBStation] = useState("");
  const [dateStart, setDateStart] = useState("");
  const [dateArrive, setDateArrive] = useState("");

  const [passengers, setPassengers] = useState([]);

  
  const handleClick = (e) => {
    e.preventDefault();
    const search = { aStation, bStation, dateStart, dateArrive };
    console.log(search);
    fetch("http://localhost:8080//", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(search),
    }).then(() => {
      console.log("New search");
    });
  };

  useEffect(() => {
    fetch("http://localhost:8080//")
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
        <h2 className="passengerTitle">Search trains</h2>
        <TextField
          id="outlined-basic"
          label="From Station:"
          variant="outlined"
          style={boxForm}
          fullWidth
          value={aStation}
          onChange={(e) => setAStation(e.target.value)}
        />

        <TextField
          id="outlined-basic"
          label="To Station:"
          variant="outlined"
          style={boxForm}
          fullWidth
          value={bStation}
          onChange={(e) => setBStation(e.target.value)}
        />
        <TextField
          id="outlined-basic"
          label="From Date:"
          variant="outlined"
          style={boxForm}
          fullWidth
          value={dateStart}
          onChange={(e) => setDateStart(e.target.value)}
        />
        <TextField
          id="outlined-basic"
          label="To Date:"
          variant="outlined"
          style={boxForm}
          fullWidth
          value={dateArrive}
          onChange={(e) => setDateArrive(e.target.value)}
        />

   

        <Button variant="contained" style={buttons} onClick={handleClick}>
          Search
        </Button>
      </Paper>

      
      <Paper elevation={3} style={paperStyle}>
      <h2 className="passengerTitle">Trains availables</h2>
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
