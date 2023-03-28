
import './App.css';
import Appbar from './components/appBar.js';
import Passenger from './components/passenger.js';
import Train from './components/train';
import Station from './components/station';
import SearchTrains from './components/searchTrains';
import SearchShedule from './components/searchShedule';

function App() {
  return (
    <div className="App">
      <Appbar/>
      <Passenger/>
      <Train/>
      <Station/>
      
      <SearchShedule/>
    </div>
  );
}

export default App;
