import { useNavigate } from 'react-router-dom';

const RedirButton = ({dir, text}) => {
    const navigate = useNavigate()
    return (
        <div className='flex justify-end'>
                <button className='bg-orange-600 p-5 m-10' onClick={() => navigate(dir)}>
                    {text}
                </button>
        </div>
    );
};

export default RedirButton;