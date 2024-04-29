'use client'
import { isAuthenticated, setIsAuthenticated } from "@/app/Auth";
import { useLayoutEffect, useRef } from "react";
import { useRouter  } from "next/navigation";
import { getCookie, setCookie } from "cookies-next";

export default function page(){
    const router = useRouter()
    const elementRef = useRef();

    const handleHome = () => {
        router.push("/")
    }


    async function handleSubmit(e){
        e.preventDefault();

        const fname = elementRef.current.querySelector("#fname").value
        const fsurname = elementRef.current.querySelector("#fsurname").value
        const femail = elementRef.current.querySelector("#femail").value
        const fusername = elementRef.current.querySelector("#fusername").value
        const fpasswd = elementRef.current.querySelector("#fpasswd").value
        
        const formData = {
            first_name: fname,
            last_name: fsurname,
            email: femail,
            username: fusername,
            password: fpasswd,
        };
    
        try {
          const response = await fetch('http://localhost:8080/register', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
          });
    
          if (response.ok) {
            setCookie('loggedIn', true)
            router.push("/")
          } else {
            
          }
        } catch (error) {
            console.log(error)
        }
      }

    return(
        <main>
            <div className="mx-auto w-2/3 mt-14">
            <form className="mx-auto w-80 border-2 border-mainText rounded-xl p-10" ref={elementRef} onSubmit={handleSubmit}>  
                <div className="flex flex-col gap-5">
                    <div className="flex flex-col w-full">
                        <label className="text-base uppercase" htmlFor="fname">name</label>
                        <input required type="text" id="fname" name="fname" className="bg-mainBackground border-2 border-mainText rounded-md p-1"></input>
                    </div>
                    <div className="flex flex-col w-full">
                        <label className="text-base uppercase" htmlFor="fsurname">surname</label>
                        <input required type="text" id="fsurname" name="fsurname" className="bg-mainBackground border-2 border-mainText rounded-md p-1"></input>
                    </div>
                    <div className="flex flex-col w-full">
                        <label className="text-base uppercase" htmlFor="femail">email</label>
                        <input required type="text" id="femail" name="femail" className="bg-mainBackground border-2 border-mainText rounded-md p-1"></input>
                    </div>
                    <div className="flex flex-col w-full">
                        <label className="text-base uppercase" htmlFor="fusername">username</label>
                        <input required type="text" id="fusername" name="fusername" className="bg-mainBackground border-2 border-mainText rounded-md p-1"></input>
                    </div>

                    <div className="flex flex-col w-full">
                        <label className="text-base uppercase " htmlFor="fpasswd">password</label>
                        <input required type="password" id="fpasswd" name="fpasswd" className="bg-mainBackground border-2 border-mainText rounded-md p-1"></input>
                    </div>
                
                    <button className="w-full uppercase text-base border-2 border-mainText
                    bg-secondaryBackground hover:bg-secondaryHover rounded-md p-1 mt-10" type="submit" id="loadBtn" >register</button>
                    <button className="w-full uppercase text-base border-2 border-mainText
                    bg-secondaryBackground hover:bg-secondaryHover rounded-md p-1" type="button" onClick={handleHome}>home</button>
                </div>
            </form>
            
            </div>
        </main>
    )
}