import "./App.css";
import Appbar from "./components/appBar.js";
import Passenger from "./components/passenger.js";
import Train from "./components/train";
import Station from "./components/station";
import SearchTrains from "./components/searchTrains";
import SearchSchedule from "./components/searchSchedule";

function App() {
  return (
    <div className="App">
      <Appbar />
      <SearchTrains/>
      <Passenger />
      <SearchSchedule />
      {
        // Employees
      }
      <Station />
      <Train />
    </div>
  );
}

export default App;
