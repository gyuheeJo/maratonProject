import {useState} from 'react';
import { useParams , useNavigate} from 'react-router-dom';
import axios from 'axios'
import RedirButton from '../components/RedirButton';

const RegisterTeam = () => {
    const params = useParams()
    const [name, setName] = useState('')
    const [category, setCategory] = useState('')
    const navigate = useNavigate()

    const handleSubmit = async (e) => {
        e.preventDefault();
        const id = params.id
        await axios.post(`http://localhost:8080/maraton/api/team/save/${id}`,
        {
            "name": name,
            "category": category
          })
        navigate(`/participant/${params.id}`)
        e.target.reset()

    }

    return (
        <div>
            <RedirButton dir={`/participant/${params.id}`} text={"back"}/>
            <div className="flex items-center justify-center h-[calc(70vh-10rem)]">
                <form className="bg-zinc-950 p-10" onSubmit={handleSubmit}>
                    <input type="text" placeholder="name"
                        className="block p-2 py-2 px-3 mb-4 w-full text-black"
                        onChange={(e) => setName(e.target.value)}
                    ></input>
                    <input type="text" placeholder="category"
                        className="block p-2 py-2 px-3 mb-4 w-full text-black"
                        onChange={(e) => setCategory(e.target.value)}
                    ></input>
                    <button>enter</button>
                </form>
            </div>
        </div>
        
    );
};

export default RegisterTeam;