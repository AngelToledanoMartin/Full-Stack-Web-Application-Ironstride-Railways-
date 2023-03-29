//import "./css/passenger.css";
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

  const [trains, setTrains] = useState([]);

  const timestamp = new Date("2023-03-10");
  const timestampString = timestamp.toISOString();

  console.log(timestampString); // "2023-03-10T13:19:17.000Z"


  const handleClick = (e) => {
    e.preventDefault();
    const trains = { aStation, bStation, dateStart, dateArrive };
    console.log(trains);
    const test = "http://localhost:8080/stationShedule/search?filter=" + trains;
    const url = `http://localhost:8080/stationShedule/search?filter=${trains}`;
    console.log(test);
    fetch(url)
      .then((res) => res.json())
      .then((result) => {
        setTrains(result);
      });
  };

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
        {trains.map((train) => (
          <Paper
            elevation={3}
            style={{ margin: "10px", padding: "15px", textAlign: "left" }}
            key={train.idpassenger}
          >
            Id Shedule: {train.id_shedule}
            <br />
            Id Train: {train.id_train}
            <br />
          </Paper>
        ))}
      </Paper>
    </Box>
  );
}
