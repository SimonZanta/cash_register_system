'use client'
import { isAuthenticated, setIsAuthenticated } from "@/app/Auth";
import { useLayoutEffect, useRef } from "react";
import { useRouter  } from "next/navigation";
import { getCookie, setCookie } from "cookies-next";

export default function page(){
    const router = useRouter()
    const elementRef = useRef();   

    async function handleSubmit(e){
        e.preventDefault();
        setCookie('loggedIn', true)
        router.push("/")
    }

    return(
        <main>
            <div className="mx-auto w-2/3 mt-24">
            <form className="mx-auto w-80 border-2 border-mainText rounded-xl p-10" onSubmit={handleSubmit}>  
                <div className="flex flex-col gap-5">
                <div className="flex flex-col w-full">
                    <label className="text-base uppercase" htmlFor="fname">name</label>
                    <input type="text" id="fname" name="fname" className="bg-mainBackground border-2 border-mainText rounded-md p-1"></input>
                </div>

                <div className="flex flex-col w-full">
                    <label className="text-base uppercase " htmlFor="fpasswd">password</label>
                    <input type="password" id="fpasswd" name="fpasswd" className="bg-mainBackground border-2 border-mainText rounded-md p-1"></input>
                </div>
                <div className="w-full">
                    <button className="w-full uppercase text-base border-2 border-mainText
                    bg-secondaryBackground hover:bg-secondaryHover rounded-md p-1 mt-10" type="submit" id="loadBtn" >login</button>
                </div>
                </div>
            </form>
            </div>
        </main>
    )
}