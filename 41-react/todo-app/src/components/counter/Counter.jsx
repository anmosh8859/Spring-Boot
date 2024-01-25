import { useState } from 'react'
import CounterButton from './CounterButton'
import './Counter.css'

export default function Counter(){

    const [count, setCount] = useState(0)

    function incrementCounterParentFunction(by){
        setCount(count+by)
    }
    
    function decrementCounterParentFunction(by){
        setCount(count-by)
    }

    function Reset(){
        setCount(0)
    }

    return (
        <>
            <CounterButton incrementMethod={incrementCounterParentFunction} decrementMethod={decrementCounterParentFunction} />
            <CounterButton by={2} incrementMethod={incrementCounterParentFunction} decrementMethod={decrementCounterParentFunction}/>
            <CounterButton by={5} incrementMethod={incrementCounterParentFunction} decrementMethod={decrementCounterParentFunction}/>
            <div className="totalCount">{count}</div>
            <button className='reset' onClick={Reset}> Reset </button>
        </>
    )
}