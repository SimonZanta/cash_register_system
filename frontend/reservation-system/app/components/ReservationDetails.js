import { useRef } from "react";
import { getCurrentDateTime } from "../utils";

export default function ReservationDetails({desk}){
    const elementRef = useRef();

    
    //implement disabled for fname field
    const isInputCorrect = (elementRef) => {
      // const fname = elementRef.current.querySelector("#fname").value
      // console.log(fname)
      if(desk.length > 0 && fname != ""){
        return true
      }
      return false
    }
  
    async function handleSubmit(e){
      e.preventDefault();
  
      const fname = elementRef.current.querySelector("#fname").value
      const fstartTime = elementRef.current.querySelector("#fstartTime").value
      const fendTime = elementRef.current.querySelector("#fendTime").value
      // const fdesks = elementRef.current.querySelector("#fdesks")
      
      const formData = {
        name: fname,
        startTime: fstartTime,
        endTime: fendTime,
        deskIds: desk
      };
  
      try {
        const response = await fetch('http://localhost:8080/Reservation', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(formData)
        });
  
        if (response.ok) {
          window.location.reload();
        } else {
          
        }
      } catch (error) {
          console.log(error)
      }
    }

    const currentTime = getCurrentDateTime();
    console.log(currentTime)

    return(
        <form className="flex flex-col gap-3 uppercase" onSubmit={handleSubmit} ref={elementRef}>
            <div className="flex flex-col gap-2">           
              <label htmlFor="fname">name</label>
              <input type="text" id="fname" name="fname" className="bg-mainText text-mainBackground p-1 rounded-sm"></input>
            </div>
            <div className="flex flex-row gap-8">
              <div className="flex flex-col gap-2">
                <label htmlFor="fstartTime">reservation start</label>
                <input type="datetime-local" id="fstartTime" name="fstartTime" min={currentTime} value={currentTime} className="bg-mainText text-mainBackground p-1 rounded-sm"></input>
              </div>
              <div className="flex flex-col gap-2">
              <label htmlFor="fendTime">reservation end</label>
              <input type="datetime-local" id="fendTime" name="fendTime" value={getCurrentDateTime(1)} className="bg-mainText text-mainBackground p-1 rounded-sm"></input>
              </div>  
            </div>
            <div className="flex flex-col gap-2">
              <label htmlFor="fdesks">desks</label>
              <input type="text" id="fdesks" name="fdesks" className="bg-[#1A1A1A] text-mainText" value={desk} disabled readOnlzy={true}></input>
            </div>
            <button disabled={!isInputCorrect(elementRef)}  className={"w-fit mx-auto uppercase font-semibold text-mainBackground p-1 rounded-sm "  + (isInputCorrect(elementRef) ? "bg-mainText hover:scale-105" : "bg-red-700")} type="submit" id="loadBtn">save reservation</button>
        </form>
    )
}
