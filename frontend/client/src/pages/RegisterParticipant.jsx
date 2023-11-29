import {useState} from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios'
import RedirButton from '../components/RedirButton';

const RegisterParticipant = () => {
    const [id, setId] = useState('')
    const [name, setName] = useState('')
    const [code, setCode] = useState('')
    const [course, setCourse] = useState('')
    const navigate = useNavigate()

    const handleSubmit = async (e) => {
        e.preventDefault();
        
        await axios.post('http://localhost:8080/maraton/api/participant/save',
        {
            "idParticipant": id,
            "name": name,
            "codigo": code,
            "course": course
          })
        navigate("/participant")
        e.target.reset()

    }

    return (
        <div>
            <RedirButton dir={"/participant"} text={"back"}/>
            <div className="flex items-center justify-center h-[calc(70vh-10rem)]">
                <form className="bg-zinc-950 p-10" onSubmit={handleSubmit}>
                    <input type="text" placeholder="idParticipant"
                        className="block p-2 py-2 px-3 mb-4 w-full text-black"
                        onChange={(e) => setId(e.target.value)}
                    ></input>
                    <input type="text" placeholder="name"
                        className="block p-2 py-2 px-3 mb-4 w-full text-black"
                        onChange={(e) => setName(e.target.value)}
                    ></input>
                    <input type="number" placeholder="student code"
                        className="block p-2 py-2 px-3 mb-4 w-full text-black"
                        onChange={(e) => setCode(e.target.value)}
                    ></input>
                    <input type="text" placeholder="course"
                        className="block p-2 py-2 px-3 mb-4 w-full text-black"
                        onChange={(e) => setCourse(e.target.value)}
                    ></input>
                    <button>enter</button>
                </form>
            </div>
        </div>
        
    );
};

export default RegisterParticipant;