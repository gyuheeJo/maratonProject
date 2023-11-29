import {useState} from 'react';
import { useNavigate } from 'react-router-dom';

const LoginForm = ({RedirB, navgateRoute}) => {
    const [id, setId] = useState('')
    const navigate = useNavigate()

    const handleSubmit = async (e) => {
        e.preventDefault();
        
        navigate(`${navgateRoute}${id}`)

    }

    return (
        <div>
            {RedirB}
            <div className="flex items-center justify-center h-[calc(70vh-10rem)]">
                <form className="bg-zinc-950 p-10" onSubmit={handleSubmit}>
                    <input type="text" placeholder="id"
                        className="block p-2 py-2 px-3 mb-4 w-full text-black"
                        onChange={(e) => setId(e.target.value)}
                    ></input>
                    <button>enter</button>
                </form>
            </div>
            
        </div>
    );
};

export default LoginForm;