import React, { useEffect, useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { Paper, Button } from "@mui/material";

export default function Station() {
  const paperStyle = {
    padding: "30px 30px",
    width: 600,
    margin: "40px auto",
    display: "flex",
    flexFlow: "column",
  };
  const boxForm = { margin: " auto auto 10px auto" };
  const buttons = { margin: "10px auto auto auto" };

  const [name, setName] = useState("");
  const [stations, setStation] = useState([]);

  const handleClick = (e) => {
    e.preventDefault();
    const station = { name };
    console.log(station);
    fetch("http://localhost:8080/station/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(station),
    }).then(() => {
      console.log("New station added");
    });
  };

  useEffect(() => {
    fetch("http://localhost:8080/station/getAll")
      .then((res) => res.json())
      .then((result) => {
        setStation(result);
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
        <h1 className="passengerTitle" style={{color: "#3295a8"}}>- FOR EMPLOYEES -</h1>
      </Paper>

      <Paper elevation={3} style={paperStyle}>
        <h2 className="passengerTitle">Add a station</h2>

        <TextField
          id="outlined-basic"
          label="Name"
          variant="outlined"
          style={boxForm}
          fullWidth
          value={name}
          onChange={(e) => setName(e.target.value)}
        />

        <Button variant="contained" style={buttons} onClick={handleClick}>
          Submit
        </Button>
      </Paper>

      <Paper elevation={3} style={paperStyle}>
        <h2 className="passengerTitle">Stations</h2>
        {stations.map((station) => (
          <Paper
            elevation={3}
            style={{ margin: "10px", padding: "15px", textAlign: "left" }}
            key={station.id_station}
          >
            id: {station.id_station}
            <br />
            Name: {station.name}
            <br />
          </Paper>
        ))}
      </Paper>
    </Box>
  );
}
