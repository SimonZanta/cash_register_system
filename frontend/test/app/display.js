async function getData() {
    const res = await fetch('http://localhost:8080/Person')
    // The return value is *not* serialized
    // You can return Date, Map, Set, etc.
   
    if (!res.ok) {
      // This will activate the closest `error.js` Error Boundary
      throw new Error('Failed to fetch data')
    }
   
    return res.json()
  }

export default async function Display(){
    const data = await getData();
  
    console.log(data.id)
    return(
        <div className="flex flex-col">
            {data.map((value) => (
              <div className="flex flex-row">
                <span className="w-20">{value.first_name}</span>
                <span className="w-24">{value.last_name}</span>
                <span className="w-60">{value.email}</span>
                <span >{value.gender}</span>
              </div>
            ))}
        </div>
    )
}