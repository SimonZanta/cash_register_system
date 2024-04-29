import { NextResponse } from "next/server"

export default function middleware(req){
    let verify = req.cookies.get("loggedIn")
    let url = req.nextUrl

    console.log(!(url.pathname == '/login'))

    if(verify === undefined && !(url.pathname == '/login')){
        return NextResponse.redirect('http://localhost:3000/login')
    }

    if(verify != undefined && url.pathname == '/login'){
        return NextResponse.redirect('http://localhost:3000/')
    }
    return NextResponse.next()
}

export const config = {
    matcher: [
      /*
       * Match all request paths except for the ones starting with:
       * - api (API routes)
       * - _next/static (static files)
       * - _next/image (image optimization files)
       * - favicon.ico (favicon file)
       */
      '/((?!api|_next/static|_next/image|favicon.ico).*)',
    ],
  }