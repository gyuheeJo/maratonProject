import {BrowserRouter, Routes, Route} from 'react-router-dom'
import LoginForm from './pages/LoginForm'
import ParticipantMain from './pages/ParticipantMain';
import RegisterParticipant from './pages/RegisterParticipant';
import RedirButton from './components/RedirButton';
import RegisterTeam from './pages/RegisterTeam';
import EditTeam from './pages/EditTeam';
import AdminMain from './pages/AdminMain';

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/participant" element={<LoginForm navgateRoute={"/participant/"} RedirB={<RedirButton dir={"/participant/register"} text={"sign up"}/>}/>}/>
        <Route path="/participant/:id" element={<ParticipantMain/>}/>
        <Route path="/participant/register" element={<RegisterParticipant/>}/>
        <Route path="/team/edit/:idparticipant" element={<EditTeam/>}/>
        <Route path="/team/register/:id" element={<RegisterTeam/>}/>
        <Route path="/admin" element={<LoginForm navgateRoute={"/admin/"} />}/>
        <Route path="/admin/:id" element={<AdminMain/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
