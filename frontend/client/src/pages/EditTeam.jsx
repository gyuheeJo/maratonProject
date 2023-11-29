import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import RedirButton from "../components/RedirButton";

const EditTeam = () => {
    const params = useParams()
    const [members, setMembers] = useState([]);
    const [idP, setIdP] = useState('')
    const [idTeam, setIdTeam] = useState('')
    const [name, setName] = useState('')
    const [category, setCategory] = useState('')
    const navigate = useNavigate()
    
    const deleteParticipant = async (e) => {
        e.preventDefault();
        
        await axios.put(`http://localhost:8080/maraton/api/participant/leaveteam/${idP}`)
        window.location.reload();
    }
    const addParticipant = async (e) => {
        e.preventDefault();

        try {
            await axios.put(`http://localhost:8080/maraton/api/participant/update/${idP}/${idTeam}`)
        } catch (error) {
            alert("no se pudo agregar el participante")
        }
        
        window.location.reload();
    }

    useEffect(() => {

        getParticipant()

        async function getParticipant() {
                
                const res = await axios.get(`http://localhost:8080/maraton/api/participant/${params.idparticipant}`)
                console.log(res)
                if(res.data.idTeam){
                    setMembers(res.data.team.participants)
                    setIdTeam(res.data.team.idTeam)
                    setName(res.data.team.name)
                    setCategory(res.data.team.category)
                }else{
                    alert("particpant dont have team")
                    window.location.reload();
                    navigate(`/participant/${params.idparticipant}`)
                }
        }
    },[])
    return (
        <>
            <RedirButton text={"volver"} dir={`/participant/${params.idparticipant}`}/>
            <div className="p-5">
                <h1>Team name: {name}</h1>
                <h1>Category: {category}</h1>
            </div>
            <div className="grid grid-cols-4 gap-4 p-5">
                <p>Participants:</p>
                {members.map(member => (
                    <div key={member.idParticipant} className="bg-zinc-950 p-4">
                        <p><b>id:</b> {member.idParticipant}</p>
                        <p><b>name:</b> {member.name}</p>
                    </div>
                ))}
            </div>
            <div className='grid grid-cols-4 gap-5 p-5'>
                <input type="text" placeholder="idParticipant"
                className="block p-2 py-2 px-3 mb-4 w-full text-black"
                    onChange={(e) => setIdP(e.target.value)}
                ></input>
                <button onClick={addParticipant}>add to team</button>
                <button onClick={deleteParticipant}>remove from team</button>
            </div>
        </>
    );
};

export default EditTeam;