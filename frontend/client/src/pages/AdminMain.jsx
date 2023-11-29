import { useParams, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import axios from "axios";
import RedirButton from "../components/RedirButton";

const AdminMain = () => {
    const navigate = useNavigate()
    const params = useParams()
    const [id, setId] = useState('')
    const [name, setName] = useState('')
    const [competences, setCompetences] = useState([])
    const [teams, setTeams] = useState([])
    const [participants, setParticipants] = useState([])

    const [date, setDate] = useState('')
    const [period, setPeriod] = useState('')
    const [validity, setValidity] = useState('')
    const [category, setCategory] = useState('')

    useEffect(() => {

        getAdmin()

        async function getAdmin() {
            try {    
                const res = await axios.get(`http://localhost:8080/maraton/api/admin/${params.id}`)
                setId(res.data.idAdmin)
                setName(res.data.name)
                const comp = await axios.get("http://localhost:8080/maraton/api/competence/all")
                setCompetences(comp.data)
            } catch (error) {
                alert("admin not found")
                window.location.reload();
                navigate("/admin")
            }
        }

    })

    const handleSubmit = async (e) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/maraton/api/competence/save",
        {
            "date": date,
            "period": period,
            "validity": validity,
            "category": category
        })
        e.target.reset()
        window.location.reload();
    }

    return (
        <div>
            <RedirButton text={"back"} dir={"/admin"}/>
            <div className="flex items-start justify-center h-[calc(70vh-10rem)]">
                <form className="bg-zinc-950 p-10" onSubmit={handleSubmit}>
                    date: 
                    <input type="text" placeholder="yyyy-mm-ddT00:00:00"
                        className="block p-2 py-2 px-3 mb-4 w-full text-black"
                        onChange={(e) => setDate(e.target.value)}
                    ></input>
                    <input type="number" placeholder="period"
                        className="block p-2 py-2 px-3 mb-4 w-full text-black"
                        onChange={(e) => setPeriod(e.target.value)}
                    ></input>
                    validity: 
                    <input type="text" placeholder="yyyy-mm-ddT00:00:00"
                        className="block p-2 py-2 px-3 mb-4 w-full text-black"
                        onChange={(e) => setValidity(e.target.value)}
                    ></input>
                    <input type="text" placeholder="category"
                        className="block p-2 py-2 px-3 mb-4 w-full text-black"
                        onChange={(e) => setCategory(e.target.value)}
                    ></input>
                    <button>enter</button>
                </form>
            </div>
            <div className="grid grid-cols-3 gap-4 p-5">
                
                {competences.map(competence => (
                    <div key={competence.idCompetence} className="bg-zinc-950 p-4">
                        <p>{competence.name}</p>
                        <p><b>date:</b> {competence.date}</p>
                        <p><b>validity:</b> {competence.validity}</p>
                        
                        <button onClick={
                            async (e) => {
                                e.stopPropagation();
                                await axios.delete(`http://localhost:8080/maraton/api/competence/delete/${competence.idCompetence}`)
                                window.location.reload();
                            }
                        } className="p-1 bg-red-500">delete competence</button>
                    </div>
                ))}
            </div>
            <RedirButton text={"salir"} dir={"/admin"}/>
        </div>
    );
};

export default AdminMain;