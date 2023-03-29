//import "./css/passenger.css";
import React, { useEffect,useState } from "react";
import Box from "@mui/material/Box";

import { Paper, Button } from "@mui/material";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";

export default function SearchSchedule() {
  const paperStyle = {
    padding: "30px 30px",
    width: 600,
    margin: "40px auto",
    display: "flex",
    flexFlow: "column",
  };
  
  const buttons = { margin: "10px auto auto auto" };

  const [Station, setStation] = useState("");
  const [shedule, setShedule] = useState([]);
  const [stations, setStations] = useState([]);

  const handleClick = (e) => {
    e.preventDefault();
    const search = { Station };
    console.log(search);
    const test = 'http://localhost:8080/stationShedule/search?filter='+Station;
    const url = `http://localhost:8080/stationShedule/search?filter=${Station}`
    console.log(test);
    fetch(url)
      .then( res => res.json())
      .then((result) => {
        setShedule(result);
      });
      
  };  
 

  useEffect(() => {
    fetch("http://localhost:8080/station/getAll")
      .then((res) => res.json())
      .then((result) => {
        setStations(result);
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
        <h2 className="passengerTitle">Search a schedule's Station</h2>

        <FormControl fullWidth>
          <InputLabel id="demo-simple-select-label">
            Select a Station:
            
          </InputLabel>
          {/*
          <Select
            labelId="demo-simple-select-label"
            id="demo-simple-select"
            value={Station}
            label="Station"
            onChange={(e) => setStation(e.target.value)}
          
          >
            <MenuItem value={1}>Madrid</MenuItem>
            <MenuItem value={2}>Barcelona</MenuItem>
            <MenuItem value={3}>Granada</MenuItem>
            
          </Select>

           */}


      
      <Select
            labelId="demo-simple-select-label"
            id="demo-simple-select"
            value={Station}
            label="Station"
            onChange={(e) => setStation(e.target.value)}
          
          >
        {stations.map(station=>(
        <MenuItem value={station.id_station }key={station.id_station}>{station.name}</MenuItem>
        ))}
        </Select>
        
        
       




        </FormControl>

        <Button variant="contained" style={buttons} onClick={handleClick}>
          Search
        </Button>
      </Paper>

      <Paper elevation={3} style={paperStyle}>
        <h2 className="passengerTitle">Schedule</h2>
        {shedule.map((shedule) => (
          <Paper
            elevation={3}
            style={{ margin: "10px", padding: "15px", textAlign: "left" }}
            key={shedule.id_shedule}
          >	
            id: {shedule.id_shedule}
            <br />
            idStationStart: {shedule.id_station_start}
            <br />
            idStationEnd: {shedule.id_station_end}
            <br />
            dateStart: {shedule.date_start}
            <br />
            dateEnd: {shedule.date_end}
            <br />
            idTrain: {shedule.id_train}
            <br />
          </Paper>
        ))}
      </Paper>
    </Box>
  );
}
