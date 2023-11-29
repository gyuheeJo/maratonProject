import { useParams, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import axios from "axios";
import RedirButton from "../components/RedirButton";

const ParticipantMain = () => {

    const params = useParams()
    const navigate = useNavigate()
    const [text, setText] = useState('')
    const [dir, setDir] = useState('')
    const [id, setId] = useState('')
    const [name, setName] = useState('')
    const [competences, setCompetences] = useState([])
    const [idTeam, setIdTeam] = useState('')

    useEffect(() => {

        getParticipant()

        async function getParticipant() {
            try {    
                const res = await axios.get(`http://localhost:8080/maraton/api/participant/${params.id}`)
                setId(res.data.idParticipant)
                setName(res.data.name)
                
                if(res.data.idTeam){
                    setText("editar")
                    setDir(`/team/edit/${params.id}`)
                    const comp = await axios.get(`http://localhost:8080/maraton/api/competence/registration/${res.data.idTeam}`)
                    setCompetences(comp.data)
                    setIdTeam(res.data.idTeam)
                }else{
                    setText("crear")
                    setDir(`/team/register/${params.id}`)
                }
            } catch (error) {
                alert("particpant not found")
                window.location.reload();
                navigate("/participant")
            }
        }

    })

    return (
        <div>
            <RedirButton text={text} dir={dir}/>
            <div className="p-5">
                <h1>id: {id}</h1>
                <h1>name: {name}</h1>
            </div>
            <div className="p-5">
                <p>Competences:</p>
            </div>
            <div className="grid grid-cols-3 gap-4 p-5">
                
                {competences.map(competence => (
                    <div key={competence.idCompetence} className="bg-zinc-950 p-4">
                        <p>{competence.name}</p>
                        <p><b>date:</b> {competence.date}</p>
                        {competence.registered ?
                        <button onClick={
                            async (e) => {
                                e.stopPropagation();
                                await axios.delete("http://localhost:8080/maraton/api/teamcompetence/delete", 
                                    { data : {
                                        "team": idTeam,
                                        "competence": competence.idCompetence
                                    }})
                                window.location.reload();
                            }
                        } className="p-1 bg-red-500">unenroll</button> :
                        <button onClick={
                            async (e) => {
                                e.stopPropagation();
                                await axios.post("http://localhost:8080/maraton/api/teamcompetence/save", 
                                    {
                                        "team": idTeam,
                                        "competence": competence.idCompetence
                                    })
                                window.location.reload();
                            }
                        } className="p-1 bg-green-500">enroll</button>}
                    </div>
                ))}
            </div>
            <RedirButton text={"salir"} dir={"/participant"}/>
        </div>
        
    );
};

export default ParticipantMain;