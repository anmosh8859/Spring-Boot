import FirstComponent from './FirstComponent.jsx'
import SecondComponent from './SecondComponent.jsx'
import ThirdComponent from './ThirdComponent.jsx'
import FourthComponent from './FourthComponent.jsx'
import {FifthComponent} from './FourthComponent.jsx';
import LearningJavaScript from './LearninJavaScript.jsx';

export default function LearningComponents(){
    return(
    <div className="App">
      My Todo Application
      <FirstComponent></FirstComponent>
      <SecondComponent></SecondComponent>
      <ThirdComponent></ThirdComponent>
      <FourthComponent></FourthComponent>
      <FifthComponent />
      <LearningJavaScript />
    </div>
    )
}