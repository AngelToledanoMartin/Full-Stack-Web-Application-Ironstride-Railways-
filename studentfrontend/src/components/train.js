import React, { useEffect, useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { Paper, Button } from "@mui/material";


export default function Train() {
  const paperStyle = {
    padding: "30px 30px",
    width: 600,
    margin: "40px auto",
    display: "flex",
    flexFlow: "column",
  };

  const buttons = { margin: "10px auto auto auto" };

  const [avaliable_seats, setavaliable_seats] = useState("");
  const [trains, setTrains] = useState([]);

  const handleClick = (e) => {
    e.preventDefault();
    const train = { avaliable_seats };
    console.log(train);
    fetch("http://localhost:8080/train/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(train),
    }).then(() => {
      console.log("New Train added");
    });
  };

  useEffect(() => {
    fetch("http://localhost:8080/train/getAll")
      .then((res) => res.json())
      .then((result) => {
        setTrains(result);
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
        <h2 className="passengerTitle">Add a Train</h2>
        
         <TextField
          id="outlined-number"
          label="Seats Numbers Available"
          type="number"
          fullWidth
          value={avaliable_seats}
          onChange={(e) => setavaliable_seats(e.target.valueAsNumber)}
          pattern="[0-9]+"
          
        />

        <Button variant="contained" style={buttons} onClick={handleClick}>
          Submit
        </Button>
      </Paper>

      
      <Paper elevation={3} style={paperStyle}>
      <h2 className="passengerTitle">Trains</h2>
        {trains.map(train=>(
        <Paper elevation={3} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={train.id_Train}>
          id: {train.id_Train}<br/>
          Seats Numbers: {train.avaliable_seats}<br/>

        </Paper>
        ))}

      </Paper>

    </Box>
  );
}
